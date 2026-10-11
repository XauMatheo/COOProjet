package projet;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ControlCenter {

    List<Station> station;
    List<Vehicle> VehicleIsUsingBy;
    private static ControlCenter instance;


    private ControlCenter(){

        this.station = new ArrayList<>();
        this.VehicleIsUsingBy = new ArrayList<>();
    
    }

    public static ControlCenter getControlCenter(){
        
        if(instance == null){
            return new ControlCenter();
        }

        return instance;

    }

    public void getVehicleUsing(){
        for(Vehicle v : VehicleIsUsingBy){
            System.out.print(v.toString());
        }
    }



    public void VehicleRented(Station st, String VehicleId){

        int find = 0;
        int idStation = st.getId();

        for(Station st2 : station){

            if(st2.getId() == idStation){
                find = 1;
                for(int i =0; i < st.getnbV(); i++){
                    Vehicle v =st2.getVehicleById(VehicleId);
                    if(v!= null){
                        v.setState(new Unvailable());
                        this.VehicleIsUsingBy.add(v);
                        st2.removeVehicleById(VehicleId);
                        
                    }
                }
            }
            if(find == 0){
                System.out.println("Cannot find the station");
            }
        }

    }
    }


    
    

