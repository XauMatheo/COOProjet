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

 

}
