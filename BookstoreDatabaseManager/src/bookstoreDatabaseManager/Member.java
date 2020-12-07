package bookstoreDatabaseManager;

/**
 * This is the Member class and its fields. It is extended by Premium
 *
 * @author Chase Scallion
 * @version 11/15/2019
 */
public class Member {

    private String name;
    private int memberId;
    private double amountSpent;

    /**
     * This is the constructor for the member class
     *
     * @param name name of member
     * @param memberId ID number of member
     * @param amountSpent amount spent by member
     */
    public Member(String name, int memberId, double amountSpent) {
        this.name = name;
        this.memberId = memberId;
        this.amountSpent = amountSpent;
    }

    /**
     * Gets the name of a member
     *
     * @return returns name of member
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of a member
     *
     * @param name the name of a member
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the ID number of a member
     *
     * @param memberId ID number of member
     */
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    /**
     * Gets the ID number of a member
     *
     * @return returns ID number
     */
    public int getMemberId() {
        return memberId;
    }

    /**
     * Gets amount spent by a member
     *
     * @return returns amount spent by member
     */
    public double getAmountSpent() {
        return amountSpent;
    }

    /**
     * Sets the amount spent by a member
     *
     * @param amountSpent the amount spent by member
     */
    public void setAmountSpent(double amountSpent) {
        this.amountSpent = amountSpent;
    }
}
