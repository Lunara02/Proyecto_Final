package GUI;

import proyecto.*;
import Excepciones.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelCocina extends JPanel implements ObserverCustom {
    private ArrayList<Image> CocinaUsuario;
    private ArrayList<Image> PedidoGenerado;
    private Boton Enviar;
    private Boton Reset;
    private Boton Hamburguesa;
    private Boton Pizza;
    private Boton Tomato;
    private Boton lechuga;
    private Boton mayo;
    private Boton borgar;
    private Boton palto;
    private Boton kechu;
    private Boton panArr;
    private Boton panAbj;
    private Boton Peperonni;
    private Boton Aceitunas;
    private Boton champiñones;
    private Boton pimientos;
    private Boton Albahaca;
    private Boton masa;
    private Boton blanca;
    private Boton salsatomate;
    private Cocina cocina;
    private Sonido Sonido = new Sonido();
    private ImageIcon imagenCocina;
    private int TipoC, TipoP;

    public PanelCocina() {
    }

    private void SeleccionBotonesPizzaHamburguesa(){
        CocinaUsuario.clear();
        cocina.quitarIngrediente();
        Hamburguesa.setVisible(true);
        Pizza.setVisible(true);
        quitarIngredientes();
        repaint();
    }

    private void quitarIngredientes() {
        Tomato.setVisible(false);
        lechuga.setVisible(false);
        mayo.setVisible(false);
        borgar.setVisible(false);
        palto.setVisible(false);
        kechu.setVisible(false);
        panArr.setVisible(false);
        panAbj.setVisible(false);
        masa.setVisible(false);
        blanca.setVisible(false);
        champiñones.setVisible(false);
        pimientos.setVisible(false);
        Albahaca.setVisible(false);
        Peperonni.setVisible(false);
        Aceitunas.setVisible(false);
        salsatomate.setVisible(false);
    }

    private void ingredientesHamburguesa() {
        Tomato.setVisible(true);
        lechuga.setVisible(true);
        mayo.setVisible(true);
        borgar.setVisible(true);
        palto.setVisible(true);
        kechu.setVisible(true);
        panArr.setVisible(true);
        panAbj.setVisible(true);
        masa.setVisible(false);
        Aceitunas.setVisible(false);
        champiñones.setVisible(false);
        pimientos.setVisible(false);
        Albahaca.setVisible(false);
        Peperonni.setVisible(false);
        blanca.setVisible(false);
        salsatomate.setVisible(false);
    }

    private void ingredientesPizza() {
        Tomato.setVisible(false);
        lechuga.setVisible(false);
        mayo.setVisible(false);
        borgar.setVisible(false);
        palto.setVisible(false);
        kechu.setVisible(false);
        panArr.setVisible(false);
        panAbj.setVisible(false);
        masa.setVisible(true);
        blanca.setVisible(true);
        champiñones.setVisible(true);
        pimientos.setVisible(true);
        Albahaca.setVisible(true);
        Peperonni.setVisible(true);
        Aceitunas.setVisible(true);
        salsatomate.setVisible(true);
    }

    private void colocarImagen(JButton button, String nombre) {
        try {
            ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(nombre + ".png"));
            button.setIcon(icon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void PedidoClientes() {
        PedidoGenerado.clear();
        try{
            cocina.getPedidos();
            TipoP = cocina.getPedido().getTipo();
            for (Ingredientes ingrediente : cocina.getPedido().getReceta().getIngredientes()) {
                System.out.println(ingrediente);
                Image imagen = new ImageIcon(getClass().getClassLoader().getResource(ingrediente.getNombre() + ".png")).getImage();
                PedidoGenerado.add(imagen);
            }
            repaint();
        } catch (nullPedidos e){
            JOptionPane.showMessageDialog(null, "Todos los pedidos entregados", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void update(){
        PedidoClientes();
    }
    public void update1(){
        PedidoGenerado.clear();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenCocina.getImage(), 0, 0, this);
        if(TipoP == 1){
            for (int x = 0; x < PedidoGenerado.size(); x++) {
                g.drawImage(PedidoGenerado.get(x), 26, 177 - x * 17, this);
            }
        }
        else if(TipoP == 2){
            for (int x = 0; x < PedidoGenerado.size(); x++) {
                if(PedidoGenerado.get(x).equals((new ImageIcon(getClass().getClassLoader().getResource("salsatomate.png"))).getImage())){
                    g.drawImage(PedidoGenerado.get(x), 30, 120, this);
                }
                else if(PedidoGenerado.get(x).equals((new ImageIcon(getClass().getClassLoader().getResource("salsablanca.png"))).getImage())){
                    g.drawImage(PedidoGenerado.get(x), 30, 80, this);
                }
                else{
                    g.drawImage(PedidoGenerado.get(x), 21, 167, this);
                }

            }
        }
        if(TipoC == 1){
            for (int x = 0; x < CocinaUsuario.size(); x++) {
                g.drawImage(CocinaUsuario.get(x), 113, 312 - x * 15, this);
            }
        }
        else if(TipoC == 2){
            for (int x = 0; x < CocinaUsuario.size(); x++) {
                if(CocinaUsuario.get(x).equals((new ImageIcon(getClass().getClassLoader().getResource("salsatomate2.png"))).getImage())){
                    g.drawImage(CocinaUsuario.get(x), 175, 350, this);
                }
                else if(CocinaUsuario.get(x).equals((new ImageIcon(getClass().getClassLoader().getResource("salsablanca2.png"))).getImage())){
                    g.drawImage(CocinaUsuario.get(x), 210, 350, this);
                }
                else {
                    g.drawImage(CocinaUsuario.get(x), 72, 280, this);
                }
            }
        }
    }

}