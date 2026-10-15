package projet;

import java.util.ArrayList;
import java.util.List;

public class ClassiqMethod implements  DistributionMethods{


    public void redistributionMethod(List<Station> stations) throws MaxNumberVException{

        List<Station> dest = new ArrayList<>();
        List<Station> src = new ArrayList<>();

        for(Station st : stations){

            if((st.getnbV() == 0 && st.getTimeAlone() > 2)){
                dest.add(st);
            }
            if(st.getnbV() == st.getCapacity() && st.getTimeAlone() > 2){
                src.add(st);
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
    



