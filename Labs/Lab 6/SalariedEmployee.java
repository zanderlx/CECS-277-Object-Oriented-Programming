public class SalariedEmployee extends Employee{
    // Private Data Members
    private double weeklySalary;

    // The Default Constructor of the SalariedEmployee Class
    public SalariedEmployee() {
        super();
        this.weeklySalary = 0.0;
    }

    /**
     * The Overloaded Constructor of the SalariedEmployee Class
     * @param firstName The first name of an employee
     * @param lastName The last name of an employee
     * @param SSN The SSN of an employee
     * @param weeklySalary The weekly salary of an employee
     */
    public SalariedEmployee(String firstName, String lastName, String SSN, double weeklySalary) {
        super(firstName, lastName, SSN);
        this.weeklySalary = weeklySalary;
    }

    /**
     * This method gets the weekly salary of an employee
     * @return The weekly salary of an employee
     */
    public double getWeeklySalary() {
        return weeklySalary;
    }

    /**
     * This method sets the weekly salary of an employee
     * @param weeklySalary The weekly salary of an employee
     */
    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    /**
     * This method gets the earnings of a salary of a salary-based employee
     * @return The salary of an salary-based employee
     */
    @Override
    public double getPaymentAmount() {
        return getWeeklySalary();
    }

    /**
     * The String representation of the SalariedEmployee Class
     * @return Details about the SalariedEmployee Class
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nType of Employee: Salary-Based" +
                "\nWeekly Salary: $" + getPaymentAmount();
    }
}
