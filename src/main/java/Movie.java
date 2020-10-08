public class Movie {
    private final String title;
    private final Price price;

    public Movie(String title, Price price) {
        this.title = title;
        this.price = price;
    }



    public String getTitle (){
        return title;
    }

    public double getCharge(int days){
        return price.getCharge(days);
    }

    public int getFrequentRenterPoints(int days){
        return price.getFrequentRenterPoints(days);
    }

}
