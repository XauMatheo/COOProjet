package projet;

public class Basket extends VehicleAccessoryDecorator {

    public Basket(Vehicle vehicle) {
        
        super(vehicle);
    }

    @Override
    public float cost() {
        vehicle.setCost(vehicle.getPrice() +20); // 120
        return vehicle.getPrice();
    }

    
}

