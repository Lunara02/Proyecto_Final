package proyecto;

import java.util.Random;
/**
 * La clase Pedido representa un pedido realizado por un cliente en el juego, con una receta específica y tipo de pedido.
 */
public class Pedido {
    private Receta receta;
    private Random random;
    private Cliente cl;
    private int numIngredientes, ingrediente, Tipo;

    /**
     * Constructor para crear un nuevo Pedido con una cantidad aleatoria de ingredientes, dependiendo del tipo y la dificultad.
     *
     * @param n          El tipo de pedido (1 para hamburguesa, 2 para pizza).
     * @param dificultad La dificultad del juego que afecta la cantidad de ingredientes del pedido.
     */
    public Pedido(int n, int dificultad) {
        random = new Random();
        receta = new Receta();
        numIngredientes = random.nextInt(3) + dificultad;
        if(n == 1){
            receta.add(Ingredientes.PAN_ABAJO);
            for(int i=0; i<numIngredientes;i++){
                ingrediente = random.nextInt(6)+10;
                receta.add(Ingredientes.values()[ingrediente]);
            }
            receta.add(Ingredientes.PAN_ARRIBA);
        }
        else if(n == 2){
            receta.add(Ingredientes.MASA);
            for(int i=0; i<numIngredientes;i++){
                int ingrediente = random.nextInt(7)+ 1;
                if(!receta.getIngredientes().contains(Ingredientes.values()[ingrediente])){
                    receta.add(Ingredientes.values()[ingrediente]);
                }
            }
        }
        Tipo = n;
    }
    /**
     * Obtiene la receta del pedido.
     *
     * @return La receta del pedido.
     */
    public Receta getReceta() {
        return receta;
    }
    /**
     * Obtiene el tipo de pedido (1 para hamburguesa, 2 para pizza).
     *
     * @return El tipo de pedido.
     */
    public int getTipo(){
        return Tipo;
    }
    /**
     * Establece el cliente asociado a este pedido.
     *
     * @param cl El cliente asociado al pedido.
     */
    public void setCliente(Cliente cl){
        this.cl = cl;
    }
    /**
     * Obtiene el cliente asociado a este pedido.
     *
     * @return El cliente asociado al pedido.
     */
    public Cliente getCliente(){
        return cl;
    }
}