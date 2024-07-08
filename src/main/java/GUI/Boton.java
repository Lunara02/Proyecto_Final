package GUI;

import proyecto.Ingredientes;
import proyecto.Mesa;
import proyecto.Restaurante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * La clase Boton extiende JButton y proporciona botones personalizados para la interfaz gráfica del restaurante.
 * Proporciona métodos para configurar acciones específicas según el tipo de botón.
 */
public class Boton extends JButton {
    Restaurante r = Restaurante.getInstance();

    /**
     * Constructor para crear un botón con dimensiones y características específicas.
     * @param x posición x del botón.
     * @param y posición y del botón.
     * @param ancho ancho del botón.
     * @param alto alto del botón.
     * @param relleno tipo de contorno del botón.
     */
    public Boton(int x, int y, int ancho, int alto, int relleno) {
        if (relleno == 1) {
            this.setContentAreaFilled(false);
            this.setFocusPainted(false);
            this.setOpaque(false);
        }
        this.setBounds(x, y, ancho, alto);
    }

    /**
     * Constructor para crear un botón asociado a una mesa específica.
     * @param Nombre número de la mesa.
     * @param x posición x del botón.
     * @param y posición y del botón.
     * @param mesa mesa asociada al botón.
     */
    public Boton(int Nombre, int x, int y, Mesa mesa){
        this.setBounds(x, y, 140, 60);
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

    /**
     * Constructor para crear un botón asociado a un ingrediente específico.
     * @param imageName nombre de la imagen asociada al ingrediente.
     * @param ingrediente ingrediente asociado al botón.
     * @param x posición x del botón.
     * @param y posición y del botón.
     * @param cocina panel donde se encuentra el botón.
     * @param cocinado lista de imágenes de ingredientes cocinados.
     * @param tipo tipo de botón (1 para hamburguesa, 2 para pizza).
     */
    public Boton(String imageName, Ingredientes ingrediente, int x, int y, JPanel cocina, ArrayList<Image> cocinado, int tipo) {
        this.setBounds(x, y, 70, 60);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ingrediente != null) {
                    if (tipo == 1) {
                        Restaurante.getInstance().getCocina().agregarIngredientes(ingrediente);
                        cocinado.add((new ImageIcon(getClass().getClassLoader().getResource(imageName + "2.png"))).getImage());
                    }
                    if (tipo == 2) {
                        if (!Restaurante.getInstance().getCocina().getCocinado().contains(ingrediente)) {
                            Restaurante.getInstance().getCocina().agregarIngredientes(ingrediente);
                            cocinado.add((new ImageIcon(getClass().getClassLoader().getResource(imageName + "2.png"))).getImage());
                        }
                    }
                }
                cocina.repaint();
            }
        });
        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(imageName + ".png")));
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setOpaque(false);
        cocina.add(this);
    }

    /**
     * Método para pintar componentes gráficos en el botón
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}