/**
 * Motorcycle extends Veichle
 */

public class Motorcycle extends Veichle{

    /**
     * Motorcycles do not have to pay toll tax, therefore final values set to 0
     */

    private final int TAX_RUSH_HOUR = 0;
    private final int TAX_REGULAR = 0;

    public Motorcycle(String licenceNr, int weight) {
        super(licenceNr, weight);
    }

    public int getTAX_RUSH_HOUR() {
        return TAX_RUSH_HOUR;
    }

    public int getTAX_REGULAR() {
        return TAX_REGULAR;
    }

    @Override
    public int getCost(boolean withinRushHours) {
        if (withinRushHours){
            return TAX_RUSH_HOUR;
        }
        return TAX_REGULAR;
    }
}
