import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * A class to register veichles with certain methods for easy access of said veichles
 */

public class VeichleRegister {


    private ArrayList<Veichle> veichles;

    public VeichleRegister(){
        this.veichles = new ArrayList<>();
    }

    public ArrayList<Veichle> getVeichles() {
        return veichles;
    }

    /**
     * Takes in a veichle as parameter and adds it to the veichles list
     * it can only add a veichle that is not already registered
     * @param veichle
     */

    public boolean registerVeichle(Veichle veichle){
        if (veichles.contains(veichle)){
            return false;
        }
        veichles.add(veichle);
        return true;
    }

    /**
     * Another register veichle method that can take in several veichles and register them at once
     * @param veichlesIn
     */

    public void registerVeichle(Veichle... veichlesIn){
        //This method does not check if a veichle exists, I did not have time to implement as I notices too late
        veichles.addAll(Arrays.asList(veichlesIn));
    }

    /**
     * Method takes in a licencePlate as parameter, it streams through the veichles list
     * filters through and compares the licenceplate to the getLicencePlateNumber method in veichle
     * it then finds the first, and gets that, since there is only one veichle with said licenceplate anyway
     * @param licencePlate
     * @return Veichle
     */

    public Veichle findVeichleByLicence(String licencePlate){
        return veichles.stream().filter(p -> p.getLicencePlateNumber().equals(licencePlate)).findFirst().get();
    }

    /**
     * Takes in weight as parameter, streams through all veichles, and filters all the veichles with getWeight above the weight parameter
     * then it collects all these veichles, and places them in a String which is returned
     * @param weight
     * @return List<Veichle>
     */

    public List<Veichle> findVeichleByWeight(int weight){
        return veichles.stream().filter(p -> p.getWeight() > weight).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "VeichleRegister{" +
                "veichles=" + veichles +
                '}';
    }
}
