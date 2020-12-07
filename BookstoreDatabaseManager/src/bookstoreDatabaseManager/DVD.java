package bookstoreDatabaseManager;

/**
 * This is the DVD class and its fields. It extends Product
 *
 * @author Chase Scallion
 * @version 11/15/2019
 */
public class DVD extends Product {

    private String director;    //name of diretor
    private String actor;   //name of main actor
    private double movieLength; //length of dvd in hours

    /**
     * This is the constructor of the DVD class
     *
     * @param price price of dvd
     * @param id ID number of dvd
     * @param title title of dvd
     * @param amountInStock amount in stock of dvd
     * @param director director of dvd
     * @param actor main actor of dvd
     * @param movieLength length of dvd in hours
     */
    public DVD(double price, int id, String title, int amountInStock, String director, String actor, double movieLength) {
        super(price, id, title, amountInStock);
        this.director = director;
        this.actor = actor;
        this.movieLength = movieLength;
    }

    /**
     * Gets the name of the director of dvd
     *
     * @return returns director name
     */
    public String getDirector() {
        return director;
    }

    /**
     * Gets the name of the main actor of dvd
     *
     * @return returns name of main actor
     */
    public String getActor() {
        return actor;
    }

    /**
     * Gets the length of the dvd
     *
     * @return length of dvd
     */
    public double getMovieLength() {
        return movieLength;
    }
}
