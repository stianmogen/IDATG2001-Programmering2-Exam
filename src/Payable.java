/**
 * We need an interface that Veichle can implement, to make sure that the methods neccesarry
 * for a toll system is implemented in all the classes related to veichle
 * Therefore I created the interface Payable with the neccessary mehtods
 */

public interface Payable {

    String getLicencePlateNumber();

    int getCost(boolean withinRushHours);

}
