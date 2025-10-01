// ShoppingCart.java
public class ShoppingCart {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void checkout(double amount) {
        if (strategy == null) {
            System.out.println("Error: No payment strategy set.");
            return;
        }
        System.out.print("Processing payment of $" + amount + "...");
        strategy.pay(amount);
    }
}