package projet;

public class Station {

    private int id;
    private int capacity;
    private int nbV;
    private Vehicle[] tabV;

    public Station(int id , int capacity){
        this.id = id;
        this.capacity = capacity;
        this.nbV = 0;
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


    // Show vehicles

    public void getVehicle(){
        for(int i = 0; i < nbV ; i++){
            System.out.println(tabV[i].toString());
        }
    }

    // Add Vehicle 

    public void addVehicle(Vehicle v){
        if (this.nbV == this.capacity){
            System.out.println("The Station is full, try another one.");
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
