package projet;

public class Robbed implements  State{

    @Override 
    public String currentState(){
        return StateEnum.ROBBED.toString();
    }
    
}
