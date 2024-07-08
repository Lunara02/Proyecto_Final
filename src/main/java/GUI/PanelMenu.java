package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * La clase PanelMenu es un panel que muestra la interfaz de menú principal del juego "Cocina Explosiva".
 * Permite al usuario seleccionar jugar o salir del juego.
 */
public class PanelMenu extends JPanel {
    private int C = -150;

    /**
     * Constructor que inicializa el panel de menú y configura el manejo de eventos de clic del mouse.
     * @param mainFrame el marco principal del juego.
     */
    public PanelMenu(PanelPrincipal mainFrame) {
        setLayout(null);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getX() >= 680 && e.getX() <= 1096 && e.getY() >= 428 && e.getY() <= 539) {
                    mainFrame.showPanel("Dificultad");
                }
                else if (e.getX() >= 759 && e.getX() <= 1070 && e.getY() >= 559 && e.getY() <= 654) {
                    System.exit(0);
                }
            }
        });
    }

    /**
     * Método que dibuja el fondo del panel de menú con una imagen.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage((new ImageIcon(getClass().getClassLoader().getResource("rest.png"))).getImage(),0,0,this);
    }
}
