package projet;



import java.util.List;

public class MockVehicle extends Vehicle{


    public MockVehicle(String id,float price , ColorEnum c) {
        super(id ,price , c);
    }

    @Override 
    public float cost() {
        return this.price;
    }


    /* 
    @Override 
    public Float getPrice(){
        return this.price();
    }

    
    @Override 
    public Color getColor(){
        return this.color.toString();
    }
    */

  
    @Override 
    public void getAccessory(){
        for(VehicleAccessoryDecorator ac : this.accessories){
            System.out.println(ac.toString());
        }
    }
    
    @Override
    public void addAccessory(VehicleAccessoryDecorator acd) {
        this.accessories.add(acd);
        acd.cost();
    }

    /* 
    @Override 
    public State getState(){
        return this.state;
    }

    @Override 
    public int getNbLoc(){
        return this.nbloc;
    }

    @Override 
    public int getNbUnitTimeNotBorrowed(){
        return this.getnbUnitTimeNotBorrowed;
    }

    */


 

}
