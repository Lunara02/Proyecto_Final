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

    public ArrayList<Silla> getSillas() {
        return sillas;
    }

    public boolean ocuparMesa(Familia familia){
        if(mesaDisponible){
            for(int i=0;i<familia.getIntegrantes().size();i++){
                sillas.get(i).ocupar();
            }
            mesaDisponible = false;
            this.familia = familia;
            return true;
        }
        return false;
    }

    public void desocuparMesa(){
        for(int i=0; i<sillas.size();i++){
            sillas.get(i).desocupar();
        }
        familia = null;
        mesaDisponible = true;
    }

    public boolean getMesaDisponible(){
        return mesaDisponible;
    }

    public int getNumMesa() {
        return numMesa;
    }
}
