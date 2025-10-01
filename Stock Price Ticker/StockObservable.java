// StockObservable.java
import java.util.List;

public interface StockObservable {
    void register(Investor observer);
    void deregister(Investor observer);
    void notifyObservers();
}