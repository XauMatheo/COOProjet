package projet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;

public class PersonTest {

    private Person p;
    private Person p2;

    private Vehicle v;
    private Station st;

    @BeforeEach 
    public void init(){
        this.p = new User("Tom", "Lebrun", 33, "Doctor",300 );
        this.p2 = new User("Bob", "Lenom", 28, "Software Engineer", 50);
        this.v = new MockVehicle("B-001", 120, ColorEnum.BLEU);
        this.st = new Station(123, 11);
    }

    @Test 
    public void testRentVehicleStationEmpty(){
    
        assertFalse(p.RentVehicle(st, this.v.getId()));
    }
    @Test 
    public void testRentVehicleSolde(){

        try{
            st.addVehicle(v);
        }catch(MaxNumberVException e){
            e.printStackTrace();
        }

   
        assertTrue(p.RentVehicle(st, this.v.getId()));
    }

    @Test 
    public void testNotEnoughMoneyTorent(){

        try{
            st.addVehicle(v);
        }catch(MaxNumberVException e){
            e.printStackTrace();
    
    }
    assertFalse(p2.RentVehicle(st, this.v.getId()));

    }


    
}
