package projet;

public class Basket extends VehicleAccessoryDecorator {

    public Basket(Vehicle vehicle) {
        
        super(vehicle);
    }

    @Override
    public float cost() {
        return vehicle.cost() + 20;
    }
}
