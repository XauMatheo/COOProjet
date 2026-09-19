package projet;

public abstract class VehicleAccessoryDecorator extends Vehicle{
    
    protected Vehicle v;

    public VehicleAccessoryDecorator(Vehicle v){
        super(v.getPrice());
        this.v = v ;
    }

   
    public abstract String toString();
    

}
