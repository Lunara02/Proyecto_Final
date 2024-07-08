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

}