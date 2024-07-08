package proyecto;

import java.util.*;

public class Cocina {
    private ArrayList<Pedido> pedidos;
    private ArrayList<Ingredientes> cocinado;
    private int puntuacion, completo = 0;

    public Cocina(){
        pedidos = new ArrayList<>();
        cocinado = new ArrayList<>();
    }
}
