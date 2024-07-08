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
}