package projet;

public class Unvailable implements  State{

    @Override 
    public String currentState(){
        return StateEnum.UNVAILABLE.toString();
    }
}
