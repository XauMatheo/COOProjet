package projet;

public class App {

    public static void main(String[] agrs){

        int CounterTime = 0; // General counter 



        Vehicle v= new MockVehicle("BB-011",100,ColorEnum.BLACK);
        Vehicle v2= new MockVehicle("BB-89" , 150,ColorEnum.RED);
        VehicleAccessoryDecorator vad = new Basket(v);

        float priceB = v.getPrice();
        v.addAccessory(vad);

        
        float priceA= v.getPrice();


        System.out.println(priceB);
        System.out.println(priceA);
        System.out.println(vad.getPrice());

        System.out.println(v.getState());

        Station s = new Station(123, 2) ;

        try{
             s.addVehicle(v);
            s.addVehicle(v2);

        }catch(MaxNumberVException e){
            System.out.println(e.getMessage());
        }

       
        s.getVehicle();


        System.out.println();

        // Init of Control Center

        ControlCenter.getControlCenter().addMapStation(s);

        ControlCenter.getControlCenter().showMapStation();

        
        Person p = new User("Matheo", "Georges", 20, "Plombier", 200f);
        p.RentVehicle(s, v.getId());

        System.out.println(p.getSolde());

        //List of Vehicle which are available (not used) in the station

        System.out.println("List of current Vehicle in the station (AVAILABLE");

        s.getVehicle(); 

        System.out.println();



        //List of Vehicle which are using by customers

        System.out.println("List of current Vehicle using (UNAVAILABLE");

        ControlCenter.getControlCenter().getVehicleUsing(); 

              System.out.println();

        System.out.println("The customer has finished using the vehicle");


       
        try {
        p.FinishedRentingVehicle(s, v.getId());
        } catch (MaxNumberVException e) {
            System.out.println(e.getMessage());
        }

        s.getVehicle(); 

        System.out.println();
        ControlCenter.getControlCenter().getVehicleUsing();

    }
    
}
