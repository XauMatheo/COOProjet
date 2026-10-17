package projet;

public abstract class Person {

    protected String name;
    protected String surname;
    protected int age;
    protected String occupation;
    protected double solde;

    public  Person(String n , String s , int a , String o, double solde){
        this.name = n;
        this.surname = s;
        this.age = a;
        this.occupation = o;
        this.solde = solde;
    }

    public boolean RentVehicle(Station st, String idVehicle){

        Vehicle v = st.getVehicleById(idVehicle);

        if(v==null){
            System.out.println("Vehicle not found, the station might be empty");
            return false;
        }

        if(this.solde >= v.getPrice()){
            this.solde -= v.getPrice();
            ControlCenter.getControlCenter().VehicleRented(st, idVehicle);
        }
            
        System.out.println("Not enough Money to rent this one, try another one or add some money to your account");
        return false;
    

    }

    public void FinishedRentingVehicle(Station st, String idVehicle) throws MaxNumberVException{


            try{
                ControlCenter.getControlCenter().BackVehicleStation(st, idVehicle);
            }catch(MaxNumberVException e){
                System.out.println("Station full");
            }

            
        }


     // Solde getter
        public double getSolde(){
            return this.solde;
        }
    
}
