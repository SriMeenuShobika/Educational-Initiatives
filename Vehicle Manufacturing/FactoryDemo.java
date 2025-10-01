// FactoryDemo.java
public class FactoryDemo {
    public static void main(String[] args) {
        System.out.println("--- Factory 1: Car Manufacturing Plant ---");
        // The client uses the concrete CarFactory.
        VehicleFactory carFactory = new CarFactory();
        carFactory.manufactureVehicle(); // Calls the manufactureVehicle logic defined in VehicleFactory
        
        System.out.println("\n--- Factory 2: Truck Manufacturing Plant ---");
        // The client uses the concrete TruckFactory.
        VehicleFactory truckFactory = new TruckFactory();
        truckFactory.manufactureVehicle(); // Uses the same logic but produces a different object type
    }
}