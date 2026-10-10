package projet;

public class Available implements  State{

    @Override 
    public String currentState(){
        return StateEnum.AVAILABLE.toString();
    }
    
}
