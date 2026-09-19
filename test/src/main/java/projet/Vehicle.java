package projet;
import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

    protected Float price;
    protected List<VehicleAccessoryDecorator> accessories;


    public Vehicle(Float price){
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

    public abstract Float cost();

    // Getter & Setter 

    public Float getPrice(){
        return this.price;
    }

   


    
}
