package proyecto;

import java.util.*;

public class Cliente{
    private Pedido pedido;
    private int pedidoRandom;

    public Cliente(int dificultad){
        pedidoRandom = new Random().nextInt(2) + 1;
        pedido = new Pedido(pedidoRandom,dificultad);
        pedido.setCliente(this);
    }
}