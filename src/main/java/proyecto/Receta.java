package proyecto;
import java.util.ArrayList;

public class Receta {
    public ArrayList<Ingredientes> ingredientes;

    public Receta() {
        ingredientes = new ArrayList<>();
    }

    public void add(Ingredientes i){
        ingredientes.add(i);
    }
        
    public ArrayList<Ingredientes> getIngredientes(){
        return ingredientes;
    }
}