package proyecto;
import java.util.ArrayList;
/**
 * La clase Receta representa una receta en el juego, compuesta por una lista de ingredientes.
 */
public class Receta {
    public ArrayList<Ingredientes> ingredientes;
    /**
     * Constructor para crear una nueva receta inicialmente vacía.
     */
    public Receta() {
        ingredientes = new ArrayList<>();
    }
    /**
     * Añade un ingrediente a la receta.
     *
     * @param i El ingrediente a añadir a la receta.
     */
    public void add(Ingredientes i){
        ingredientes.add(i);
    }
    /**
     * Obtiene la lista de ingredientes de la receta.
     *
     * @return La lista de ingredientes de la receta.
     */
    public ArrayList<Ingredientes> getIngredientes(){
        return ingredientes;
    }
}