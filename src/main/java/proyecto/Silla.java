package proyecto;

public class Silla {
    private boolean ocupada;

    public Silla() {
        ocupada = false;
    }

    public void ocupar() {
        ocupada = true;
    }

    public void desocupar() {
        ocupada = false;
    }
}