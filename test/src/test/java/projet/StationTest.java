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
    private Station s3;

    private Vehicle  v = new MockVehicle("B001",100,ColorEnum.BLACK);
    private Vehicle  v2 = new MockVehicle("B002",150,ColorEnum.BLEU);
    private Vehicle  v3 = new MockVehicle("B003",130,ColorEnum.RED);
    private Vehicle  v4 = new MockVehicle("B004",190,ColorEnum.YELLOW);
    private Vehicle  v5 = new MockVehicle("B005",165,ColorEnum.WHITE);


    @BeforeEach 
    private void init(){

        this.s = new Station(123,2);
       //this.s2 = new Station(456,1);
        this.s3 = new Station(789,4);

        ControlCenter.getControlCenter().addMapStation(s);
       // ControlCenter.getControlCenter().addMapStation(s2);
        ControlCenter.getControlCenter().addMapStation(s3);
        
   
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
    /*
    @Test 
    public void testAddVehicleException(){

        assertThrows(MaxNumberVException.class, () -> {
                 this.s.addVehicle(v);
                 this.s.addVehicle(v);
        this.s.addVehicle(v);


        });
    }
     */
    /* 
    @Test 
    public void testIsEmptyFullStation(){

        this.s2.setTimeAlone();
        this.s2.setTimeAlone();
        this.s2.setTimeAlone();
      

        try{
            this.s.addVehicle(v);
            this.s.addVehicle(v2);

        }catch(MaxNumberVException e){
            e.printStackTrace();
        }
        assertTrue(ControlCenter.getControlCenter().isEmptyFull());
    }

    */
   /* 
    @Test 
    public void testClassiqRedistribution(){

        this.s2.setTimeAlone();
        this.s2.setTimeAlone();
        this.s2.setTimeAlone();

        try{
            this.s.addVehicle(v);
            this.s.addVehicle(v2);

        }catch(MaxNumberVException e){
            e.printStackTrace();
        }

        
        assertTrue(ControlCenter.getControlCenter().isEmptyFull());
   

    }
        */
    @Test 
    public void testRandomRedistribution(){

        this.s.setTimeAlone();
        this.s.setTimeAlone();
        this.s.setTimeAlone();

        try{
            this.s.addVehicle(v);
            this.s.addVehicle(v2);
  
            this.s3.addVehicle(v3);
            this.s3.addVehicle(v4);

        }catch(MaxNumberVException e){
            e.printStackTrace();
        }


        ControlCenter.getControlCenter().setMethodD(new RandomMethod());
        assertTrue(ControlCenter.getControlCenter().isEmptyFull());
   

    }


    
}
