// VehicleFactory.java
// This abstract class declares the Factory Method.
public abstract class VehicleFactory {
    
    // The Factory Method
    public abstract Vehicle createVehicle();
    
    // An operation that uses the Factory Method, showing client logic
    public void manufactureVehicle() {
        Vehicle vehicle = createVehicle();
        System.out.print("Starting manufacturing process... ");
        vehicle.assemble();
    }
}