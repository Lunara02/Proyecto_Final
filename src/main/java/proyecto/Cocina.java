package proyecto;

import Excepciones.nullPedidos;

import java.util.*;

public class Cocina {
    private ArrayList<Pedido> pedidos;
    private ArrayList<Ingredientes> cocinado;
    private int puntuacion, completo = 0;

    public Cocina(){
        pedidos = new ArrayList<>();
        cocinado = new ArrayList<>();
    }

    public void addPedido(Pedido pedido){
        pedidos.add(pedido);
    }

    public Pedido getPedido(){
        return pedidos.getFirst();
    }

    public ArrayList<Pedido> getPedidos() throws nullPedidos {
        if(pedidos.isEmpty()){
            throw new nullPedidos();
        }
        return pedidos;
    }

    public void limpiarPedidos(){
        pedidos.clear();
    }

    public void agregarIngredientes(Ingredientes ingredientes){
        cocinado.add(ingredientes);
    }

    public ArrayList<Ingredientes> getCocinado(){
        return cocinado;
    }

    public void quitarIngrediente(){
        cocinado.clear();
    }
}
