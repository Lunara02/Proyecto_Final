package GUI;

import proyecto.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelJuego extends JPanel {
    private PanelComedor comedor;
    private PanelCocina cocina;
    private Timer llegada;
    private Timer tiempoJuego;

    public PanelJuego(PanelPrincipal mainFrame) {
        this.setLayout(new BorderLayout());
        comedor = new PanelComedor();
        cocina = new PanelCocina();
        add(cocina, BorderLayout.CENTER);
        add(comedor, BorderLayout.WEST);
        tiempoJuego = new Timer(60 * 1000 * 5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarJuego();
                mainFrame.showPanel("Final");
                repaint();
            }
        });
    }
    
    public void initialize(){
        llegada = new Timer(6000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Restaurante.getInstance().nuevosClientes();
                repaint();
            }
        });
        comedor.comenzarTimer();
        llegada.start();
        tiempoJuego.start();
    }

    public void finalizarJuego(){
        Restaurante.getInstance().getCocina().limpiarPedidos();
        Restaurante.getInstance().getCocina().quitarIngrediente();
        Restaurante.getInstance().limpiarClientes();
        llegada.stop();
    }
}
