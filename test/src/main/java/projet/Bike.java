package projet;

public class Bike extends Vehicle{

    public Bike(String id , double price , ColorEnum c){
        super(id, price, c);
    }

    @Override 
    public void accept(Visitor v ){

        v.visit(this);
    }

    @Override 
    public double cost(){
        return this.price;
    }
    
}
