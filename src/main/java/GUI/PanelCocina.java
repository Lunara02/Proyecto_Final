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
}