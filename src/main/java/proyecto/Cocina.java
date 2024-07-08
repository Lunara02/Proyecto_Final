package proyecto;

import Excepciones.nullPedidos;

import java.util.*;

/**
 * La clase Cocina gestiona los pedidos y los ingredientes necesarios para preparar las comidas.
 */
public class Cocina {
    private ArrayList<Pedido> pedidos;
    private ArrayList<Ingredientes> cocinado;
    private int puntuacion, completo = 0;

    /**
     * Constructor que inicializa las listas de pedidos y cocinado.
     */
    public Cocina() {
        pedidos = new ArrayList<>();
        cocinado = new ArrayList<>();
    }

    /**
     * Añade un pedido a la lista de pedidos.
     * @param pedido el pedido a añadir.
     */
    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    /**
     * Devuelve el primer pedido de la lista de pedidos.
     * @return el primer pedido.
     */
    public Pedido getPedido() {
        return pedidos.getFirst();
    }

    /**
     * Devuelve todos los pedidos.
     * @return una lista de pedidos.
     * @throws nullPedidos si no hay pedidos.
     */
    public ArrayList<Pedido> getPedidos() throws nullPedidos {
        if (pedidos.isEmpty()) {
            throw new nullPedidos();
        }
        return pedidos;
    }

    /**
     * Limpia todos los pedidos de la lista.
     */
    public void limpiarPedidos() {
        pedidos.clear();
    }

    /**
     * Elimina el primer pedido de la lista.
     */
    public void limpiarPedido() {
        pedidos.removeFirst();
    }

    /**
     * Añade un ingrediente a la lista de ingredientes cocinados.
     * @param ingredientes el ingrediente a añadir.
     */
    public void agregarIngredientes(Ingredientes ingredientes) {
        cocinado.add(ingredientes);
    }

    /**
     * Devuelve la lista de ingredientes cocinados.
     * @return una lista de ingredientes.
     */
    public ArrayList<Ingredientes> getCocinado() {
        return cocinado;
    }

    /**
     * Elimina todos los ingredientes de la lista de cocinado.
     */
    public void quitarIngrediente() {
        cocinado.clear();
    }

    /**
     * Entrega un pedido si los ingredientes cocinados coinciden con la receta del pedido.
     * @return true si el pedido se entrega correctamente, false en caso contrario.
     */
    public boolean Entregar() {
        if (!pedidos.isEmpty()) {
            if (cocinado.equals(pedidos.getFirst().getReceta().getIngredientes()) && pedidos.getFirst().getTipo() == 1) {
                cocinado.clear();
                puntuacion += 50;
                return true;
            } else if (pedidos.getFirst().getTipo() == 2) {
                for (int x = 0; x < cocinado.size(); x++) {
                    if (pedidos.getFirst().getReceta().getIngredientes().contains(cocinado.get(x))) {
                        completo += 1;
                    }
                    else{
                        completo -= 1;
                    }
                }
                if (completo == pedidos.getFirst().getReceta().getIngredientes().size()) {
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

    /**
     * Devuelve la puntuación actual.
     * @return la puntuación.
     */
    public int getPuntuacion() {
        return puntuacion;
    }
}
