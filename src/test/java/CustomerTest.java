import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomerTest {

    private Rental rentalWithRegular;
    private Rental rentalWithNewRelease;
    private Rental rentalWithChildren;

    @BeforeAll
    public void setUp(){
        Movie regularMovie = new Movie("Avenger", new RegularPrice());
        Movie newReleaseMovie = new Movie("Harry Potter",new NewReleasePrice());
        Movie childrenMovie = new Movie("Baby Shark",new ChildrenPrice());

        rentalWithRegular = new Rental(regularMovie,3);
        rentalWithNewRelease = new Rental(newReleaseMovie,2);
        rentalWithChildren= new Rental(childrenMovie,4);

    }

    @Test
    public void should_print_correct_statement_given_a_customer_rent_1_regular_movie_3_days(){

        Customer customer = new Customer("xianhao");
        customer.addRental(rentalWithRegular);

        String resState = customer.statement();

        String expected = "Rental Record for " + "xianhao" + "\n" +
                            "\t"+"Avenger" +"\t"+3.5+"\n"+
                            "Amount owed is " + 3.5 + "\n" +
                            "You earned " + 1 + " frequent renter points";
        Assertions.assertEquals(expected,resState);

    }

    @Test
    public void should_print_correct_statement_given_a_customer_rent_1_new_release_movie_2_days(){

        Customer customer = new Customer("xianhao");
        customer.addRental(rentalWithNewRelease);

        String resState = customer.statement();

        String expected = "Rental Record for " + "xianhao" + "\n" +
                            "\t"+"Harry Potter" +"\t"+6.0+"\n" +
                            "Amount owed is " + 6.0 + "\n" +
                            "You earned " + 2 + " frequent renter points";
        Assertions.assertEquals(expected,resState);

    }

    @Test
    public void should_print_correct_statement_given_a_customer_rent_1_children_movie_4_days(){

        Customer customer = new Customer("xianhao");
        customer.addRental(rentalWithChildren);

        String resState = customer.statement();

        String expected = "Rental Record for " + "xianhao" + "\n" +
                "\t"+"Baby Shark" +"\t"+3.0+"\n" +
                "Amount owed is " + 3.0 + "\n" +
                "You earned " + 1 + " frequent renter points";
        Assertions.assertEquals(expected,resState);

    }

    @Test
    public void should_print_correct_statement_given_a_customer_rent_1_regular_movie_3_days_1_new_release_movie_2_days_1_children_movie_4_days(){

        Customer customer = new Customer("xianhao");
        customer.addRental(rentalWithRegular);
        customer.addRental(rentalWithNewRelease);
        customer.addRental(rentalWithChildren);

        String resState = customer.statement();

        String expected = "Rental Record for " + "xianhao" + "\n" +
                "\t"+"Avenger" +"\t"+3.5+"\n"+
                "\t"+"Harry Potter" +"\t"+6.0+"\n" +
                "\t"+"Baby Shark" +"\t"+3.0+"\n" +
                "Amount owed is " + 12.5 + "\n" +
                "You earned " + 4 + " frequent renter points";
        Assertions.assertEquals(expected,resState);

    }

    @Test
    public void should_print_correct_html_statement_given_a_customer_rent_1_regular_movie_3_days_1_new_release_movie_2_days_1_children_movie_4_days() {

        Customer customer = new Customer("xianhao");
        customer.addRental(rentalWithRegular);
        customer.addRental(rentalWithNewRelease);
        customer.addRental(rentalWithChildren);

        String resState = customer.htmlStatement();

        String expected = "<H1>Rentals for <EM>" + "xianhao" + "</EM></H1><P>\n" +
                "Avenger: " + 3.5 + "<BR>\n" +
                "Harry Potter: " + 6.0 + "<BR>\n" +
                "Baby Shark: " + 3.0 + "<BR>\n" +
                "<P>You owe <EM>" + 12.5 + "</EM><P>\n" +
                "On this rental you earned <EM>" + 4 + "</EM> frequent renter points<P>";
        Assertions.assertEquals(expected, resState);


    }
}