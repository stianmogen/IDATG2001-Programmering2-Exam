public class Truck extends Veichle {

    private final int TAX_RUSH_HOUR = 101;
    private final int TAX_REGULAR = 86;
    private final int MAX_WEIGHT = 3500;

    public Truck(String licenceNr, int weight) {
        //if (weight < 0 || weight > 3500){
        //    throw new IllegalArgumentException("Weight for Truck is between 0 and 3500 kg");
        //}
        super(licenceNr, weight);
    }

    public int getTAX_RUSH_HOUR() {
        return TAX_RUSH_HOUR;
    }

    public int getTAX_REGULAR() {
        return TAX_REGULAR;
    }

    public int getMAX_WEIGHT() {
        return MAX_WEIGHT;
    }

    @Override
    public int getCost(boolean withinRushHours) {
        if (withinRushHours){
            return TAX_RUSH_HOUR;
        }
        return TAX_REGULAR;
    }
}
