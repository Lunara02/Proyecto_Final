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
        int puntuacion = Restaurante.getInstance().getCocina().getPuntuacion();
        int cuota = Restaurante.getInstance().getCuota();


        if (puntuacion > cuota * 2) {
            calificacion = "S";
            sonidoFinal.playSonido("victoria");
        } else if (puntuacion >= cuota) {
            calificacion = "A";
            sonidoFinal.playSonido("victoria");
        } else if (puntuacion > cuota / 2) {
            calificacion = "B";
            sonidoFinal.playSonido("victoria");
        } else if (puntuacion > cuota / 3) {
            calificacion = "C";
            sonidoFinal.playSonido("medio");
        } else if (puntuacion > cuota / 4) {
            calificacion = "D";
            sonidoFinal.playSonido("derrota");
        } else if (puntuacion > cuota / 5) {
            calificacion = "E";
            sonidoFinal.playSonido("derrota");
        } else {
            calificacion = "F";
            sonidoFinal.playSonido("derrota");
        }

        g.setFont(new Font("Arial", Font.BOLD, 400));
        g.setColor(Color.WHITE);
        g.drawString(calificacion, 912, 500);

        g.setFont(new Font("Arial", Font.PLAIN, 50));
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(puntuacion/50), 593, 285);

        g.setFont(new Font("Arial", Font.PLAIN, 50));
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(puntuacion), 576, 420);

        g.setFont(new Font("Arial", Font.PLAIN, 80));
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(puntuacion + puntuacion/50), 340, 637);
    }
}
