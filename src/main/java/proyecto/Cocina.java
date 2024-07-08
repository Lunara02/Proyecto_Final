package proyecto;

import Excepciones.nullPedidos;

import java.util.*;

public class Cocina {
    private ArrayList<Pedido> pedidos;
    private ArrayList<Ingredientes> cocinado;
    private int puntuacion, completo = 0;

    public Cocina() {
        pedidos = new ArrayList<>();
        cocinado = new ArrayList<>();
    }

    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public Pedido getPedido() {
        return pedidos.getFirst();
    }

    public ArrayList<Pedido> getPedidos() throws nullPedidos {
        if (pedidos.isEmpty()) {
            throw new nullPedidos();
        }
        return pedidos;
    }

    public void limpiarPedidos() {
        pedidos.clear();
    }

    public void limpiarPedido(){
        pedidos.removeFirst();
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

    public boolean Entregar(){
        if(!pedidos.isEmpty()){
            if(cocinado.equals(pedidos.getFirst().getReceta().getIngredientes()) && pedidos.getFirst().getTipo() == 1){
                cocinado.clear();
                puntuacion += 50;
                return true;
            }
            else if(pedidos.getFirst().getTipo() == 2){
                for(int x = 0; x < cocinado.size(); x++){
                    if(pedidos.getFirst().getReceta().getIngredientes().contains(cocinado.get(x))){
                        completo += 1;
                    }
                    else{
                        completo -= 1;
                    }
                }
                if(completo == pedidos.getFirst().getReceta().getIngredientes().size()){
                    completo = 0;
                    cocinado.clear();
                    puntuacion += 50;
                    return true;
                }
                else{
                    completo = 0;
                    return false;
                }
            }
        }
        return false;
    }
}
