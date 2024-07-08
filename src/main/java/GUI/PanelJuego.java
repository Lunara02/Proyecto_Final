package GUI;

import proyecto.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelJuego extends JPanel {
    private PanelComedor comedor;
    private PanelCocina cocina;
    private Timer llegada;
    private Timer tiempoJuego;

    public void finalizarJuego(){
        Restaurante.getInstance().getCocina().limpiarPedidos();
        Restaurante.getInstance().getCocina().quitarIngrediente();
        Restaurante.getInstance().limpiarClientes();
        llegada.stop();
    }
}
