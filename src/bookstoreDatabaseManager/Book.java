package bookstoreDatabaseManager;

/**
 * This is the Book class and its fields. It extends Product
 *
 * @author Chase Scallion
 * @version 11/15/2019
 */
public class Book extends Product {

    private String author;
    private String publisher;
    private int numPages;

    /**
     * This is the constructor of the book class
     *
     * @param price price of book
     * @param id id number of book
     * @param title title of book
     * @param amountInStock amount in stock of book
     * @param author author of the book
     * @param publisher publisher of the book
     * @param numPages number of pages in the book
     */
    public Book(double price, int id, String title, int amountInStock, String author, String publisher, int numPages) {
        super(price, id, title, amountInStock);
        this.author = author;
        this.publisher = publisher;
        this.numPages = numPages;
    }

    /**
     * Gets the author of a book
     *
     * @return returns author name
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gets the publisher of a book
     *
     * @return returns name of publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Gets the number of pages in a book
     *
     * @return returns total number of pages
     */
    public int getNumPages() {
        return numPages;
    }
}
