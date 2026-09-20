package projet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class VehicleTest {

    @Test
    public void testAccesories(){

        Vehicle v = new MockVehicle(100);
        VehicleAccessoryDecorator vad = new Basket(v);
        v.addAccessory(vad);

        assertEquals(1,v.getAccessories().size());
        assertSame(vad,v.getAccessories().get(0));

    }
    
}
