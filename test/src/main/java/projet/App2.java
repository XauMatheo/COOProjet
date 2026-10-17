package projet;

public class App2 {

    public static int counterTime =0;
    public static void main(String[] args){

        // Different vehicles (Every color possible)
        Vehicle v1 = new Bike("B-001" , 120.50 , ColorEnum.BLEU);
        Vehicle v2 = new Bike("B-002" , 99.90, ColorEnum.BLACK);
        Vehicle v3 = new Bike("B-003" , 180.33 , ColorEnum.YELLOW);
        Vehicle v4 = new Bike("B-004" , 76.75 , ColorEnum.GREEN);
        Vehicle v5 = new Bike("B-005" , 149.99 , ColorEnum.PURPLE);
        Vehicle v6 = new Bike("B-006" , 55.55 , ColorEnum.RED);
        Vehicle v7 = new Bike("B-007" , 111.99 , ColorEnum.WHITE);


        Station s1 = new Station(123, 10);
        Station s2 = new Station(456, 15);
        Station s3 = new Station(789, 12);

        Person p1 = new User("Tom", "Hato", 29, "Firefighter", 400);
        Person p2 = new User("Marie", "Dutour", 33, "Professor", 360);
        Person p3 = new User("Bob", "Bricole", 29, "Firefighter", 300);


        p1.RentVehicle(s1, "B-001");

    }
    
}
