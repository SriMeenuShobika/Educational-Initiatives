// CarFactory.java
public class CarFactory extends VehicleFactory {
    // This subclass implements the Factory Method to return a Car object.
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}