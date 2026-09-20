package projet;
import java.util.ArrayList;
import java.util.List;



public abstract class Vehicle {

    protected float price;
    protected List<VehicleAccessoryDecorator> accessories;


    public Vehicle(float price){
        this.price = price;
        this.accessories = new ArrayList<VehicleAccessoryDecorator>();
    }


    public void addAccessory(VehicleAccessoryDecorator acd){
        this.accessories.add(acd);
    }




    public void getAccessory(){
        for(VehicleAccessoryDecorator ac : this.accessories){
            System.out.println(ac.toString());
        }
    }

    public abstract float cost();

    // Getter & Setter 

    public float getPrice(){
        return this.price;
    }

    public List<VehicleAccessoryDecorator> getAccessories(){
        return this.accessories;
    }

   


    
}
