/**
 * DieselCar extends Veichle
 */

public class DieselCar extends Veichle{

    /**
     * sets final ints for rush hour and regular hours, these won't be modified
     */

    private final int TAX_RUSH_HOUR = 23;
    private final int TAX_REGULAR = 19;

    public DieselCar(String licenceNr, int weight) {
        super(licenceNr, weight);
    }

    public int getTAX_REGULAR() {
        return TAX_REGULAR;
    }

    public int getTAX_RUSH_HOUR() {
        return TAX_RUSH_HOUR;
    }

    /**
     * Uses the getCost method from the Payable interface
     * The Unique tax values are used
     * @param withinRushHours
     * @return
     */


    @Override
    public int getCost(boolean withinRushHours) {
        if (withinRushHours){
            return TAX_RUSH_HOUR;
        }
        return TAX_REGULAR;
    }
}
