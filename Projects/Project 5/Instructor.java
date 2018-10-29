public class Instructor extends Person{

    private String name;
    private BankAccount checking;
    private BankAccount savings;

    /** Default Constructor for the Instructor class */
    public Instructor() {
        super();
        checking = new Checking();
        savings = new Savings();
    }

    /** Overloaded Constructor for the Instructor class */
    public Instructor(String name) {
        super(name);
        checking = new Checking(0);
        savings = new Savings(0);
    }

    /**
     * Gets the checking account for the student
     * @return The checking account of the student
     */
    public BankAccount getChecking() {
        return checking;
    }

    /**
     * Sets the current checking account of the student
     * @param checking The account that will be set to the Checking account
     */
    public void setChecking(Checking checking) {
        this.checking = checking;
    }

    /**
     * Gets the current savings account of the student
     * @return The savings account of the student
     */
    public BankAccount getSavings() {
        return savings;
    }

    /**
     * Sets the current savings account of the student
     * @param savings The account that the Savings account will be set to
     */
    public void setSavings(BankAccount savings) {
        this.savings = savings;
    }

    /**
     * The string representation of the Student class
     * @return Details about the student class
     */
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", checking=" + checking +
                ", savings=" + savings +
                '}';
    }
}
