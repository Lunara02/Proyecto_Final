package proyecto;

import java.util.*;

public class Restaurante {
    private static Restaurante instance;
    private Comedor comedor;
    private Cocina cocina;
    private ArrayList<Familia> clientes;
    private Random random = new Random();
    private Timer clients_leaves;
    private Timer clients_finish;
    private List<ObserverCustom> observers;
    private int dificultad = 0;
    private int cuota = 1000;

    public Restaurante() {
        comedor = new Comedor(random.nextInt(6) + 4);
        cocina = new Cocina();
        clientes = new ArrayList<>();
        observers = new ArrayList<>();
        clients_leaves = new Timer();
        clients_finish = new Timer();
    }

    public void retiradaClientes(Familia familia){
        clients_leaves.schedule(new TimerTask() {
            @Override
            public void run() {
                if(!familia.getFamiliaComiendo()){
                    for(Cliente cl : familia.getIntegrantes()){
                        if(cocina.getPedido().getCliente() == cl){
                            cocina.limpiarPedidos();
                            //falta notif
                        }
                    }
                    for(Mesa mesa: comedor.getMesas()){
                        if(mesa.getFamilia() == familia){
                            mesa.desocuparMesa();
                        }
                    }
                    clientes.remove(familia);
                }
            }
        },60000);
    }

    public void comiendoClientes(Familia familia){
        clients_finish.schedule(new TimerTask() {
            @Override
            public void run() {
                for(Mesa mesa: comedor.getMesas()){
                    if(mesa.getFamilia()==familia){
                        mesa.desocuparMesa();
                    }
                }
                clientes.remove(familia);
            }
        },5000);
    }
}
