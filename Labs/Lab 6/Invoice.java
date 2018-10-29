public class Invoice implements Payable{

    // Private Data Members
    private String ID, name;
    private int amount;
    private double price;

    // The Default Constructor for the Invoice Class
    public Invoice() {
        this.ID = "No ID";
        this.name = "No name";
        this.amount = 0;
        this.price = 0.0;
    }

    /**
     * The Overloaded Constructor for the Invoice Class
     * @param ID The ID of an item
     * @param name The name of an item
     * @param amount The quantity of an item
     * @param price The price of an item
     */
    public Invoice(String ID, String name, int amount, double price) {
        this.ID = ID;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    /**
     * This method gets the ID of an item
     * @return The ID of an item
     */
    public String getID() {
        return ID;
    }

    /**
     * This method sets the the ID number of an item
     * @param ID The ID number of an item
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * This method gets the name of an item
     * @return The name of an item
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the name of an item
     * @param name The name of an item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method gets the quantity of an item
     * @return The quantity of an item
     */
    public int getAmount() {
        return amount;
    }

    /**
     * This method sets the quantity of an item
     * @param amount The quantity of an item
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * This method gets the price of an item
     * @return The price of an item
     */
    public double getPrice() {
        return price;
    }

    /**
     * This method sets the price of an item
     * @param price The price of an item
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * This method gets the payment amount of an invoice
     * @return The amount of items times the price of an item
     */
    @Override
    public double getPaymentAmount() {
        return getAmount() * getPrice();
    }

    /**
     * This method gets the String representation of the Invoice Class
     * @return Details about the Invoice class
     */
    @Override
    public String toString() {
        return "Invoice #" + getID() + "for " + getAmount() + " "+ getName() +
                "s has a total cost of $" + getPaymentAmount();
    }
}
