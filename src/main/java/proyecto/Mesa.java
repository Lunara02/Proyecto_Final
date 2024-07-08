package proyecto;

import java.util.ArrayList;

public class Mesa {
    private int x = 0, y = 0;
    private ArrayList<Silla> sillas;
    private int numMesa;
    private boolean mesaDisponible = true;
    private Familia familia;

    public Mesa(int numMesa) {
        this.numMesa = numMesa;
        int cantidadSillas = 4;
        sillas = new ArrayList<>(cantidadSillas);
        for (int i = 0; i < cantidadSillas; i++) {
            sillas.add(new Silla());
        }
    }
}
