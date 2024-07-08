package proyecto;

import java.util.*;

public class Familia extends Observer implements Observable{
    private Random random = new Random();
    private ArrayList<Cliente> integrantes;
    private List<Observer> observers;
    private boolean familiaComiendo = false;
    public int integrantesComiendo = 0;

    public Familia(int dificultad){
        integrantes = new ArrayList<>();
        observers=new ArrayList<>();
        for(int i=0; i<random.nextInt(4)+1;i++){
            Cliente cl = new Cliente(dificultad);
            integrantes.add(cl);
            cl.addObserver(this);
        }
    }

    public ArrayList<Cliente> getIntegrantes() {
        return integrantes;
    }

    public boolean getFamiliaComiendo(){
        return familiaComiendo;
    }

    @Override
    public void update() {
        integrantesComiendo++;
        if(integrantesComiendo==integrantes.size()){
            familiaComiendo=true;
            notifyObservers();
        }
    }

    @Override
    public void addObserver(Observer o){
        observers.add(o);
    }

    @Override
    public void notifyObservers(){
        for(Observer observer : observers){
            observer.update(this);
        }
    }
}
