import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VeichleRegisterTest {

    DieselCar dieselCar = new DieselCar("UF32512", 1000);
    DieselCar dieselCar2 = new DieselCar("AB32512", 2000);
    VeichleRegister vr = new VeichleRegister();

    /**
     * Tests that veichles get registered
     * it also checks that if you try to add an already registered veichle, the method returns false
     */

    @Test
    void registerVeichle() {
        vr.registerVeichle(dieselCar);
        vr.registerVeichle(dieselCar2);

        assertTrue(vr.getVeichles().contains(dieselCar) && vr.getVeichles().contains(dieselCar2));
        assertFalse(vr.registerVeichle(dieselCar));
    }

    /**
     * Tests that the findVeichleByLicence returns a car with the same licenceplate as the parameter
     */

    @Test
    void findVeichleByLicence() {

        vr.registerVeichle(dieselCar);
        vr.registerVeichle(dieselCar2);

        assertEquals(dieselCar, vr.findVeichleByLicence(dieselCar.getLicencePlateNumber()));

        assertNotEquals(dieselCar, vr.findVeichleByLicence(dieselCar2.getLicencePlateNumber()));

    }

    /**
     * Tests that the findVeichleByWeight only returns a list with veichles with a weight higher than the given parameter
     */

    @Test
    void findVeichleByWeight() {

        final int ALL_CARS = 500;
        final int ONE_CAR = 1500;
        final int NO_CARS = 2500;

        vr.registerVeichle(dieselCar);
        vr.registerVeichle(dieselCar2);
        //check if all cars are returned as all cars are over 500 kg
        assertEquals(vr.getVeichles(), vr.findVeichleByWeight(ALL_CARS));
        //checks if that only dieselCar2 is returned as its the only car over 1500 kg
        assertTrue(vr.findVeichleByWeight(ONE_CAR).contains(dieselCar2) && !vr.findVeichleByWeight(ONE_CAR).contains(dieselCar));
        //Checks that no cars are returned since no cars is heavier than 2500
        assertFalse(vr.findVeichleByWeight(NO_CARS).contains(dieselCar) || vr.findVeichleByWeight(NO_CARS).contains(dieselCar2));

    }
}