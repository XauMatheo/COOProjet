package projet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.List;

public class MockVehicleTest extends Vehicle{


    public MockVehicleTest(double price) {
        super(price);
    }


    /* 
    @Override 
    public Float getPrice(){
        return this.price();
    }

    
    @Override 
    public Color getColor(){
        return this.color.toString();
    }
    */

    @Test
    @Override 
    public void getAccessory(){
        for(VehicleAccessoryDecorator ac : this.accessories){
            System.out.println(ac.toString());
        }
    }
    /* 
    @Override 
    public State getState(){
        return this.state;
    }

    @Override 
    public int getNbLoc(){
        return this.nbloc;
    }

    @Override 
    public int getNbUnitTimeNotBorrowed(){
        return this.getnbUnitTimeNotBorrowed;
    }

    */


   Vehicle v = new MockVehicleTest(100.0);

    VehicleAccessoryDecorator vcd = new Basket(v);

    v.addAccessory(vcd);
    
    

    

}
