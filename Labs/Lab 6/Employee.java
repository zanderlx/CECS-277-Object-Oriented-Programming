public abstract class Employee implements Payable{
    // Private Data Members
    private String firstName, lastName, SSN;

    // The Default Constructor
    public Employee() {
        this.firstName = "No first name";
        this.lastName = "No last name";
        this.SSN = "No SSN";
    }

    /**
     * The Overloaded Constructor
     * @param firstName The first name of an employee
     * @param lastName The last name of an employee
     * @param SSN The SSN of an employee
     */
    public Employee(String firstName, String lastName, String SSN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
    }

    /**
     * This method gets the first name of an employee
     * @return The first name of an employee
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This method sets the first name of an employee
     * @param firstName The first name of an employee
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * This method gets the last name of an employee
     * @return The last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method sets the last name of an employee
     * @param lastName The last name of an employee
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * This method gets the SSN of an employee
     * @return The SSN of an employee
     */
    public String getSSN() {
        return SSN;
    }

    /**
     * This method sets the SSN of an employee
     * @param SSN The SSN of an employee
     */
    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    /**
     * This method gets the "earnings" of an employee
     * @return The "earnings" of an employee
     */
    @Override
    public abstract double getPaymentAmount();

    /**
     * The String representations of the Employee Class
     * @return Details about the Employee Class
     */
    @Override
    public String toString() {
        return "Employee Name: " + getFirstName() + " " + getLastName() +
                "\nEmployee SSN: " + getSSN();
    }
}
