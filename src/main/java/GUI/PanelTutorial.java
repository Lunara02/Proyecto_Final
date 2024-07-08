package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * La clase PanelTutorial es un panel que muestra un tutorial y permite avanzar al juego principal.
 */
public class PanelTutorial extends JPanel {

    /**
     * Constructor que inicializa el panel tutorial y agrega un botón para avanzar al juego principal.
     * @param mainFrame el panel principal que contiene este panel tutorial.
     */
    public PanelTutorial(PanelPrincipal mainFrame) {
        this.setLayout(null);
        JButton Termino = new JButton();
        Termino.setBounds(1150, 590, 52, 52);
        Termino.addActionListener(e -> mainFrame.showPanel("Juego"));
        Termino.setIcon(new ImageIcon(getClass().getClassLoader().getResource("seguir.png")));
        Termino.setContentAreaFilled(false);
        Termino.setFocusPainted(false);
        Termino.setOpaque(false);
        add(Termino);
        repaint();
    }

    /**
     * Método para dibujar la imagen del tutorial en el panel.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("tutorial.png")).getImage(), 0, 0, this);
    }
}
