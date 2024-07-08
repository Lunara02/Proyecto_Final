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
}