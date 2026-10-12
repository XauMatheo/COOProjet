package projet;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ControlCenter {

    Map<Integer, Station> station;
    List<Vehicle> VehicleIsUsingBy;
    private static ControlCenter instance;


    private ControlCenter(){

        this.station = new HashMap<Integer, Station>();
        this.VehicleIsUsingBy = new ArrayList<>();
    
    }

    public static ControlCenter getControlCenter(){
        
        if(instance == null){
            instance = new ControlCenter();
            return instance;
        }

        return instance;

    }

    public void getVehicleUsing(){
        for(Vehicle v : VehicleIsUsingBy){
            System.out.print(v.toString());
        }
    }

    public void addMapStation(Station st){
        station.put(st.getId() , st);
    }

    public void showMapStation() {
    System.out.println("Nombre de stations : " + station.size());

    for (Map.Entry<Integer, Station> entry : station.entrySet()) {
        System.out.println(
            "Key : " + entry.getKey()
            + " Station : " + entry.getValue()
        );
    }
}



    public void VehicleRented(Station st, String VehicleId){

        int idStation = st.getId();

        Station s = station.get(idStation);

        if(s == null){
            System.out.println("This station doesn't exist");
            return;
        }
        Vehicle v= st.getVehicleById(VehicleId);

        if(v == null){
            System.out.println("This vehicle doesn't exist");
            return;
        }

        v.setState(new Unvailable());
        this.VehicleIsUsingBy.add(v);
        st.removeVehicleById(VehicleId);
        st.setNbV();

    }

public void BackVehicleStation(Station st, String idVehicle)throws MaxNumberVException {

    int idStation = st.getId();
    
    Vehicle ve = null;

    for (int i = 0; i < VehicleIsUsingBy.size(); i++) {
        if (VehicleIsUsingBy.get(i).getId().equals(idVehicle)) {
            ve = VehicleIsUsingBy.remove(i);
            break;
        }
    }

    
    if (ve != null) {
        ve.setState(new Available());
        station.get(idStation).addVehicle(ve);
    }
}
    }


    
    

