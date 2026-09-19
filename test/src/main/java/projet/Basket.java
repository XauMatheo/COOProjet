package projet;

public class Basket extends VehicleAccessoryDecorator{

    public Basket(Vehicle v){
        super(v);
    }

    public Float cost(){
        return this.v.cost() + 20;
    }

    @Override 
    public String toString(){
        return "Basket";
    }


    
}
