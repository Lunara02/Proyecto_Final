package GUI;

import proyecto.Restaurante;

import javax.swing.*;
import java.awt.*;

public class PanelFinal extends JPanel {
    private Sonido sonidoFinal;
    private String calificacion;
    public PanelFinal(PanelPrincipal mainFrame){
        this.setLayout(new BorderLayout());
        this.setLayout(null);
        sonidoFinal = new Sonido();
        repaint();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage((new ImageIcon(getClass().getClassLoader().getResource("final.png"))).getImage(),0,0,this);
        Musica.getInstance().stopMusica();
        
    }
}
