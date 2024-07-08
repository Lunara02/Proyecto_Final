package proyecto;

import java.util.*;
/**
 * La clase Comedor representa el comedor en el juego, gestionando las mesas y asignando familias a ellas.
 */
public class Comedor {
    private ArrayList<Mesa> mesas = new ArrayList<>();
    /**
     * Constructor para crear un nuevo Comedor con una cantidad específica de mesas.
     *
     * @param canMesas La cantidad de mesas a crear en el comedor.
     */
    public Comedor(int canMesas){
        for(int x = 0; x < canMesas; x++){
            mesas.add(new Mesa(x));
        }
    }
    /**
     * Obtiene la lista de mesas en el comedor.
     *
     * @return La lista de mesas.
     */
    public ArrayList<Mesa> getMesas(){
        return mesas;
    }
    /**
     * Sienta una familia en una mesa disponible en el comedor.
     *
     * @param familia La familia que se quiere sentar.
     * @return {@code true} si la familia fue sentada exitosamente; {@code false} en caso contrario.
     */
    public boolean sentarFamilia(Familia familia){
        for(int i=0; i<mesas.size(); i++){
            if(mesas.get(i).ocuparMesa(familia)){
                return true;
            }
        }
        return false;
    }
}