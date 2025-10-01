// SugarDecorator.java
public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    // Adds sugar description
    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }

    // Adds cost of sugar
    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.1;
    }
}