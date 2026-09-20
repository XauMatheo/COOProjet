package projet;



import java.util.List;

public class MockVehicle extends Vehicle{


    public MockVehicle(float price) {
        super(price);
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
