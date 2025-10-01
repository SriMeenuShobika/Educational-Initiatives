// StrategyDemo.java
public class StrategyDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        double orderAmount = 150.75;

        System.out.println("--- 🛒 Checking out with Credit Card Strategy ---");
        // Set the strategy to Credit Card
        PaymentStrategy creditCard = new CreditCardPayment("Alice Smith", "1234567890123456");
        cart.setPaymentStrategy(creditCard);
        cart.checkout(orderAmount);

        System.out.println("\n--- 💸 Checking out with PayPal Strategy ---");
        // Change the strategy to PayPal at runtime
        PaymentStrategy payPal = new PayPalPayment("alice.smith@example.com");
        cart.setPaymentStrategy(payPal);
        cart.checkout(50.00); // A smaller, separate order
    }
}