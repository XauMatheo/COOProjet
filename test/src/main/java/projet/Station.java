package projet;

import java.util.Observer;

public class Station {

    private int id;
    private int capacity;
    private int nbV;
    private int TimeFull;
    private int TimeEmpty;
    private Vehicle[] tabV;

    public Station(int id , int capacity){
        this.id = id;
        this.capacity = capacity;
        this.nbV = 0;
        this.TimeEmpty = 0;
        this.TimeFull= 0;
        this.tabV = new Vehicle[capacity];
        
    }



    //Getter of capcity , id and nbV

    public int getId(){
        return this.id;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public int getnbV(){
        return this.nbV;
    }

    public int getTimeFull(){
        return this.TimeFull;
    }
    public int getTimeEmpty(){
        return this.TimeEmpty;
    }

    public void setTimeFull(){
        this.TimeFull = 0;
    }

    public void setTimeEmpty(){
        this.TimeEmpty = 0;
    }

    public void setNbV(){
        this.nbV--;
    }

    public Vehicle getVehicleById(String id){

        int trouve = 0;
        for(int i = 0; i < nbV ; i++){
            if(this.tabV[i] != null && this.tabV[i].getId().equals(id) && this.tabV[i].getState() instanceof Available){
                trouve = 1;
                return this.tabV[i];
            }
        }
        if(trouve == 0){
            System.out.println("Cannot find the vehicle, try again(vv)");
        }

        return null;

    }


    public void removeVehicleById(String id){

        int trouve = 0;
        for(int i = 0; i < nbV ; i++){
            if(this.tabV[i].getId() == id){
                trouve = 1;
                this.tabV[i] = null;
                return;
            }
        }
        if(trouve == 0){
            System.out.println("Cannot find the vehicle, try again");
        }

    }


    // Show vehicles

    public void getVehicle(){
        for(int i = 0; i < nbV ; i++){
            if(tabV[i] != null){
                 System.out.println(tabV[i].toString());
            }
           
        }
    }

    // Add Vehicle 

    public void addVehicle(Vehicle v) throws MaxNumberVException{
        if (this.nbV == this.capacity){
            throw new MaxNumberVException("Max number of Vehicle reach for this station");
        }else{
            for(int i = 0; i < capacity ; i++){
                if(tabV[i] == null){
                    tabV[i] = v ;
                    nbV++;
                    System.out.println("The vehicle has been set for this Station.");
                    break;
                }
            }
        }
    }


    
}
