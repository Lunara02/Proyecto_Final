package GUI;

import proyecto.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * La clase PanelComedor representa el panel donde se muestra el comedor del restaurante.
 * Administra la disposición de las mesas, la llegada de clientes y el tiempo de juego.
 */
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

    /**
     * Constructor que inicializa el panel del comedor con mesas y configuraciones visuales.
     */
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

    /**
     * Método para iniciar el temporizador del juego.
     */
    public void comenzarTimer(){
        tiempoJuego.start();
    }

    /**
     * Método para dibujar componentes gráficos en el panel del comedor.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenFondo.getImage(), 0, 0,this);
        for (int X = 0; X < mesas.size(); X++) {
            g.drawImage((new ImageIcon(getClass().getClassLoader().getResource("silla2.png"))).getImage(), mesas.get(X).getX() - 24, mesas.get(X).getY(), this);
            g.drawImage((new ImageIcon(getClass().getClassLoader().getResource("silla1.png"))).getImage(), mesas.get(X).getX()  + 140 - 24, mesas.get(X).getY(), this);
            g.drawImage((new ImageIcon(getClass().getClassLoader().getResource("silla3.png"))).getImage(), mesas.get(X).getX() + 70 - 24, mesas.get(X).getY() - 30, this);
            g.drawImage(imagenMesas.getImage(), mesas.get(X).getX(), mesas.get(X).getY(), this);
            if (!mesas.get(X).getMesaDisponible() && mesas.get(X).getFamilia().getIntegrantes().size() >= 1){
                g.drawImage((new ImageIcon(getClass().getClassLoader().getResource("cliente.png"))).getImage(), mesas.get(X).getX() + 52, mesas.get(X).getY() + 58, this);
            }
            for(int Y = 0; Y < mesas.get(X).getSillas().size(); Y ++){
                if(!mesas.get(X).getMesaDisponible()){
                    if (mesas.get(X).getFamilia().getIntegrantes().size() >= 1){
                        if (mesas.get(X).getFamilia().getFamiliaComiendo()){
                            g.drawImage((new ImageIcon(getClass().getClassLoader().getResource("cliente2.png"))).getImage(), mesas.get(X).getX() + 52, mesas.get(X).getY() + 58, this);
                        }
                        else {
                            g.drawImage((new ImageIcon(getClass().getClassLoader().getResource("cliente.png"))).getImage(), mesas.get(X).getX() + 52, mesas.get(X).getY() + 58, this);
                        }
                    }
                    if (mesas.get(X).getFamilia().getIntegrantes().size() >= 2){
                        if (mesas.get(X).getFamilia().getFamiliaComiendo()){
                            g.drawImage((new ImageIcon(getClass().getClassLoader().getResource("cliente2.png"))).getImage(), mesas.get(X).getX() - 24, mesas.get(X).getY(), this);
                        }
                        else {
                            g.drawImage((new ImageIcon(getClass().getClassLoader().getResource("cliente.png"))).getImage(), mesas.get(X).getX() - 24, mesas.get(X).getY(), this);
                        }
                    }
                    if (mesas.get(X).getFamilia().getIntegrantes().size() >= 3){
                        if (mesas.get(X).getFamilia().getFamiliaComiendo()){
                            g.drawImage((new ImageIcon(getClass().getClassLoader().getResource("cliente2.png"))).getImage(), mesas.get(X).getX()  + 140 - 24, mesas.get(X).getY(), this);
                        }
                        else {
                            g.drawImage((new ImageIcon(getClass().getClassLoader().getResource("cliente.png"))).getImage(), mesas.get(X).getX()  + 140 - 24, mesas.get(X).getY(), this);
                        }
                    }
                    if (mesas.get(X).getFamilia().getIntegrantes().size() == 4){
                        if (mesas.get(X).getFamilia().getFamiliaComiendo()){
                            g.drawImage((new ImageIcon(getClass().getClassLoader().getResource("cliente2.png"))).getImage(), mesas.get(X).getX()  + 70 - 24, mesas.get(X).getY() - 30, this);
                        }
                        else {
                            g.drawImage((new ImageIcon(getClass().getClassLoader().getResource("cliente.png"))).getImage(), mesas.get(X).getX()  + 70 - 24, mesas.get(X).getY() - 30, this);
                        }
                    }
                }
            }
        }

        g.setColor(Color.BLACK);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        if (segundosRestantes == 60){
            g.setColor(Color.RED);
            Musica.getInstance().stopMusica();
            Musica.getInstance().playMusica("entradarapida");
        }
        else if(segundosRestantes == 180){
            g.setColor(Color.YELLOW);
        }

        g.drawString(segundosRestantes / 60 + ":" + String.format("%02d", segundosRestantes % 60), 65, 51);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        g.drawString(String.valueOf(Restaurante.getInstance().getCocina().getPuntuacion()), 65, 122);
        progressBar.setMaximum(Restaurante.getInstance().getCuota());
        progressBar.setValue(Restaurante.getInstance().getCocina().getPuntuacion());
    }
}