package GUI;

import proyecto.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class PanelComedor extends JPanel{
    private ArrayList<Mesa> mesas;
    private Random random;
    private ImageIcon imagenMesas;
    private ImageIcon imagenFondo;
    private int Breaker = 1;
    private Comedor comedor;
    private static Timer tiempoJuego;
    private int segundosRestantes = 300;
    private JProgressBar progressBar;

    public PanelComedor() {
        this.comedor = Restaurante.getInstance().getComedor();
        mesas = comedor.getMesas();
        this.setLayout(null);

        int x = 0;

        random = new Random();
        setPreferredSize(new Dimension(960, 720));
        setBackground(Color.RED);
        imagenFondo = new ImageIcon(getClass().getClassLoader().getResource("fondocomedor.png"));
        imagenMesas = new ImageIcon(getClass().getClassLoader().getResource("mesas.png"));

        progressBar = new JProgressBar(0, 500);
        progressBar.setBounds(295, 70, 500, 30);
        progressBar.setStringPainted(true);
        this.add(progressBar);


        tiempoJuego = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                segundosRestantes--;
                repaint();
            }
        });

        for (int X = 0; X < mesas.size(); X++) {
            while (true){
                mesas.get(X).setXY((random.nextInt(3) + 1) * 960 / 4 - 80,random.nextInt(3) * 145 + 230);
                for(int Y = 0; Y < mesas.size(); Y++){
                    if(mesas.get(X).getX() == mesas.get(Y).getX() && mesas.get(X).getY() == mesas.get(Y).getY() && X != Y){
                        Breaker = 0;
                    }
                }
                if(Breaker == 1){
                    this.add(new Boton(mesas.get(X).getNumMesa(), mesas.get(X).getX(), mesas.get(X).getY(), mesas.get(X)));
                    x += 1;
                    break;
                }
                Breaker = 1;
            }
        }
        repaint();
    }
}