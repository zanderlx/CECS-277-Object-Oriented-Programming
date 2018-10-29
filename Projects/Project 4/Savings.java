public class Savings extends BankAccount{

    /**
     * The default constructor for the Savings class
     */
    public Savings() {
        super();
    }

    /**
     * The overloaded constructor for the Savings class
     * @param initialBalance The amount to set the balance to
     */
    public Savings(double initialBalance) {
        super(initialBalance);
    }

    /**
     * Overridden withdraw method that withdraws only if
     * there is sufficient amount in balance
     * @param amount the amount to withdraw
     */
    @Override
    public void withdraw(double amount) {
        double newBalance = getBalance() - amount;
        setMinimumBalance(getBalance());
        // If not sufficient amount do nothing to the account
        if (newBalance < 0)
            System.out.println("Not enough money to withdraw!");
        else {
            System.out.printf("Withdrew: $%,.2f", amount);
            setBalance(newBalance);
        }
    }
}
