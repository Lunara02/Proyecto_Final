package proyecto;

import java.util.ArrayList;

/**
 * La clase Mesa representa una mesa en el comedor del juego, gestionando sus sillas y la familia que la ocupa.
 */
public class Mesa {
    private int x = 0, y = 0;
    private ArrayList<Silla> sillas;
    private int numMesa;
    private boolean mesaDisponible = true;
    private Familia familia;
    /**
     * Constructor para crear una nueva Mesa con un número específico de mesa.
     *
     * @param numMesa El número de la mesa.
     */
    public Mesa(int numMesa) {
        this.numMesa = numMesa;
        int cantidadSillas = 4;
        sillas = new ArrayList<>(cantidadSillas);
        for (int i = 0; i < cantidadSillas; i++) {
            sillas.add(new Silla());
        }
    }
    /**
     * Obtiene la lista de sillas de la mesa.
     *
     * @return La lista de sillas.
     */
    public ArrayList<Silla> getSillas() {
        return sillas;
    }
    /**
     * Ocupa la mesa con una familia si está disponible.
     *
     * @param familia La familia que quiere ocupar la mesa.
     * @return {@code true} si la mesa fue ocupada exitosamente; {@code false} en caso contrario.
     */
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
    /**
     * Desocupa la mesa y libera las sillas.
     */
    public void desocuparMesa(){
        for(int i=0; i<sillas.size();i++){
            sillas.get(i).desocupar();
        }
        familia = null;
        mesaDisponible = true;
    }
    /**
     * Verifica si la mesa está disponible.
     *
     * @return {@code true} si la mesa está disponible; {@code false} en caso contrario.
     */
    public boolean getMesaDisponible(){
        return mesaDisponible;
    }
    /**
     * Obtiene el número de la mesa.
     *
     * @return El número de la mesa.
     */
    public int getNumMesa() {
        return numMesa;
    }
    /**
     * Obtiene la familia que está ocupando la mesa.
     *
     * @return La familia que ocupa la mesa, o {@code null} si la mesa está desocupada.
     */
    public Familia getFamilia(){
        return familia;
    }
    /**
     * Establece las coordenadas de la mesa.
     *
     * @param x La coordenada X.
     * @param y La coordenada Y.
     */
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Obtiene la coordenada X de la mesa.
     *
     * @return La coordenada X.
     */
    public int getX() {
        return x;
    }
    /**
     * Obtiene la coordenada Y de la mesa.
     *
     * @return La coordenada Y.
     */
    public int getY() {
        return y;
    }
}