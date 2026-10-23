package projet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

    private static final int MAX_TIME = 3;
    public static int currentTime = 1;

    public static void main(String[] args) {

        Random random = new Random();

        List<Station> stations = new ArrayList<>();

    
        Vehicle v1 = new Bike("B-001", 120.50, ColorEnum.BLEU);
        Vehicle v2 = new Bike("B-002", 99.90, ColorEnum.BLACK);
        Vehicle v3 = new Bike("B-003", 180.33, ColorEnum.YELLOW);
        Vehicle v4 = new Bike("B-004", 76.75, ColorEnum.GREEN);
        Vehicle v5 = new Bike("B-005", 149.99, ColorEnum.PURPLE);
        Vehicle v6 = new Bike("B-006", 55.55, ColorEnum.RED);
        Vehicle v7 = new Bike("B-007", 111.99, ColorEnum.WHITE);

        
        Station s1 = new Station(123, 10);
        Station s2 = new Station(456, 15);
        Station s3 = new Station(789, 12);

        stations.add(s1);
        stations.add(s2);
        stations.add(s3);


        Person p1 = new User("Tom", "Hato", 29, "Firefighter", 400);
        Person p2 = new User("Marie", "Dutour", 33, "Professor", 360);
        Person p3 = new User("Bob", "Bricole", 29, "Firefighter", 300);

        List<Person> users = new ArrayList<>();
        users.add(p1);
        users.add(p2);
        users.add(p3);

    
        ControlCenter center = ControlCenter.getControlCenter();

        for (Station station : stations) {
            center.addMapStation(station);
        }

    
        Simulation sim = new Simulation(stations, center);

        try {
            s1.addVehicle(v1);
            s1.addVehicle(v2);

            s2.addVehicle(v3);
            s2.addVehicle(v4);
            s2.addVehicle(v5);

            s3.addVehicle(v6);
            s3.addVehicle(v7);

        } catch (MaxNumberVException e) {
            e.printStackTrace();
        }

        // adding some accesories
        v1.addAccessory(new Basket(v1));
        v4.addAccessory(new Basket(v4));
        v6.addAccessory(new Basket(v6));

        // Vehicle's list
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(v1);
        vehicles.add(v2);
        vehicles.add(v3);
        vehicles.add(v4);
        vehicles.add(v5);
        vehicles.add(v6);
        vehicles.add(v7);

        // Users current locations
        Vehicle[] rentedVehicles = new Vehicle[users.size()];

        // Main loop
        while (currentTime <= MAX_TIME) {

            System.out.println(
                "\n========== SET "
                + currentTime + " =========="
            );

            try {

                // Bike cannot be used while repaired 
                if (currentTime > 1) {
                    center.FinishRepaired();
                }

                // Random Actions
                int numberOfActions = random.nextInt(4) + 1;

                for (int i = 0; i < numberOfActions; i++) {

                    int userIndex = random.nextInt(users.size());
                    Person person = users.get(userIndex);

                    // User wants to give back a bike 
                    if (rentedVehicles[userIndex] != null) {

                        if (random.nextBoolean()) {

                            List<Station> possibleStations =
                                new ArrayList<>();

                            for (Station station : stations) {
                                if (!station.isFull()) {
                                    possibleStations.add(station);
                                }
                            }

                            if (!possibleStations.isEmpty()) {

                                Station destination =
                                    possibleStations.get(
                                        random.nextInt(
                                            possibleStations.size()
                                        )
                                    );

                                Vehicle vehicle =
                                    rentedVehicles[userIndex];

                                person.FinishedRentingVehicle(
                                    destination,
                                    vehicle.getId()
                                );

                                //Vehicle rent
                                vehicle.initNbNotUsed();

                                rentedVehicles[userIndex] = null;

                                System.out.println(
                                    "Retour du vélo "
                                    + vehicle.getId()
                                    + " à la station "
                                    + destination.getId()
                                );
                            }
                        }

                        continue;
                    }

                    // Can rent a bike 
                    Station station = stations.get(
                        random.nextInt(stations.size())
                    );

                    List<Vehicle> availableVehicles =
                        station.getListVehicleAvailable();

                    if (!availableVehicles.isEmpty()) {

                        Vehicle vehicle = availableVehicles.get(
                            random.nextInt(availableVehicles.size())
                        );

                        boolean success = person.RentVehicle(
                            station,
                            vehicle.getId()
                        );

                        if (success) {

                            rentedVehicles[userIndex] = vehicle;

                            // SetCounter 0 because location
                            vehicle.initNbNotUsed();

                            System.out.println(
                                "Bike Location  "
                                + vehicle.getId()
                                + " Station "
                                + station.getId()
                            );
                        }
                    }
                }

                // Station empty or full
                center.isEmptyFull();

                // Bike Inactivity 
                for (Station station : stations) {

                    if (station.getnbV() == 1) {

                        Vehicle vehicle = station.getSingleVehicle();

                        if (vehicle != null
                                && vehicle.getState()
                                    instanceof Available) {

                            // Only 1 bike in the station
                            vehicle.setNbNotUsed();

                            // Check to rob
                            center.checkVehicleToRob(station);
                        }

                    } else {

                        
                        for (Vehicle vehicle :
                                station.getListVehicleAvailable()) {

                            vehicle.initNbNotUsed();
                        }
                    }
                }

                // New time for Stations
                for (Station station : stations) {
                    station.setTimeAlone();
                }

                // Stations State
                for (Station station : stations) {

                    System.out.println(
                        "Station " + station.getId()
                        + " : " + station.getnbV()
                        + " Bike"
                    );
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            currentTime++;
        }

        System.out.println("\nSimulation Finished.");

        System.out.println(
            "Bike currently rented : "
            + center.VehicleIsUsingBy.size()
        );

        System.out.println(
            "Bike robbed : "
            + center.VehicleRobbed.size()
        );
    }
}