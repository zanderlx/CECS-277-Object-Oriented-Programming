public class Checking extends BankAccount{

    private final double OVERDRAFT_LIMIT = 1000;
    private final double OVERDRAFT_FEE = 25;

    /**
     * The default constructor fir the Checking class
     */
    public Checking() {
        super();
    }

    /**
     * The overloaded constructor for the Checking class
     * @param initialBalance The initial balance for the account
     */
    public Checking(double initialBalance) {
        super(initialBalance);
    }

    /**
     * Overridden withdraw method based on the overdraft limit and overdraft fee
     * @param amount the amount to withdraw
     */
    @Override
    public void withdraw(double amount){

        try {
            if (Math.abs(getBalance()) > OVERDRAFT_LIMIT)
                throw new OverdraftReached("\nCannot withdraw anymore! Overdraft limit reached!");
            else {
                double newBalance = getBalance() - amount;
                super.setMinimumBalance(getBalance());

                // Displays the balance before withdrawing
                if(getBalance() < 0)
                    System.out.printf("%nBalance before withdrawing: -$%,.2f", Math.abs(getBalance()));
                else
                    System.out.printf("%nBalance before withdrawing: $%,.2f", getBalance());

                if (newBalance < 0) { // Overdraft since less than balance
                    if (Math.abs(newBalance) > OVERDRAFT_LIMIT) {
                        if (getBalance() > 0)
                            System.out.printf("\nWithdrawing: $%,.2f", (getBalance() + OVERDRAFT_LIMIT));
                        else if (getBalance() < 0 && Math.abs(getBalance()) < OVERDRAFT_LIMIT)
                            System.out.printf("\nWithdrawing: $%,.2f", (getBalance() + OVERDRAFT_LIMIT));
                        else if (getBalance() == 0 &&  Math.abs(getBalance()) < OVERDRAFT_LIMIT)
                            System.out.printf("\nWithdrawing: $%,.2f", (getBalance() + OVERDRAFT_LIMIT));
                        else
                            System.out.print("\nWithdrawing: $0");
                        setBalance(-OVERDRAFT_LIMIT - OVERDRAFT_FEE);

                    } else {
                        System.out.printf("\nWithdrawing $%,.2f", Math.abs(getBalance() - amount));
                        setBalance(newBalance - OVERDRAFT_FEE);
                        //if (Math.abs(getBalance()) > OVERDRAFT_LIMIT);
                    }
                }
                else { // If there is no overdraft fee, withdraw normally
                    System.out.printf("%nWithdrew: $%,.2f", amount);
                    setBalance(newBalance);
                }
                // This section actually withdraws from the balance

                // Displays balance after withdrawing
                if(getBalance() < 0)
                    System.out.printf("%nBalance after withdrawing: -$%,.2f", Math.abs(getBalance()));
                else
                    System.out.printf("%nBalance after withdrawing: $%,.2f", getBalance());

                // Checks the minimum balance of the month
                if(getMinimumBalance() > getBalance())
                    setMinimumBalance(getBalance());
            }
        } catch (OverdraftReached e) {
            System.out.println(e.getMessage());
        }
    }

    public double getOVERDRAFT_LIMIT() {
        return OVERDRAFT_LIMIT;
    }

    public double getOVERDRAFT_FEE() {
        return OVERDRAFT_FEE;
    }

    /**
     * Displays the string representation of the object
     * @return Details about the object
     */
    @Override
    public String toString() {
        return "Checking{" +
                "OVERDRAFT_LIMIT=" + getOVERDRAFT_LIMIT() +
                ", OVERDRAFT_FEE=" + getOVERDRAFT_FEE() +
                ", isActive=" + isActive() +
                '}';
    }
}
