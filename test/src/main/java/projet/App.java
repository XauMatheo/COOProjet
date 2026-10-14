package projet;



public class App {

    public static int counterTime = 0; // General counter
    public static void main(String[] agrs){

        



        Vehicle v= new MockVehicle("BB-011",100,ColorEnum.BLACK);
        Vehicle v2= new MockVehicle("BB-89" , 150,ColorEnum.RED);
        Vehicle v3= new MockVehicle("BB-002" , 110,ColorEnum.YELLOW);

        VehicleAccessoryDecorator vad = new Basket(v);

        float priceB = v.getPrice();
        v.addAccessory(vad);

        
        float priceA= v.getPrice();


        System.out.println(priceB);
        System.out.println(priceA);
        System.out.println(vad.getPrice());

        System.out.println(v.getState());

        Station s = new Station(123, 2) ;
        Station s2 = new Station(345, 2);

        try{
             s.addVehicle(v);
            s.addVehicle(v2);
            s2.addVehicle(v3);

        }catch(MaxNumberVException e){
            System.out.println(e.getMessage());
        }

       
        s.getVehicle();
        


        System.out.println();

        // Init of Control Center

        ControlCenter.getControlCenter().addMapStation(s);
        ControlCenter.getControlCenter().addMapStation(s2);

        System.out.println("List of stations");
        ControlCenter.getControlCenter().showMapStation();

        
        Person p = new User("Matheo", "Georges", 20, "Plombier", 400f);
        p.RentVehicle(s, v.getId());

        System.out.println(p.getSolde());

        //List of Vehicle which are available (not used) in the station

        System.out.println("List of current Vehicle in the station (AVAILABLE");

        s.getVehicle(); 
        s2.getVehicle();
   

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
        s2.getVehicle();

        System.out.println();
        ControlCenter.getControlCenter().getVehicleUsing();


        System.out.println();

        Vehicle v4 = new MockVehicle("BB-999", 200, ColorEnum.BLEU);

        try{
             s2.addVehicle(v4);
        }catch (MaxNumberVException e) {
            System.out.println(e.getMessage());
        }
       
        p.RentVehicle(s2,v4.getId());

        s2.getVehicle();

        try{
              p.FinishedRentingVehicle(s2, v4.getId());

        }catch(MaxNumberVException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        s2.getVehicle();


        ControlCenter.getControlCenter().FinishRepaired();
      

           System.out.println();
           
        s2.getVehicle();
        

        

    }
    
}
