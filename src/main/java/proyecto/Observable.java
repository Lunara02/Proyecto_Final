package proyecto;

public interface Observable {
    void addObserver(Observer observer);
    void notifyObservers();
}
