package GUI;

import proyecto.Restaurante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelDificultad extends JPanel{
    public PanelDificultad(PanelPrincipal mainFrame) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Dificultad Facil
                if (e.getX() >= 675 && e.getX() <= 989 && e.getY() >= 281 && e.getY() <= 372) {
                    mainFrame.showPanel("Tutorial");
                    Musica.getInstance().playMusica("entrada");
                }
                //Dificultad Medio
                else if (e.getX() >= 667 && e.getX() <= 1007 && e.getY() >= 382 && e.getY() <= 494) {
                    mainFrame.showPanel("Tutorial");
                    Restaurante.getInstance().setDificultad(3);
                    Restaurante.getInstance().setCuota(1500);
                    Musica.getInstance().playMusica("entrada");
                }
                //Dificultad Dificil
                else if (e.getX() >= 658 && e.getX() <= 1044 && e.getY() >= 503 && e.getY() <= 607) {
                    mainFrame.showPanel("Juego");
                    Restaurante.getInstance().setDificultad(6);
                    Restaurante.getInstance().setCuota(2000);
                    Musica.getInstance().playMusica("entrada");
                }

            }
        });
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage((new ImageIcon(getClass().getClassLoader().getResource("salon.png"))).getImage(),0,0,this);
    }
}
