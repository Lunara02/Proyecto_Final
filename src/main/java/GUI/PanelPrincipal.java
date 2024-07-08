package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * La clase PanelPrincipal es un marco de ventana que utiliza CardLayout para gestionar múltiples paneles intercambiables.
 * Representa la interfaz principal del juego "Cocina Explosiva".
 */
public class PanelPrincipal extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private PanelMenu PanelMenu;
    private PanelDificultad PanelDificultad;
    private PanelJuego PanelJuego;
    private PanelTutorial PanelTutorial;
    private PanelFinal PanelFinal;

    /**
     * Constructor que inicializa el marco principal y los componentes principales del juego.
     */
    public PanelPrincipal() {
        setTitle("Cocina Explosiva");
        setSize(1295, 759);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        PanelMenu = new PanelMenu(this);
        PanelDificultad = new PanelDificultad(this);
        PanelJuego = new PanelJuego(this);
        PanelTutorial = new PanelTutorial(this);
        PanelFinal = new PanelFinal(this);
        cardPanel.add(PanelMenu, "Menu");
        cardPanel.add(PanelDificultad, "Dificultad");
        cardPanel.add(PanelJuego, "Juego");
        cardPanel.add(PanelTutorial, "Tutorial");
        cardPanel.add(PanelFinal, "Final");
        add(cardPanel);
        cardLayout.show(cardPanel, "Menu");
        setVisible(true);
    }

    /**
     * Método para mostrar un panel específico según su nombre.
     * @param panelName el nombre del panel a mostrar.
     */
    public void showPanel(String panelName) {
        cardLayout.show(cardPanel, panelName);
        if (Objects.equals(panelName, "Juego")) {
            PanelJuego.initialize();
        }
    }

    /**
     * Método principal que inicia la aplicación.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PanelPrincipal();
        });
    }
}
