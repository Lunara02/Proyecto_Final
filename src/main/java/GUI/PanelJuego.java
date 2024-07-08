package GUI;

import proyecto.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase PanelJuego representa el panel principal del juego donde se muestra la cocina y el comedor.
 * Gestiona la llegada de clientes y el tiempo de juego.
 */
public class PanelJuego extends JPanel {
    private PanelComedor comedor;
    private PanelCocina cocina;
    private Timer llegada;
    private Timer tiempoJuego;

    /**
     * Constructor que inicializa el panel de juego con la cocina y el comedor.
     * @param mainFrame el marco principal del juego.
     */
    public PanelJuego(PanelPrincipal mainFrame) {
        this.setLayout(new BorderLayout());
        comedor = new PanelComedor();
        cocina = new PanelCocina();
        add(cocina, BorderLayout.CENTER);
        add(comedor, BorderLayout.WEST);
        tiempoJuego = new Timer(60 * 1000 * 5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarJuego();
                mainFrame.showPanel("Final");
                repaint();
            }
        });
    }

    /**
     * Método para inicializar el juego comenzando la llegada de clientes y activando el tiempo de juego.
     */
    public void initialize(){
        llegada = new Timer(6000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Restaurante.getInstance().nuevosClientes();
                repaint();
            }
        });
        comedor.comenzarTimer();
        llegada.start();
        tiempoJuego.start();
    }

    /**
     * Método para finalizar el juego limpiando los pedidos y clientes del restaurante.
     */
    public void finalizarJuego(){
        Restaurante.getInstance().getCocina().limpiarPedidos();
        Restaurante.getInstance().getCocina().quitarIngrediente();
        Restaurante.getInstance().limpiarClientes();
        llegada.stop();
    }

    /**
     * Método para pintar componentes gráficos en el panel.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
