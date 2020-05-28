import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static Logger logger;

    public static void main(String[] args) {

        logger = Logger.getLogger(Main.class.getName());

        TollPlaza tollPlaza = new TollPlaza("TOLL", 1);
        TollPlaza tollPlaza2 = new TollPlaza("TOLL2", 2);
        LocalTime rushTime = LocalTime.of(7, 0);
        LocalTime regularTime = LocalTime.of(10, 0);
        LocalDate date = LocalDate.of(2020, 5, 28);

        VeichleRegisterSingleton veichleRegisterSingleton = VeichleRegisterSingleton.getInstance();

        DieselCar dieselCar = new DieselCar("AB12345", 1000);
        PetrolCar petrolCar = new PetrolCar("CD67891", 1500);
        Truck truck = new Truck("AA11111", 5000);
        ElectricalCar electricalCar = new ElectricalCar("EL99999", 1200);

        veichleRegisterSingleton.registerVeichle(dieselCar, petrolCar, truck, electricalCar);

        tollPlaza.registerTollPassage(dieselCar.getLicencePlateNumber(), date, regularTime);
        tollPlaza.registerTollPassage(dieselCar.getLicencePlateNumber(), date, rushTime);

        System.out.println("FIRST ONE IS IN REGULAR TIME; SECOND IS RUSH HOUR: \n" +tollPlaza.getTollPassageList());

        tollPlaza2.registerTollPassage(truck.getLicencePlateNumber(), date, rushTime);
        tollPlaza2.registerTollPassage(electricalCar.getLicencePlateNumber(), date, rushTime);
        System.out.println("TRUCK SHOULD HAVE 101 IN TAX, ELECTRICAL SHOULD HAVE 8:\n" + tollPlaza2.getTollPassageList());

        logger.log(Level.INFO, "PASSAGES FOR TOLL 1: " +  tollPlaza.getTollPassageList().toString());
        logger.log(Level.INFO, "PASSAGES FOR TOLL 2: " +  tollPlaza2.getTollPassageList().toString());
    }
}
