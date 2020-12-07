package bookstoreDatabaseManager;

/**
 * This is product class and its fields. It is extended by Book, CD, and DVD
 *
 * @author Chase Scallion
 * @version 11/15/2019
 */
public class Product {

    private double price; //price of product
    private int id; //id number of product
    private String title;   //title of product
    private int amountInStock;  //amoint in stock of product

    /**
     * This is the constructor for the product class
     *
     * @param price price of product
     * @param id id number of product
     * @param title title of product
     * @param amountInStock amount in stock available of product
     */
    public Product(double price, int id, String title, int amountInStock) {
        this.price = price;
        this.id = id;
        this.title = title;
        this.amountInStock = amountInStock;
    }

    /**
     * Gets price of product
     *
     * @return returns price of product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets ID number of product
     *
     * @return returns ID number
     */
    public int getId() {
        return id;
    }

    /**
     * Gets title of product
     *
     * @return returns title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets amount available in stock of a product
     *
     * @return available amount in stock
     */
    public int getAmountInStock() {
        return amountInStock;
    }

    /**
     * Sets the price of a product
     *
     * @param price the new price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets the ID number of a product
     *
     * @param id the ID number
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the amount available in stock of a product
     *
     * @param amountInStock available amount
     */
    public void setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }
}
