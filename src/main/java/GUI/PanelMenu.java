package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelMenu extends JPanel {
    private int C = -150;

    public PanelMenu(PanelPrincipal mainFrame) {
        setLayout(null);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Selecciona JUGAR
                if(e.getX()>=680 && e.getX()<=1096 && e.getY()>=428 && e.getY()<=539){
                    mainFrame.showPanel("Dificultad");
                }
                //Selecciona SALIR
                else if(e.getX()>=759 && e.getX()<=1070 && e.getY()>=559 && e.getY()<=654){
                    System.exit(0);
                }
            }
        });
    }
}