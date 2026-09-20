package projet;

public abstract class VehicleAccessoryDecorator extends Vehicle{

    protected final Vehicle vehicle;

    protected VehicleAccessoryDecorator(Vehicle vehicle) {
        super(vehicle.getPrice());
        this.vehicle = vehicle;
        
    }

    public abstract float cost();
}
