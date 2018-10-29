public class SalariedEmployee extends Employee{

    // Private Data Members
    private double weeklySalary;

    // The Default Constructor
    public SalariedEmployee() {
        super();
        this.setWeeklySalary(0);
    }

    /**
     * The Overloaded Constructor
     * @param firstName The first name of a Salaried Employee
     * @param lastName The last name of a Salaried Employee
     * @param SSN The SSN of an Salaried Employee
     * @param weeklySalary The constant weekly salary of a Salaried Employee
     */
    public SalariedEmployee(String firstName, String lastName, String SSN, double weeklySalary) {
        super(firstName, lastName, SSN);
        this.setWeeklySalary(weeklySalary);
    }

    /**
     * This method gets the weekly salary
     * @return The weekly salary
     */
    public double getWeeklySalary() {
        return weeklySalary;
    }

    /**
     * This method sets the weekly salary
     * @param weeklySalary The weekly salary
     */
    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = (weeklySalary < 0.0) ? 0.0 : weeklySalary;
    }

    /**
     * This method gets the earnings for a salaried employee
     * @return The earnings for a salaried employee
     */
    @Override
    public double earnings() {
        return weeklySalary;
    }

    /**
     * This method gets the equality of two SalariedEmployee objects
     * @param o An object to be compared to
     * @return A boolean value of equality
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof SalariedEmployee)) return false;

        SalariedEmployee that = (SalariedEmployee) o;

        if (getSSN().equalsIgnoreCase(that.getSSN())) return false;
        if (getFirstName() != null) if (!getFirstName().equalsIgnoreCase(that.getFirstName())) return false;
        if (getLastName() != null) if(!getLastName().equalsIgnoreCase(that.getLastName())) return false;

        return true;
    }

    /**
     * This method gets the hashcode of an SalariedEmployee
     * @return An integer representing the hashcode of an SalariedEmployee
     */
    @Override
    public int hashCode() {
        return super.hashCode() + (int)weeklySalary;
    }

    /**
     * The String representation of an SalariedEmployee
     * @return Details about an SalariedEmployee
     */
    @Override
    public String toString() {
        return "\nSalariedEmployee{" +
                super.toString() +
                "weeklySalary=" + weeklySalary;
    }
}
