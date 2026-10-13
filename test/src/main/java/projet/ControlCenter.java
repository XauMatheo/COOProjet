package projet;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ControlCenter {

    Map<Integer, Station> station;
    List<Vehicle> VehicleIsUsingBy;
    private static ControlCenter instance;

    private Visitor repairer = new Repairer("Bob", null, 0, null, null);

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
        v.setNbLocations();
        this.VehicleIsUsingBy.add(v);
        st.removeVehicleById(VehicleId);
      

    }

   public void BackVehicleStation(Station st, String idVehicle)
        throws MaxNumberVException {

    Vehicle ve = null;

    for (int i = 0; i < VehicleIsUsingBy.size(); i++) {
        if (VehicleIsUsingBy.get(i).getId().equals(idVehicle)) {
            ve = VehicleIsUsingBy.remove(i);
            break;
        }
    }

    if (ve == null) {
        System.out.println("Vehicle not found");
        return;
    }

    if (ve.getNbLocations() == 1) {
        ve.visit(repairer);
    } else {
        ve.setState(new Available());
    }

    st.addVehicle(ve);
}



    public void VehicleGetRepaired(Station st , String idVehicle){

        Vehicle v = st.getVehicleById(idVehicle);

        if(v == null){
            System.out.println("Error with the Vehicle's ID");
            return;
        }

        v.setState(new Unvailable());
        System.out.println("Vehicle is being repaired");
        
    

    }

    public void FinishRepaired(Station st , String idVehicle){

        Vehicle v = st.getVehicleById(idVehicle);

        if(v == null){
            System.out.println("Error with the Vehicle's ID");
            return;
        }

        v.setState(new Available());
        v.initNbLocations();

    }





    }


    
    

