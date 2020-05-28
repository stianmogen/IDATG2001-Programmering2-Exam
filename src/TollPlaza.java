import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TollPlaza {

    private String tollName;
    private int tollId;
    private List<TollPassage> tollPassageList;
    private PassageRegister passageRegister = new PassageRegister();

    public TollPlaza(String tollName, int tollId){
        if (tollId < 0){
            throw new IllegalArgumentException("Toll id cannot be negative : " + tollId);
        }
        if (tollName == null || tollName.equals("")){
            throw new IllegalArgumentException("Toll must have a name");
        }
        this.tollId = tollId;
        this.tollName = tollName;
        this.tollPassageList = passageRegister.getTollPassages();
    }

    /**
     * A method which takes in licenceplatenumber, date and time as parameters to register a passage
     * also uses the tollId of this specific tollplaza
     * @param licencePlateNumber
     * @param date
     * @param time
     * @return true if passage was registered, false if not
     */

    public boolean registerTollPassage(String licencePlateNumber, LocalDate date, LocalTime time){
        if (passageRegister.regPassage(this.tollId, licencePlateNumber, time, date)) {
            return true;
        }
        return false;
    }

    /**
     * Similar to the method above, however it only takes in licenceplatenumber as parameter, with the specific id
     * @param licencePlateNumber
     * @return true if passage was registered, false if not
     */

    public boolean registerTollPassage(String licencePlateNumber){
        if (passageRegister.regPassage(this.tollId, licencePlateNumber)) {
            return true;
        }
        return false;

    }

    /**
     * Revieces all passages in passage register
     * @return
     */

    public List<TollPassage> getTollPassageList() {
        return tollPassageList;
    }

    @Override
    public String toString() {
        return "TollPlaza{" +
                "tollName='" + tollName + '\'' +
                ", tollId=" + tollId +
                ", tollPassageList=" + tollPassageList +
                ", passageRegister=" + passageRegister +
                '}';
    }

    /**
     * Equals method that only uses Id, as it must have an unique id
     * @param o
     * @return
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TollPlaza tollPlaza = (TollPlaza) o;
        return tollId == tollPlaza.tollId;
    }

}
