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

    public Boton(int Nombre, int x, int y, Mesa mesa){
        this.setBounds(x,y,140,60);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setOpaque(false);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (r.getComedor().getMesas().get(Nombre).getMesaDisponible()){
                    JOptionPane.showMessageDialog(null, "No hay familia", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    r.getCocina().limpiarPedidos();
                    r.tomarPedido(r.getComedor().getMesas().get(Nombre).getFamilia());
                }
            }
        });
    }

   

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}