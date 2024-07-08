package proyecto;

import java.util.Random;

public class Pedido {
    private Receta receta;
    private Random random;
    private Cliente cl;
    private int numIngredientes, ingrediente, Tipo;

    public Pedido(int n, int dificultad) {
        random = new Random();
        receta = new Receta();
    }

}