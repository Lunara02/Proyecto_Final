package proyecto;

import java.util.ArrayList;

public class Comedor {
    private ArrayList<Mesa> mesas = new ArrayList<>();

    public Comedor(int canMesas) {
        for (int x = 0; x < canMesas; x++) {
            mesas.add(new Mesa(x));
        }
    }

    public ArrayList<Mesa> getMesas(){
        return mesas;
    }

    public boolean sentarFamilia(Familia familia){
        for(int i=0; i<mesas.size(); i++){
            if(mesas.get(i).ocuparMesa(familia)){
                return true;
            }
        }
        return false;
    }
}