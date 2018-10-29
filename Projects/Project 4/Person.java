public class Person {
    private String name;
    private BankAccount checking;
    private BankAccount savings;

    public Person() {
        this.name = "No Name";
        checking = new Checking();
        savings = new Savings();
    }

    public Person(String name) {
        this.name = name;
        checking = new Checking(0);
        savings = new Savings(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "name='" + getName() + '\'' +
                ", checking=" + getChecking() +
                ", savings=" + getSavings() +
                '}';
    }
}
