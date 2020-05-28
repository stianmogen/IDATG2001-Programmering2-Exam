import java.time.LocalDate;
import java.time.LocalTime;

public class TollPassage {

    private int tollId;
    private String licencePlaye;
    private LocalTime passageTime;
    private LocalDate passageDate;
    private int tax;
    private VeichleRegisterSingleton vrs = VeichleRegisterSingleton.getInstance();

    /**
     * Constructor takes in tollId and licenceplate as parameter, and autogenerates date and time with static methods
     * tax is decided based on if its rush hour or not
     * @param tollId
     * @param licencePlaye
     */

    public TollPassage(int tollId, String licencePlaye){
        if (tollId < 0){
            throw new IllegalArgumentException("tollId must be positve " + tollId);
        }
        this.tollId = tollId;
        this.licencePlaye = licencePlaye;
        this.passageTime = LocalTime.now();
        this.passageDate = LocalDate.now();
        this.tax = findTax();
    }

    /**
     * Creates a second constructor which allows the user to manually input the passage time and date
     * This is not relevant for the application necesarilly, but is good for testing purposes
     * as it allows us to input a specific time, simplifying the testing process
     * @param tollId
     * @param licencePlaye
     * @param passageTime
     * @param passageDate
     */

    public TollPassage(int tollId, String licencePlaye, LocalTime passageTime, LocalDate passageDate){
        if (tollId < 0){
            throw new IllegalArgumentException("tollId must be positve " + tollId);
        }
        this.tollId = tollId;
        this.licencePlaye = licencePlaye;
        this.passageTime = passageTime;
        this.passageDate = passageDate;
        this.tax = findTax();
    }

    /**
     * Uses the the findVecihleByLicence in the VeichleRegisterSingleton class to find the veichle with the licenceplate
     * uses the getCost with the isRushHour() method to determine the tax returned
     * @return tax based on rush hour
     */

    private int findTax(){
        return vrs.findVeichleByLicence(this.licencePlaye).getCost(isRushHour());
    }

    /**
     * Method that checks if the passage time is within the rush hours
     * Is rush hours if its passageTime is between 06:30 - 08:59, or between 14:30 - 16:29
     * @return true if its rush hour, false if not
     */

    private boolean isRushHour(){
        if (passageTime.isAfter(LocalTime.of(6, 30)) && passageTime.isBefore(LocalTime.of(8, 59)) || (passageTime.isAfter(LocalTime.of(14, 30)) && passageTime.isBefore(LocalTime.of(16,29)))) {
            return true;
        }
        return false;
    }

    public int getTax() {
        return tax;
    }

    public int getTollId() {
        return tollId;
    }

    public LocalDate getPassageDate() {
        return passageDate;
    }

    public LocalTime getPassageTime() {
        return passageTime;
    }

    public String getLicencePlaye() {
        return licencePlaye;
    }

    @Override
    public String toString() {
        return "TollPassage{" +
                "tollId=" + tollId +
                ", licencePlaye='" + licencePlaye + '\'' +
                ", passageTime=" + passageTime +
                ", passageDate=" + passageDate +
                ", tax=" + tax +
                '}';
    }
}
