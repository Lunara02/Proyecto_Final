package proyecto;

import java.util.*;

/**
 * La clase Cliente representa a un cliente que realiza pedidos en el restaurante.
 * Implementa la interfaz Observable para notificar a los observadores sobre cambios en su estado.
 */
public class Cliente implements Observable {
    private Pedido pedido;
    private List<Observer> observers;
    private int pedidoRandom;

    /**
     * Constructor que crea un nuevo Cliente con un pedido aleatorio basado en la dificultad.
     * @param dificultad la dificultad del pedido.
     */
    public Cliente(int dificultad) {
        pedidoRandom = new Random().nextInt(2) + 1;
        pedido = new Pedido(pedidoRandom, dificultad);
        pedido.setCliente(this);
        observers = new ArrayList<>();
    }

    /**
     * Devuelve el pedido del cliente.
     * @return el pedido del cliente.
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * Simula que el cliente está comiendo, estableciendo su pedido a null y notificando a los observadores.
     */
    public void clienteComiendo() {
        pedido = null;
        notifyObservers();
    }

    /**
     * Añade un observador a la lista de observadores.
     * @param o el observador a añadir.
     */
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    /**
     * Notifica a todos los observadores sobre un cambio de estado.
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}