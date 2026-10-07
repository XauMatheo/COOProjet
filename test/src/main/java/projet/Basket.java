package projet;

public class Basket extends VehicleAccessoryDecorator {

    private float price = 20;

    public Basket(Vehicle vehicle) {
        
        super(vehicle);
    }

    @Override
    public float cost() {
        vehicle.setCost(vehicle.getPrice() +price); // 120
        return vehicle.getPrice();
    }

    @Override 
    public String toString(){
        return "Basket | Cost : "+this.price;
    }
    
    
}

