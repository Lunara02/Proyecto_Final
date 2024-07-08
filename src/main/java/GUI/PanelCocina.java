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
        
        CocinaUsuario = new ArrayList<>();
        PedidoGenerado = new ArrayList<>();
        Enviar = new Boton(240, 110, 50, 50, 1);
        Reset = new Boton(240, 30, 50, 50, 1);
        Hamburguesa = new Boton(50, 520, 100, 100, 1);
        Pizza = new Boton(160, 520, 100, 100, 1);
        Tomato = new Boton("tom", Ingredientes.TOMATE, 215, 450, this, CocinaUsuario, 1);
        lechuga = new Boton("lech", Ingredientes.LECHUGA, 35, 520, this , CocinaUsuario, 1);
        mayo = new Boton("mayo", Ingredientes.MAYO, 125, 520, this, CocinaUsuario, 1);
        borgar = new Boton("borga", Ingredientes.HAMBURGUESA, 215, 520, this, CocinaUsuario, 1);
        palto = new Boton("palto", Ingredientes.PALTA, 35, 590, this , CocinaUsuario, 1);
        kechu = new Boton("kechu", Ingredientes.KETCHUP, 125, 590, this, CocinaUsuario, 1);
        panArr = new Boton("panArr", Ingredientes.PAN_ARRIBA, 35, 450, this, CocinaUsuario, 1);
        panAbj = new Boton("panAbj", Ingredientes.PAN_ABAJO, 125, 450, this, CocinaUsuario, 1);
        Peperonni = new Boton("peperonni", Ingredientes.PEPERONI, 215, 520, this, CocinaUsuario, 2);
        Aceitunas = new Boton("aceitunas", Ingredientes.ACEITUNAS, 125, 450, this, CocinaUsuario, 2);
        champiñones = new Boton("champiñones", Ingredientes.CHAMPIÑONES, 215, 450, this, CocinaUsuario, 2);
        pimientos = new Boton("pimientos", Ingredientes.PIMIENTOS, 35, 520, this, CocinaUsuario, 2);
        Albahaca = new Boton("albahaca", Ingredientes.ALBAHACA, 125, 520, this, CocinaUsuario, 2);
        masa = new Boton("masa", Ingredientes.MASA, 35, 450, this, CocinaUsuario, 2);
        blanca = new Boton("salsablanca", Ingredientes.BLANCA, 35, 590, this, CocinaUsuario, 2);
        salsatomate = new Boton("salsatomate", Ingredientes.SALSA, 125, 590, this, CocinaUsuario, 2);

        this.cocina = Restaurante.getInstance().getCocina();
        setPreferredSize(new Dimension(320, 720));
        imagenCocina = new ImageIcon(getClass().getClassLoader().getResource("XDDD.png"));
        this.setLayout(new BorderLayout());
        this.setLayout(null);
        colocarImagen(Reset, "return");
        colocarImagen(Enviar, "enviar");
        colocarImagen(Hamburguesa, "panAbj");
        colocarImagen(Pizza, "masa");
        quitarIngredientes();
        Restaurante.getInstance().addObserver(this);

        Enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cocina.getPedidos();
                    if(cocina.Entregar()){
                        System.out.println("Pedido entregado");
                        cocina.getPedido().getCliente().clienteComiendo();
                        cocina.limpiarPedido();
                        Sonido.playSonido("acierto");
                        SeleccionBotonesPizzaHamburguesa();
                        PedidoClientes();
                    }
                    else{
                        Sonido.playSonido("error");
                        SeleccionBotonesPizzaHamburguesa();
                    }
                } catch (nullPedidos a){
                    JOptionPane.showMessageDialog(null, "No hay pedidos", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        Reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SeleccionBotonesPizzaHamburguesa();
            }
        });

        Hamburguesa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingredientesHamburguesa();
                Sonido.playSonido("burger");
                Hamburguesa.setVisible(false);
                Pizza.setVisible(false);
                TipoC = 1;
            }
        });

        Pizza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingredientesPizza();
                Sonido.playSonido("pissa");
                Hamburguesa.setVisible(false);
                Pizza.setVisible(false);
                TipoC = 2;
            }
        });

        add(Enviar);
        add(Reset);
        add(Hamburguesa);
        add(Pizza);
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