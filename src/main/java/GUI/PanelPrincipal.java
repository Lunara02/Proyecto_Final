package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class PanelPrincipal extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private PanelJuego PanelJuego;
    

    public void showPanel(String panelName) {
        cardLayout.show(cardPanel, panelName);
        if(Objects.equals(panelName, "Juego")){
            PanelJuego.initialize();
        }
    }
}
