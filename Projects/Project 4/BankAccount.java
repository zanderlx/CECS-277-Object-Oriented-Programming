/**
 A bank account has a balance that can be changed by
 deposits and withdrawals.
 */
public class BankAccount
{
    private int numOfTransactions;
    private final int TRANSACTION_FEE = 1;
    private final int FREE_TRANSACTIONS = 5;
    private double balance;
    private double initialBalance, minimumBalance;
    private boolean isActive;
    /**
     Constructs a bank account with a zero balance.
     */
    public BankAccount()
    {
        setBalance(0);
        setMinimumBalance(0);
        setActive(false);

        setNumOfTransactions(0);
    }
    /**
     Constructs a bank account with a given balance.
     @param initialBalance the initial balance
     */
    public BankAccount(double initialBalance)
    {
        setBalance(initialBalance);
        setMinimumBalance(initialBalance);
        setActive(false);

        setNumOfTransactions(0);
    }
    /**
     Deposits money into the bank account.
     @param amount the amount to deposit
     */
    public void deposit(double amount)
    {
        numOfTransactions++;
        if(getBalance() < 0)
            System.out.printf("Balance before deposit: -$%,.2f", Math.abs(getBalance()));
        else
            System.out.printf("Balance before deposit: $%,.2f", getBalance());
        System.out.printf("%nDeposited: $%,.2f", amount);
        balance += amount;
        if(getBalance() < 0)
            System.out.printf("%nBalance after deposit: -$%,.2f", Math.abs(getBalance()));
        else
            System.out.printf("%nBalance after deposit: $%,.2f", getBalance());
    }
    /**
     Withdraws money from the bank account.
     @param amount the amount to withdraw
     */
    public void withdraw(double amount)
    {
        numOfTransactions++;

        double newBalance = balance - amount;
        setMinimumBalance(balance);
        if (newBalance < 0)
            balance -= 10;
        else
            balance = newBalance;

        if(minimumBalance > balance)
            setMinimumBalance(balance);
    }
    /**
     Gets the current balance of the bank account.
     @return the current balance
     */
    public double getBalance()
    {
        return balance;
    }

    /**
     * Sets the current balance of the bank account to the amount passed
     * @param amount the amount to set the balance
     */
    public void setBalance(double amount) { this.balance = amount; }

    /**
     * Gets the transaction fee of the account
     * @return The transaction fee of the account
     */
    public int getTRANSACTION_FEE() {
        return TRANSACTION_FEE;
    }

    /**
     * Gets the current number of transactions
     * @return The number of transactions
     */
    public int getNumOfTransactions() {
        return numOfTransactions;
    }

    /**
     * Sets the current number of transactions. This should not be changed explicity
     * @param numOfTransactions The number of transactions
     */
    public void setNumOfTransactions(int numOfTransactions) {
        this.numOfTransactions = numOfTransactions;
    }

    /**
     * Gets the amount of free transactions
     * @return The amount of free transactions
     */
    public int getFREE_TRANSACTIONS() {
        return FREE_TRANSACTIONS;
    }

    /**
     * Gets the initial balance of the account
     * @return The initial balance of the account
     */
    public double getInitialBalance() {
        return initialBalance;
    }

    /**
     * Sets the initial balance of the account
     * @param initialBalance The initial balance of the account
     */
    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    /**
     * Gets the current minimum balance of the account
     * @return The current minimum balance of the acount
     */
    public double getMinimumBalance() {
        return minimumBalance;
    }

    /**
     * Sets the current minimum balance of the account
     * @param balance The minimum balance found for the account
     */
    public void setMinimumBalance(double balance) {
        this.minimumBalance = balance;
    }

    /**
     * This method adds interest to the bank account
     * @param interestRate The interest rate of the account
     */
    public void addInterest(double interestRate) {
        double interestCharge = minimumBalance * (interestRate / 100);
        balance += interestCharge;
    }

    /**
     * @return Checks if the current account is activated
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Activates the current account if not activated
     * @param active
     */
    public void setActive(boolean active) {
        isActive = active;
    }

    /**
     * This method calculates fees that are received at the end of the month
     */
    public void endOfMonth()
    {
        addInterest(1);
        System.out.println("Added 1% interest rate to your balance");
        if (numOfTransactions > FREE_TRANSACTIONS)
            balance -= (numOfTransactions * TRANSACTION_FEE);
        else
            balance -= 0;
    }

    /**
     * Gets the string representation of the BankAccount class
     * @return Details about the BankAccount class
     */
    @Override
    public String toString() {
        return "BankAccount{" +
                "numOfTransactions=" + numOfTransactions +
                ", TRANSACTION_FEE=" + TRANSACTION_FEE +
                ", FREE_TRANSACTIONS=" + FREE_TRANSACTIONS +
                ", balance=" + balance +
                ", initialBalance=" + initialBalance +
                ", minimumBalance=" + minimumBalance +
                ", isActive=" + isActive +
                '}';
    }
}
