package projet;

import java.util.Observer;

public class Station {

    private int timeAlone = 0; // Incrementer le compteur a chaque tour de temps 

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
        this.timeAlone = 0;
        
    }


    public int getTimeAlone(){
        return this.timeAlone;
    }

    public void setTimeAlone(){
        this.timeAlone++;
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

    


    public boolean isFull(){
        if(nbV == capacity){
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if(nbV == 0){
            return true;
        }

        return false;
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
            System.out.println("Cannot find the vehicle, try again");
        }

        return null;

    }


    public void removeVehicleById(String id){

        int trouve = 0;
        for(int i = 0; i < nbV ; i++){
            if (tabV[i] != null && tabV[i].getId().equals(id)){

                for(int j = i ; j < nbV  -1; j++){
                    tabV[j] = tabV[j+1];

                }

                tabV[nbV - 1] = null;
                nbV--;
                return;
            }
        }
    }
    public Vehicle removeVehicle(){
        for(int i = 0; i < nbV ; i++){
            if(tabV[i] != null){
                Vehicle v = tabV[i];
                tabV[i] = null;
                return v;
            }
        }
        return null;
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

     // -------------------------- LAST UPDATE ----------------------------------------------------

    public void setStateVehicle(){
        for(int i = 0 ; i < nbV ; i++){
            if(tabV[i].state instanceof Unvailable){
                tabV[i].state = new Available();
                tabV[i].nbLoc = 0;
            }
        }
    }

    public Vehicle getSingleVehicle(){
        for(int i = 0; i < nbV; i++){
            if(tabV[i] != null){
                return tabV[i];
            }
        }
        System.out.println("No vehicle in the station");
        return null;
    }

    



    
}
