import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PassageRegister {

    List<TollPassage> tollPassages;

    public PassageRegister(){
        this.tollPassages = new ArrayList<>();
    }

    /**
     * Register passage if not already registered
     * @param id
     * @param licencePlate
     * @return
     */

    public boolean regPassage(int id, String licencePlate){
        TollPassage tollPassage = new TollPassage(id, licencePlate);
        if (!tollPassages.contains(tollPassage)){
            tollPassages.add(tollPassage);
            return true;
        }
        return false;
    }

    /**
     * Registers passage if not already registered
     * @param id
     * @param licencePlate
     * @param time
     * @param date
     * @return
     */

    public boolean regPassage(int id, String licencePlate, LocalTime time, LocalDate date){
        TollPassage tollPassage = new TollPassage(id, licencePlate, time, date);
        if (!tollPassages.contains(tollPassage)){
            tollPassages.add(tollPassage);
            return true;
        }
        return false;
    }

    /**
     * Recieves all tollPassages
     * @return List<TollPassage>
     */

    public List<TollPassage> getTollPassages() {
        return tollPassages;
    }

    /**
     * Recieves all passages given a specific tollId
     * @param id
     * @return List<TollPassage>
     */

    public List<TollPassage> passageById(int id){
        return tollPassages.stream().filter(p -> p.getTollId() == id).collect(Collectors.toList());
    }

    /**
     * Generic for each
     */
    public void forEach(){
        for (TollPassage tollPassage: tollPassages) {

        }
    }

    @Override
    public String toString() {
        return "PassageRegister{" +
                "tollPassages=" + tollPassages +
                '}';
    }
}
