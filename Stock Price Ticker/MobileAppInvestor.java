// MobileAppInvestor.java
public class MobileAppInvestor implements Investor {
    private String name;

    public MobileAppInvestor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println(name + " received update: " + stockName + " is now at $" + price);
    }

    @Override
    public String toString() {
        return "Investor " + name;
    }
}