// MilkDecorator.java
public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    // Adds milk description
    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }

    // Adds cost of milk
    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.5;
    }
}