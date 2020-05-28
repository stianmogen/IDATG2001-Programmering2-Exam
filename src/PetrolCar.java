public class PetrolCar extends Veichle{

    private final int TAX_RUSH_HOUR = 21;
    private final int TAX_REGULAR = 17;


    public PetrolCar(String licenceNr, int weight) {
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
