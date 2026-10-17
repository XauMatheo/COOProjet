package projet;

public class Basket extends VehicleAccessoryDecorator {

    private double price = 20;

    public Basket(Vehicle vehicle) {
        
        super(vehicle);
    }

    @Override
    public double cost() {
        vehicle.setCost(vehicle.getPrice() + this.price); // 120
        return vehicle.getPrice();
    }

    @Override 
    public String toString(){
        return "Basket | Cost : "+this.price;
    }
    
    @Override 
    public void accept(Visitor v){
        
    }
    
}

