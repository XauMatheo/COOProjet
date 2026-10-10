package projet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;

public class StationTest {

    private Station s;

    private Vehicle  v = new MockVehicle("123",100,ColorEnum.BLACK);

    @BeforeEach 
    private void init(){

        this.s = new Station(0);
   
    }

    
    @Test 
    public void testAddVehicle(){

        this.s.addVehicle(v);


        assertEquals(1, this.s.getnbV());
    }


    
}
