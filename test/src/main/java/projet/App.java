package projet;

public class App {

    public static void main(String[] agrs){

        Vehicle v= new MockVehicle(100,ColorEnum.BLACK);
        VehicleAccessoryDecorator vad = new Basket(v);
        float priceB = v.getPrice();
        v.addAccessory(vad);

        
        float priceA= v.getPrice();


        System.out.println(priceB);
        System.out.println(priceA);
        System.out.println(vad.getPrice());

        System.out.println(v.getState());
    }
    
}
