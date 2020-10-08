import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer (String name){
        this.name = name;
    };
    public void addRental(Rental arg) {
        this.rentals.add(arg);
    }
    public String getName (){
        return this.name;
    }

    public String statement() {

        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        getIndividualMovieInfo(result);
        getSummaryInfo(result);

        return result.toString();
    }


    private void getIndividualMovieInfo(StringBuilder result){

        for (Rental each:rentals)  {
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append(each.getCharge()).append("\n");
        }
    }

    private void getSummaryInfo(StringBuilder result){
        result.append("Amount owed is ").append(getTotalCharge()).append("\n");
        result.append("You earned ").append(this.getTotalFrequentRenterPoints()).append(" frequent renter points");

    }

    private double getTotalCharge(){
        return this.rentals.stream().mapToDouble(Rental::getCharge).sum();
    }

    private int getTotalFrequentRenterPoints(){
        return this.rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
    }



}
