package projet;

public abstract class Person {

    protected String name;
    protected String surname;
    protected int age;
    protected String occupation;
    protected Float solde;

    public  Person(String n , String s , int a , String o, Float solde){
        this.name = n;
        this.surname = s;
        this.age = a;
        this.occupation = o;
        this.solde = solde;
    }

    public void RentVehicle(Station st, String idVehicle){

        Vehicle v = st.getVehicleById(idVehicle);

        if( v!= null && this.solde >= v.getPrice()){
            this.solde -= v.getPrice();
            System.out.println("Passer");
            ControlCenter.getControlCenter().VehicleRented(st, idVehicle);
            
        
        }

       


    }

     // Solde getter
        public Float getSolde(){
            return this.solde;
        }
    
}
