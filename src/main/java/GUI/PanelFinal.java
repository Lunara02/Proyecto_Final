package GUI;

import proyecto.Restaurante;

import javax.swing.*;
import java.awt.*;

/**
 * La clase PanelFinal extiende JPanel y representa el panel que muestra los resultados finales del juego.
 *
 * @autor Sebastian Ignacio Vega Varela
 */
public class PanelFinal extends JPanel {
    private Sonido sonidoFinal;
    private String calificacion;

    /**
     * Constructor para crear un PanelFinal e inicializar sus componentes.
     * Este constructor configura el panel final del juego e instancia sonidoFinal para reproducir sonido.
     *
     * @param mainFrame El panel principal que contiene este panel final.
     */
    public PanelFinal(PanelPrincipal mainFrame){
        this.setLayout(new BorderLayout());
        this.setLayout(null);
        sonidoFinal = new Sonido();
        repaint();
    }

    /**
     * Sobrescribe el método paintComponent para dibujar el contenido personalizado del panel final.
     * Este método dibuja la imagen de fondo del panel final y muestra la calificación y puntuación del juego,
     * así como el sonido correspondiente según el resultado.
     *
     * @param g El objeto Graphics que se utiliza para dibujar el componente.
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage((new ImageIcon(getClass().getClassLoader().getResource("final.png"))).getImage(),0,0,this);
        Musica.getInstance().stopMusica();
        int puntuacion = Restaurante.getInstance().getCocina().getPuntuacion();
        int cuota = Restaurante.getInstance().getCuota();

        String calificacion;

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
