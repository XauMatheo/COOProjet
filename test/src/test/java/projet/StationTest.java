package projet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;

public class StationTest {

    private Station s;

    private Vehicle  v = new MockVehicle("123",100,ColorEnum.BLACK);

    @BeforeEach 
    private void init(){

        this.s = new Station(123,2);
   
    }

    
    @Test 
    public void testAddVehicle(){


        try{
            this.s.addVehicle(v);
        }catch(MaxNumberVException e){
            e.printStackTrace();
        }


        assertEquals(1, this.s.getnbV());
    }
    @Test 
    public void testAddVehicleException(){

        assertThrows(MaxNumberVException.class, () -> {
                 this.s.addVehicle(v);
                 this.s.addVehicle(v);
        this.s.addVehicle(v);


        });
    }


    
}
