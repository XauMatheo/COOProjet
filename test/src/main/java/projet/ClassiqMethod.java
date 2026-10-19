package projet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.text.Style;




public class ClassiqMethod implements  DistributionMethods{


    public void redistributionMethod(Map<Integer,Station> stations) throws MaxNumberVException{


        List<Station> dest = new ArrayList<>();
        List<Station> src = new ArrayList<>();

        for(Map.Entry<Integer,Station> entry : stations.entrySet()){

            if((entry.getValue().getnbV() == 0)){
                dest.add(entry.getValue());
            }
            if(entry.getValue().getnbV() == entry.getValue().getCapacity()){
                src.add(entry.getValue());
            }

        }

        System.out.println("BEFORE redistribution : Station src ");
    
        for(Station st : src ){
            st.getVehicle();
        }

      
            for(Station statSrc : src){
                for(Station statDest : dest){

                    int surplus = statSrc.getnbV() / 2;
                    int available= statDest.getCapacity() - statDest.getnbV();

                    
                    int moveVehicle = Math.min(available , surplus);

        
                    for(int i = 0; i < moveVehicle ;i ++){
                        Vehicle v = statSrc.removeVehicle();
                        statDest.addVehicle(v);
                    }
                
                }

            }
            
        System.out.println("AFTER redistribution : dest ");
                

        for(Station st : dest ){
            st.getVehicle();
        }

        System.out.println("AFTER redistribution : src ");

        for(Station st : src ){
            st.getVehicle();
        }
       
        }


    }
    



