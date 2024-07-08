package proyecto;

import java.util.*;

public class Restaurante extends Observer implements ObservableCustom{
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

    public void nuevosClientes(){
        Familia familia = new Familia(dificultad);
        clientes.add(familia);
        sentarFamilia(familia);
        familia.addObserver(this);
    }

    public void retiradaClientes(Familia familia){
        clients_leaves.schedule(new TimerTask() {
            @Override
            public void run() {
                if(!familia.getFamiliaComiendo()){
                    for(Cliente cl : familia.getIntegrantes()){
                        if(cocina.getPedido().getCliente() == cl){
                            cocina.limpiarPedidos();
                            notifyObserversCustom1();
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

    public void tomarPedido(Familia familia){
        for(int i=0; i<familia.getIntegrantes().size();i++){
            if(familia.getIntegrantes().get(i).getPedido() != null) {
                cocina.addPedido(familia.getIntegrantes().get(i).getPedido());
            }
        }
        notifyObserversCustom();
    }

    public void sentarFamilia(Familia familia){
        if(comedor.sentarFamilia(familia)){
            retiradaClientes(familia);
        }
        else{
            clientes.remove(familia);
        }
    }

    public Comedor getComedor(){
        return comedor;
    }

    public Cocina getCocina(){
        return cocina;
    }

    public void setDificultad(int dificultad){
        this.dificultad = dificultad;
    }

    public void setCuota(int cuota){
        this.cuota = cuota;
    }

    public int getCuota(){
        return cuota;
    }

    public void limpiarClientes(){
        clientes.clear();
    }

    public static Restaurante getInstance() {
        if (instance == null) {
            instance = new Restaurante();
        }
        return instance;
    }

    @Override
    public void update(Familia familia){
        comiendoClientes(familia);
    }

    @Override
    public void addObserver(ObserverCustom o){
        observers.add(o);
    }

    @Override
    public void notifyObserversCustom(){
        for(ObserverCustom observer : observers){
            observer.update();
        }
    }

    public void notifyObserversCustom1(){
        for(ObserverCustom observer : observers){
            observer.update1();
        }
    }
}
