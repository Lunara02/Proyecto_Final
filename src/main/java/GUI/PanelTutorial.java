package GUI;

import javax.swing.*;
import java.awt.*;

public class PanelTutorial extends JPanel{
    public PanelTutorial(PanelPrincipal mainFrame){
        this.setLayout(new BorderLayout());
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
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage((new ImageIcon(getClass().getClassLoader().getResource("tutorial.png"))).getImage(),0,0,this);
    }
}
