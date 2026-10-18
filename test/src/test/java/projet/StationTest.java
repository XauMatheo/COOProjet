package projet;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ResourceBundle.Control;

import org.junit.jupiter.api.BeforeEach;

public class StationTest {


    private Station s;
    private Station s2;

    private Vehicle  v = new MockVehicle("B001",100,ColorEnum.BLACK);
    private Vehicle  v2 = new MockVehicle("B002",150,ColorEnum.BLEU);
    private Vehicle  v3 = new MockVehicle("B003",130,ColorEnum.RED);


    @BeforeEach 
    private void init(){

        this.s = new Station(123,2);
        this.s2 = new Station(456,1);

        ControlCenter.getControlCenter().addMapStation(s);
        ControlCenter.getControlCenter().addMapStation(s2);
        
   
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

    @Test 
    public void testIsEmptyFullStation(){

        this.s2.setTimeAlone();
        this.s2.setTimeAlone();
        this.s2.setTimeAlone();
        System.out.println(this.s2.getTimeAlone());

        try{
            this.s.addVehicle(v);
            this.s.addVehicle(v2);

        }catch(MaxNumberVException e){
            e.printStackTrace();
        }
        assertTrue(ControlCenter.getControlCenter().isEmptyFull());
    }


    
}
