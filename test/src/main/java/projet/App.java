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

        s.addVehicle(v);
        s.addVehicle(v2);
        s.addVehicle(v2);

        s.getVehicle();


    }
    
}
