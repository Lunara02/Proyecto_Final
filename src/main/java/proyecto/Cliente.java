package proyecto;

import java.util.*;
/**
 * La clase Cliente representa a un cliente en el juego, que realiza un pedido y notifica a los observadores cuando ha terminado de comer.
 */
public class Cliente{
    private Pedido pedido;
    private List<Observer> observers;
    private int pedidoRandom;
    /**
     * Constructor para crear un nuevo Cliente.
     *
     * @param dificultad La dificultad del juego que afecta el pedido del cliente.
     */
    public Cliente(int dificultad){
        pedidoRandom = new Random().nextInt(2) + 1;
        pedido = new Pedido(pedidoRandom,dificultad);
        pedido.setCliente(this);
        observers = new ArrayList<>();
    }
    /**
     * Obtiene el pedido del cliente.
     *
     * @return El pedido del cliente.
     */
    public Pedido getPedido() {
        return pedido;
    }

}