// StockExchange.java
import java.util.ArrayList;
import java.util.List;

public class StockExchange implements StockObservable {
    private List<Investor> investors = new ArrayList<>();
    private String stockName;
    private double price;

    public StockExchange(String stockName, double initialPrice) {
        this.stockName = stockName;
        this.price = initialPrice;
    }

    // State change method (causes notification)
    public void setPrice(double newPrice) {
        System.out.println("\n--- Price Change: " + stockName + " is now $" + newPrice);
        this.price = newPrice;
        notifyObservers(); // Triggers the notification cycle
    }

    @Override
    public void register(Investor observer) {
        investors.add(observer);
        System.out.println(observer + " registered for " + stockName + " updates.");
    }

    @Override
    public void deregister(Investor observer) {
        investors.remove(observer);
        System.out.println(observer + " deregistered from " + stockName + " updates.");
    }

    @Override
    public void notifyObservers() {
        for (Investor investor : investors) {
            investor.update(stockName, price);
        }
    }
}