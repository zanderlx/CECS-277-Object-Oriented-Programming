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
        try {
            double newBalance = getBalance() - amount;
            setMinimumBalance(getBalance());
            if (newBalance < 0)
                throw new OverdraftReached("Not enough money to withdraw!");
            else {
                System.out.printf("Withdrew: $%,.2f", amount);
                setBalance(newBalance);
            }
        } catch (OverdraftReached e) {
            System.out.println(e.getMessage());
        }
    }
}
