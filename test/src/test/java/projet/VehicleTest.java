package projet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;

public class VehicleTest {

    private Vehicle v; 
    private VehicleAccessoryDecorator vad;

    @BeforeEach 
    private void init(){
        this.v = new MockVehicle("DD-042",100 ,ColorEnum.BLACK);
        this.vad = new  Basket(this.v);
    }

    @Test
    public void testAccesories(){

        this.v.addAccessory(this.vad);

      
        assertEquals(1,this.v.getAccessories().size());
        assertSame(this.vad,this.v.getAccessories().get(0));

   

    }

    @Test 
    public void testCostAccessories(){

        float priceB = v.getPrice();
        v.addAccessory(vad);
        float priceA = v.getPrice();

        assertEquals(120, priceA);

        
    }
    
}
