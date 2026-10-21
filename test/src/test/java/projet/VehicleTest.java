package projet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ResourceBundle.Control;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;

public class VehicleTest {

    private Vehicle v; 
    private VehicleAccessoryDecorator vad;
    private Person p;
    private Station s;
    private Station s2;
    private Station s3;


    @BeforeEach 
    private void init(){
        this.v = new MockVehicle("DD-042",100 ,ColorEnum.BLACK);
        this.vad = new  Basket(this.v);
        this.p = new User("Bob", "Lenom", 30, "Doctor", 300);
        this.s = new Station(123, 1);
        this.s2 = new Station(456, 1);
        this.s3 = new Station(789, 3);

    }

    /* 
    @Test
    public void testAccesories(){

        this.v.addAccessory(this.vad);

      
        assertEquals(1,this.v.getAccessories().size());
        assertSame(this.vad,this.v.getAccessories().get(0));

    }

    @Test 
    public void testCostAccessories(){

        double priceB = v.getPrice();
        v.addAccessory(vad);
        double priceA = v.getPrice();

        assertEquals(120, priceA);

        
    }
        */
    /* 
    @Test 
    public void testVehicleRepaired(){

        try{
            s.addVehicle(v);

            p.RentVehicle(s, v.getId());

            p.FinishedRentingVehicle(s, v.getId());
            
           assertTrue(v.getState() instanceof Unvailable);
            
        }catch(MaxNumberVException e){
            System.out.println(e.getMessage());
        }
    }
        
    @Test 
    public void testMethodRentUnvailable(){
        try{
            s.addVehicle(v);

            p.RentVehicle(s, v.getId());

            p.FinishedRentingVehicle(s, v.getId());
            
            assertFalse(p.RentVehicle(s, v.getId()));
            
        }catch(MaxNumberVException e){
            System.out.println(e.getMessage());
        }
        
    }
        

    @Test 
    public void testMethodDistUnvailable(){
        try{

            ControlCenter.getControlCenter().addMapStation(s);
            ControlCenter.getControlCenter().addMapStation(s2);
            ControlCenter.getControlCenter().addMapStation(s3);

            this.s2.setTimeAlone();
            this.s2.setTimeAlone();
            this.s2.setTimeAlone();

            s.addVehicle(v);


            p.RentVehicle(s, v.getId());

            p.FinishedRentingVehicle(s, v.getId());


            
            assertTrue(ControlCenter.getControlCenter().isEmptyFull());
            
        }catch(MaxNumberVException e){
            System.out.println(e.getMessage());
        }
        
    }
        
    @Test 
    public void testFinishedRepaired(){
        try{

            // Counter equals 1 ...
            ControlCenter.getControlCenter().addMapStation(s);
            ControlCenter.getControlCenter().addMapStation(s2);
            ControlCenter.getControlCenter().addMapStation(s3);

            this.s2.setTimeAlone();
            this.s2.setTimeAlone();
            this.s2.setTimeAlone();

            s.addVehicle(v);


            p.RentVehicle(s, v.getId());

            p.FinishedRentingVehicle(s, v.getId());

            //Counter equals 2 ... 

            ControlCenter.getControlCenter().FinishRepaired();

            assertTrue(v.getState() instanceof Available);

            
            
        }catch(MaxNumberVException e){
            System.out.println(e.getMessage());
        }

    }
        */

    @Test 
    public void VehicleRobbed(){

        try{

            // Counter equals 1 ...
            ControlCenter.getControlCenter().addMapStation(s);
            ControlCenter.getControlCenter().addMapStation(s2);
            ControlCenter.getControlCenter().addMapStation(s3);

            //Empty station 
            this.s2.setTimeAlone();
            this.s2.setTimeAlone();
            this.s2.setTimeAlone();

            s.addVehicle(v);
            v.setNbNotUsed();

            //Counter equals 2 ... 
            v.setNbNotUsed();
       
            
            //Counter equals 3 ... 

            assertTrue(ControlCenter.getControlCenter().checkVehicleToRob(s));
            
            
            
        }catch(MaxNumberVException e){
            System.out.println(e.getMessage());
        }


    }
    
    
    
}
