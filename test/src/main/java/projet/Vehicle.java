package projet;
import java.util.ArrayList;
import java.util.List;



public abstract class Vehicle {

    protected  String id;
    protected float price;
    protected State state;
    protected int nbLoc;
    protected int nbNotUsed;
    protected ColorEnum color;

    
    protected List<VehicleAccessoryDecorator> accessories;


    public Vehicle(String id , float price, ColorEnum c){
        this.id = id;
        this.price = price;
        this.color = c;
        this.nbLoc = 0;
        this.nbNotUsed = 0;
        this.state = new Available();
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


    @Override public String toString(){
        return "Id : "+this.id + " | Price : " +this.price+ " | Color :" + this.color + " | NbLoc :" + this.nbLoc + " | State : " + this.state.currentState() ;
    }

    // Getter & Setter of Price

    public float getPrice(){
        return this.price;
    }

    public void setCost(float c){
        this.price = c ;
    }


    // Getter & Setter of State 

    public void setState(State s){
        this.state = s ;
    }

    public State getState(){
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

    // Getter & Setter of Number of Used by time 

    public int getNbNotUsed(){
        return this.nbNotUsed;
    }
        
    public void setNbNotUsed(){
        this.nbNotUsed += 1;
    }

    // Getter ID 

    public String getId(){
        return this.id;
    }


    public List<VehicleAccessoryDecorator> getAccessories(){
        return this.accessories;
    }

   


    
}
