// ObserverDemo.java
public class ObserverDemo {
    public static void main(String[] args) {
        // 1. Create the Subject (Observable)
        StockExchange googleStock = new StockExchange("GOOG", 1200.00);

        // 2. Create Observers (Subscribers)
        Investor alice = new MobileAppInvestor("Alice");
        Investor bob = new MobileAppInvestor("Bob");

        // 3. Register Observers
        googleStock.register(alice);
        googleStock.register(bob);

        // 4. State Change 1: Triggers update for Alice and Bob
        googleStock.setPrice(1205.50);

        // 5. Bob deregisters (unsubscribes)
        googleStock.deregister(bob);

        // 6. State Change 2: Only Alice receives the update
        googleStock.setPrice(1210.75);
    }
}