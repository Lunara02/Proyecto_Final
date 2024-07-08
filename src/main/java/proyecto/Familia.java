package proyecto;

import java.util.*;
/**
 * La clase Familia representa una familia en el juego, compuesta por varios clientes. Implementa el patrón Observable y Observer.
 */
public class Familia extends Observer implements Observable{
    private Random random = new Random();
    private ArrayList<Cliente> integrantes;
    private List<Observer> observers;
    private boolean familiaComiendo = false;
    public int integrantesComiendo = 0;
    /**
     * Constructor para crear una nueva Familia con un número aleatorio de integrantes.
     *
     * @param dificultad La dificultad del juego que afecta a los pedidos de los integrantes.
     */
    public Familia(int dificultad){
        integrantes = new ArrayList<>();
        observers=new ArrayList<>();
        for(int i=0; i<random.nextInt(4)+1;i++){
            Cliente cl = new Cliente(dificultad);
            integrantes.add(cl);
            cl.addObserver(this);
        }
    }
    /**
     * Obtiene la lista de integrantes de la familia.
     *
     * @return La lista de integrantes de la familia.
     */
    public ArrayList<Cliente> getIntegrantes() {
        return integrantes;
    }
    /**
     * Verifica si toda la familia ha terminado de comer.
     *
     * @return {@code true} si toda la familia ha terminado de comer; {@code false} en caso contrario.
     */
    public boolean getFamiliaComiendo(){
        return familiaComiendo;
    }
    /**
     * Método llamado cuando un integrante de la familia ha terminado de comer. Si todos los integrantes han terminado de comer, se notifica a los observadores.
     */
    @Override
    public void update() {
        integrantesComiendo++;
        if(integrantesComiendo==integrantes.size()){
            familiaComiendo=true;
            notifyObservers();
        }
    }
    /**
     * Añade un observador a la lista de observadores de la familia.
     *
     * @param o El observador a añadir.
     */
    @Override
    public void addObserver(Observer o){
        observers.add(o);
    }
    /**
     * Notifica a todos los observadores que la familia ha terminado de comer.
     */
    @Override
    public void notifyObservers(){
        for(Observer observer : observers){
            observer.update(this);
        }
    }
}
