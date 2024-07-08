package GUI;

import proyecto.Ingredientes;
import proyecto.Mesa;
import proyecto.Restaurante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Boton extends JButton {
    Restaurante r = Restaurante.getInstance();

    public Boton(int x, int y, int ancho, int alto, int relleno) {
        if (relleno == 1) {
            this.setContentAreaFilled(false);
            this.setFocusPainted(false);
            this.setOpaque(false);
        }
        this.setBounds(x,y,ancho,alto);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}