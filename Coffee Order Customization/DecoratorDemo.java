// DecoratorDemo.java
public class DecoratorDemo {
    public static void main(String[] args) {
        System.out.println("--- Coffee Order Customization ---");
        
        // 1. Order 1: Simple Coffee
        Coffee order1 = new SimpleCoffee();
        System.out.println("\nOrder 1: " + order1.getDescription() + " | Cost: $" + order1.getCost()); // Output: Simple Coffee | Cost: $2.0

        // 2. Order 2: Simple Coffee decorated with Milk
        Coffee order2 = new SimpleCoffee();
        order2 = new MilkDecorator(order2);
        System.out.println("\nOrder 2: " + order2.getDescription() + " | Cost: $" + order2.getCost()); // Output: Simple Coffee, Milk | Cost: $2.5

        // 3. Order 3: Simple Coffee decorated with Milk, then decorated with Sugar
        Coffee order3 = new SimpleCoffee();
        order3 = new MilkDecorator(order3); // First layer of decoration
        order3 = new SugarDecorator(order3); // Second layer of decoration
        System.out.println("\nOrder 3: " + order3.getDescription() + " | Cost: $" + String.format("%.2f", order3.getCost())); // Output: Simple Coffee, Milk, Sugar | Cost: $2.60
    }
}