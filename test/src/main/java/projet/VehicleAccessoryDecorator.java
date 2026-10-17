package projet;

public abstract class VehicleAccessoryDecorator extends Vehicle{

    protected final Vehicle vehicle;

    protected VehicleAccessoryDecorator(Vehicle vehicle) {
        super(vehicle.getId() , vehicle.getPrice(), vehicle.getColor());
        this.vehicle = vehicle;
        
    }

    public abstract double cost();
    public double getPriceAccessory(){
        return this.price;
    }

    public abstract String toString();
}
