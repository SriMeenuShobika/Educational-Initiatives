// TruckFactory.java
public class TruckFactory extends VehicleFactory {
    // This subclass implements the Factory Method to return a Truck object.
    @Override
    public Vehicle createVehicle() {
        return new Truck();
    }
}