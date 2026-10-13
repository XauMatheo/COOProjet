package projet;

public class Repairer extends  Person implements  Visitor{

    public Repairer(String n , String s , int a , String o, Float solde){
        super(n,s,a,o,solde);
    }

    @Override 
    public void visit(Vehicle v ){
        v.setState(new Unvailable());
        System.out.println("I'm working on the vehicle, it might take a moment");

    }
    
}
