package projet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Map;


public class RandomMethod implements DistributionMethods { 

    public void redistributionMethod(Map<Integer , Station> stations) throws MaxNumberVException{

        Random rd = new Random();
        int nbVehcle = rd.nextInt(5) +1;

        Station src = stations.get(rd.nextInt(stations.size()));
        Station dest = stations.get(rd.nextInt(stations.size()));
        
            while((src != dest && src.getnbV() >=1 && (dest.getnbV() != dest.getCapacity()))){
                src = stations.get(rd.nextInt(stations.size()));
                dest = stations.get(rd.nextInt(stations.size()));
                
            }
            
        while(nbVehcle != 0){

            Vehicle v = src.removeVehicle();
            dest.addVehicle(v);
            nbVehcle--;

        }

        }
        
    }
    

