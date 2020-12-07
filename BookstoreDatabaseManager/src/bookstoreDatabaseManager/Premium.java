package bookstoreDatabaseManager;

/**
 * This is the Premium class and its fields. It extends Member
 *
 * @author Chase Scallion
 * @version 11/15/2019
 */
public class Premium extends Member {

    private boolean hasPaid;
    private double discount;

    /**
     * This is the constructor of the Premium class
     *
     * @param name name of the member
     * @param memberId ID number of the member
     * @param amountSpent amount spent by the member
     * @param hasPaid premium status of member
     * @param discount discount percentage of member
     */
    public Premium(String name, int memberId, double amountSpent, boolean hasPaid, double discount) {
        super(name, memberId, amountSpent);
        this.hasPaid = hasPaid;
        this.discount = discount;
    }

    /**
     * This gets the premium status of a member
     *
     * @return returns premium status
     */
    public boolean isHasPaid() {
        return hasPaid;
    }

    /**
     * This sets the amount a member has spent at the book store
     *
     * @param hasPaid amount member has spent
     */
    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }

    /**
     * This gets the discount percentage of a member
     *
     * @return returns discount amount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * This sets the discount amount of a member
     *
     * @param discount discount percentage of a member
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
