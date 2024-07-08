package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class PanelPrincipal extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private PanelJuego PanelJuego;

    public PanelPrincipal() {
        setTitle("Cocina Explosiva");
        setSize(1295, 759);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicializa el CardLayout y el panel contenedor
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
    }

    public void showPanel(String panelName) {
        cardLayout.show(cardPanel, panelName);
        if(Objects.equals(panelName, "Juego")){
            PanelJuego.initialize();
        }
    }
}
