package proyecto;

import java.util.*;

public class Familia extends Observer{
    private Random random = new Random();
    private ArrayList<Cliente> integrantes;
    private List<Observer> observers;
    private boolean familiaComiendo = false;
    public int integrantesComiendo = 0;
}
