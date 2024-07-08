package proyecto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

public class Restaurante {
    private static Restaurante instance;
    private Comedor comedor;
    private Cocina cocina;
    private ArrayList<Familia> clientes;
    private Random random = new Random();
    private Timer clients_leaves;
    private Timer clients_finish;
    private List<ObserverCustom> observers;
    private int dificultad = 0;
    private int cuota = 1000;
}
