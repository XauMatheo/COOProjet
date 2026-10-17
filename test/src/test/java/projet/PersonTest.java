package projet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;

public class PersonTest {

    private Person p;

    private Vehicle v;
    private Station st;

    @BeforeEach 
    public void init(){
        this.p = new User("Tom", "Lebrun", 33, "Doctor",300 );
        this.v = new MockVehicle("B-001", 120, ColorEnum.BLEU);
        this.st = new Station(123, 11);
    }

    @Test 
    public void testRentVehicleStationEmpty(){
    
        assertFalse(p.RentVehicle(st, this.v.getId()));
    }


    
}
