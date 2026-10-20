package projet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Map;


public class RandomMethod implements DistributionMethods { 

    public void redistributionMethod(Map<Integer , Station> stations) throws MaxNumberVException{

        Random rd = new Random();
        int nbVehcle = rd.nextInt(5) +1;
        int counter = 0;

        List<Station> sta = new ArrayList<>(stations.values());
    
        Station src = sta.get(rd.nextInt(sta.size()));
        Station dest = sta.get(rd.nextInt(sta.size()));

        while((src.getId() == dest.getId())){
            src = sta.get(rd.nextInt(sta.size()));
            dest = sta.get(rd.nextInt(sta.size())); 
        }

        System.out.println("BEFORE redistribution : Station src ");
    
        src.getVehicle();

        System.out.println("BEFORE redistribution : Station dest ");

        dest.getVehicle();
        
    

            
        while(nbVehcle > src.getnbV() && src.getnbV() != 0){
            System.out.println("Struggle here");
            nbVehcle = rd.nextInt(src.getnbV()) +1;
        }
            

    
        while(nbVehcle != 0){

            if(dest.getnbV() == dest.getCapacity() && sta.size() > 2){
         
                Station previous = dest;
                Station current  = sta.get(rd.nextInt(sta.size()));
                while(previous == current){
                    previous = current;
                    current = sta.get(rd.nextInt(sta.size()));
                }
                
            }
            else if(sta.size() <= 2 && dest.getnbV() == dest.getCapacity()){
                System.out.println("Not enough station to continue the redistribution but "+counter+" vehicles were distributed");
                return;
       
            }
            Vehicle v = src.removeVehicle();
            dest.addVehicle(v);
            nbVehcle--;
            counter++;
            }
        

        


        System.out.println("AFTER redistribution : src ");

        src.getVehicle();

        System.out.println("AFTER redistribution : dest ");
                
        dest.getVehicle();
        

        System.out.println("Vehicles distributed : "+counter);
        

        }
        
    }


