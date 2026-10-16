package projet;

import java.util.List;
import java.util.Random;

public class Simulation {

    private static final Random random = new Random();

    private List<Station> stations;
    private ControlCenter center; 

    public Simulation(List<Station> st , ControlCenter c){
        this.stations = st;
        this.center = c;
    }

    public void SimulateActions() throws MaxNumberVException{

        int withdrawal = random.nextInt(4)+1;
        int deposit = random.nextInt(4)+1;

        for(int i = 0; i < deposit ; i++){
            
            Station station = stations.get(random.nextInt(stations.size()));

            if(station.isFull() == false){
                Vehicle v = ControlCenter.getControlCenter().BackVehicleStation();
                station.addVehicle(v);
            }else{
                i = i -1;
            }
        }

        for(int i = 0; i < withdrawal; i++){

            Station station = stations.get(random.nextInt(stations.size()));
           

            if(station.isEmpty() == false){
                Vehicle v = station.removeVehicle();
                ControlCenter.getControlCenter().VehicleRented(v);

            }else{
                i = i -1;
            }
        }

    }
    
}
