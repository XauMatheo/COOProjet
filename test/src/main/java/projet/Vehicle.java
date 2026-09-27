package projet;
import java.util.ArrayList;
import java.util.List;



public abstract class Vehicle {

    protected float price;
    protected StateEnum state;
    protected int nbLoc;
    protected ColorEnum color;

    
    protected List<VehicleAccessoryDecorator> accessories;


    public Vehicle(float price, ColorEnum c){
        this.price = price;
        this.color = c;
        this.nbLoc = 0;
        this.state = StateEnum.AVAILABLE;
        this.accessories = new ArrayList<VehicleAccessoryDecorator>();
    }


    public void addAccessory(VehicleAccessoryDecorator acd){
        this.accessories.add(acd);
        this.price = acd.cost();
    }




    public void getAccessory(){
        for(VehicleAccessoryDecorator ac : this.accessories){
            System.out.println(ac.toString());
        }
    }

    public abstract float cost();

    // Getter & Setter of Price

    public float getPrice(){
        return this.price;
    }

    public void setCost(float c){
        this.price = c ;
    }


    // Getter & Setter of State 

    public void setState(StateEnum s){
        this.state = s ;
    }

    public StateEnum getState(){
        return this.state;
    }


    // Getter & Setter of NbLocations

    public void setNbLocations(){
        this.nbLoc +=1;
    }

    public int getNbLocations(){
        return this.nbLoc;
    }

    // Getter of Color

    public ColorEnum getColor(){
        return this.color;
    }


    public List<VehicleAccessoryDecorator> getAccessories(){
        return this.accessories;
    }

   


    
}
