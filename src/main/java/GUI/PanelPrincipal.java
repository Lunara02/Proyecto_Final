package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class PanelPrincipal extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private PanelMenu PanelMenu;
    private PanelDificultad PanelDificultad;
    private PanelJuego PanelJuego;
    private PanelTutorial PanelTutorial;
    private PanelFinal PanelFinal;

    public PanelPrincipal() {
        setTitle("Cocina Explosiva");
        setSize(1295, 759);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicializa el CardLayout y el panel contenedor
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Inicializa los paneles individuales
        PanelMenu = new PanelMenu(this);
        PanelDificultad = new PanelDificultad(this);
        PanelJuego = new PanelJuego(this);
        PanelTutorial = new PanelTutorial(this);
        PanelFinal = new PanelFinal(this);

        // Agrega los paneles al panel contenedor con nombres específicos
        cardPanel.add(PanelMenu, "Menu");
        cardPanel.add(PanelDificultad, "Dificultad");
        cardPanel.add(PanelJuego, "Juego");
        cardPanel.add(PanelTutorial,"Tutorial");
        cardPanel.add(PanelFinal, "Final");

        // Agrega el panel contenedor al marco y muestra el panel inicial
        add(cardPanel);
        cardLayout.show(cardPanel, "Menu");
        setVisible(true);
    }

    public void showPanel(String panelName) {
        cardLayout.show(cardPanel, panelName);
        if(Objects.equals(panelName, "Juego")){
            PanelJuego.initialize();
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PanelPrincipal();
        });
    }
}
