package proyecto;

import java.util.*;

public class Cliente implements Observable{
    private Pedido pedido;
    private List<Observer> observers;
    private int pedidoRandom;

    public Cliente(int dificultad){
        pedidoRandom = new Random().nextInt(2) + 1;
        pedido = new Pedido(pedidoRandom,dificultad);
        pedido.setCliente(this);
        observers = new ArrayList<>();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void clienteComiendo(){
        pedido = null;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o){
        observers.add(o);
    }

    @Override
    public void notifyObservers(){
        for(Observer observer : observers){
            observer.update();
        }
    }
}