package projet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;




public class ClassiqMethod implements  DistributionMethods{


    public void redistributionMethod(Map<Integer,Station> stations) throws MaxNumberVException{

        List<Station> dest = new ArrayList<>();
        List<Station> src = new ArrayList<>();

        for(Map.Entry<Integer,Station> entry : stations.entrySet()){

            if((entry.getValue().getnbV() == 0 && entry.getValue().getTimeAlone() > 2)){
                dest.add(entry.getValue());
            }
            if(entry.getValue().getnbV() == entry.getValue().getCapacity() && entry.getValue().getTimeAlone() > 2){
                src.add(entry.getValue());
            }

        }
      
            for(Station statSrc : dest){
                for(Station statDest : src){

                    int surplus = statSrc.getCapacity() / 2;
                    int available= statDest.getCapacity() - statDest.getnbV();

                    int moveVehicle = Math.min(available , surplus);
                    
                    for(int i = 0; i < moveVehicle ;i ++){
                        Vehicle v = statSrc.removeVehicle();
                        statDest.addVehicle(v);
                    }
                
                }

            }
                
        }


    }
    



