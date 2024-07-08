package proyecto;
/**
 * La clase Silla representa una silla en una mesa del juego, que puede estar ocupada o desocupada.
 */
public class Silla {
    private boolean ocupada;
    /**
     * Constructor para crear una nueva silla desocupada.
     */
    public Silla() {
        ocupada = false;
    }
    /**
     * Ocupa la silla.
     */
    public void ocupar() {
        ocupada = true;
    }
    /**
     * Desocupa la silla.
     */
    public void desocupar() {
        ocupada = false;
    }
}