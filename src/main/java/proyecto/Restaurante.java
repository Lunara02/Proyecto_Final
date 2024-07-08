package proyecto;

import java.util.*;

/**
 * La clase Restaurante gestiona la interacción entre el comedor, la cocina y los clientes.
 * Implementa los patrones de diseño Singleton, Observer.
 */
public class Restaurante extends Observer implements ObservableCustom {
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

    /**
     * Constructor que inicializa el comedor, la cocina, y los timers.
     */
    private Restaurante() {
        comedor = new Comedor(random.nextInt(6) + 4);
        cocina = new Cocina();
        clientes = new ArrayList<>();
        observers = new ArrayList<>();
        clients_leaves = new Timer();
        clients_finish = new Timer();
    }

    /**
     * Método para agregar nuevas familias al restaurante.
     * Sienta la familia en una mesa y la añade a la lista de observadores.
     */
    public void nuevosClientes() {
        Familia familia = new Familia(dificultad);
        clientes.add(familia);
        sentarFamilia(familia);
        familia.addObserver(this);
    }

    /**
     * Programa la retirada de los clientes del restaurante después de un cierto tiempo espera.
     * @param familia la familia que se va a retirar.
     */
    public void retiradaClientes(Familia familia) {
        clients_leaves.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!familia.getFamiliaComiendo()) {
                    for (Cliente cl : familia.getIntegrantes()) {
                        if (cocina.getPedido().getCliente() == cl) {
                            cocina.limpiarPedidos();
                            notifyObserversCustom1();
                        }
                    }
                    for (Mesa mesa : comedor.getMesas()) {
                        if (mesa.getFamilia() == familia) {
                            mesa.desocuparMesa();
                        }
                    }
                    clientes.remove(familia);
                }
            }
        }, 60000);
    }

    /**
     * Programa que los clientes terminen de comer después de un cierto tiempo para desocupar la mesa.
     * @param familia la familia que está comiendo.
     */
    public void comiendoClientes(Familia familia) {
        clients_finish.schedule(new TimerTask() {
            @Override
            public void run() {
                for (Mesa mesa : comedor.getMesas()) {
                    if (mesa.getFamilia() == familia) {
                        mesa.desocuparMesa();
                    }
                }
                clientes.remove(familia);
            }
        }, 5000);
    }

    /**
     * Toma el pedido de una familia y lo añade a la cocina.
     * @param familia la familia que hace el pedido.
     */
    public void tomarPedido(Familia familia) {
        for (int i = 0; i < familia.getIntegrantes().size(); i++) {
            if (familia.getIntegrantes().get(i).getPedido() != null) {
                cocina.addPedido(familia.getIntegrantes().get(i).getPedido());
            }
        }
        notifyObserversCustom();
    }

    /**
     * Sienta una familia en una mesa del comedor.
     * @param familia la familia que se va a sentar.
     */
    public void sentarFamilia(Familia familia) {
        if (comedor.sentarFamilia(familia)) {
            retiradaClientes(familia);
        } else {
            clientes.remove(familia);
        }
    }

    /**
     * Metodo Getter de comedor
     * @return comedor
     */
    public Comedor getComedor() {
        return comedor;
    }

    /**
     * Metodo Getter de cocina
     * @return cocina
     */
    public Cocina getCocina() {
        return cocina;
    }

    /**
     * Metodo Setter de dificultad
     */
    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    /**
     * Metodo Setter de cuota
     */
    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    /**
     * Metodo Getter de cuota
     * @return cuota
     */
    public int getCuota() {
        return cuota;
    }

    /**
     * Metodo que vacia clientes
     */
    public void limpiarClientes() {
        clientes.clear();
    }

    /**
     * Implementación del patrón Singleton.
     * @return la única instancia de Restaurante.
     */
    public static Restaurante getInstance() {
        if (instance == null) {
            instance = new Restaurante();
        }
        return instance;
    }

    /**
     * Implementacion Patron Observer
     */

    @Override
    public void update(Familia familia) {
        comiendoClientes(familia);
    }

    @Override
    public void addObserver(ObserverCustom o) {
        observers.add(o);
    }

    @Override
    public void notifyObserversCustom() {
        for (ObserverCustom observer : observers) {
            observer.update();
        }
    }

    public void notifyObserversCustom1() {
        for (ObserverCustom observer : observers) {
            observer.update1();
        }
    }
}
