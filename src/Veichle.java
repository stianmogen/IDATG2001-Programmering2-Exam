import java.util.Objects;

/**
 * Superclass for all types of veichles
 * Common functionality is here in this class
 * The abstract class Implements the interface Payable
 */

/*
We do not want to be able to create a generic Veichle, as all veichles can ble described in a subclass of veichles
Therefor I chose to make this class abstract
 */
abstract class Veichle implements Payable{

    private String licenceNr;
    private int weight;

    /**
     * Contructs an intance of Veichle
     * Throws illegalArgumentException if parameters are typed incorrectly
     * @param licenceNr
     * @param weight
     */

    public Veichle(String licenceNr, int weight) {
        if (weight < 0 ) {
            throw new IllegalArgumentException("Weight must be positive: Weight = " +weight);
        }
        //Unfortunately I didn't find a better way to check if licenceNr had correct values
        //It should also check if the first 2 places in the String is numbers, and the last 5 are letters
        if (licenceNr.length() != 7){
            throw new IllegalArgumentException("Licence plate must be seven digits long: Licence plate = " +licenceNr);
        }
        this.licenceNr = licenceNr.toUpperCase();
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setRegNr(String regNr) {
        this.licenceNr = regNr;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * getLicencePlateNumber implemented from Payable
     * @return licenceNr
     */

    @Override
    public String getLicencePlateNumber() {
        return licenceNr;
    }

    /**
     * Method from interface to be modified in the classes that extends from this
     * Since Veichle cannot be created itself, returns 0
     * @param withinRushHours
     * @return 0
     */

    @Override
    public int getCost(boolean withinRushHours) {
        return 0;
    }

    @Override
    public String toString() {
        return "Veichle{" +
                "regNr='" + licenceNr + '\'' +
                ", weight=" + weight +
                '}';
    }

    /**
     * Implements equals method
     * It only checks the licenceNr, as a car must hava a unique licenceNr
     * @param o
     * @return
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veichle veichle = (Veichle) o;
        return licenceNr.equals(veichle.licenceNr);
    }

}
