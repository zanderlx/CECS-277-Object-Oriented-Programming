public class BasePlusCommissionEmployee extends CommissionEmployee{

    // Private Data Members
    private double salariedCommissionReward;

    // The Default Constructor
    public BasePlusCommissionEmployee() {
        super();
        this.salariedCommissionReward = salariedCommissionReward;
    }

    /**
     * The Overloaded Constructor
     * @param firstName The first name of an employee
     * @param lastName The last name of an employee
     * @param SSN The SSN of an employee
     * @param sales The sales of an employee
     * @param percentOfSales The percentage of sales of an employee
     * @param salariedCommissionReward The base plus reward of an employee
     */
    public BasePlusCommissionEmployee(String firstName, String lastName, String SSN, int sales, double percentOfSales, double salariedCommissionReward) {
        super(firstName, lastName, SSN, sales, percentOfSales);
        this.salariedCommissionReward = salariedCommissionReward;
    }

    /**
     * This method gets the base plus reward for this employee
     * @return The base plus reward
     */
    public double getSalariedCommissionReward() {
        return salariedCommissionReward;
    }

    /**
     * This method sets the base plus reward for this employee
     * @param salariedCommissionReward The base plus reward
     */
    public void setSalariedCommissionReward(double salariedCommissionReward) {
        this.salariedCommissionReward = (salariedCommissionReward < 0.0) ? 0.0 : salariedCommissionReward;
    }

    /**
     * This method gets the earnings of a BasePlusCommissionEmployee
     * @return The earnings of this employee
     */
    @Override
    public double earnings() {
        return super.earnings() + salariedCommissionReward;
    }

    /**
     * This method gets the equality of two BasePlusCommissionEmployee objects
     * @param o An object to be compared to
     * @return A boolean value of equality
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof BasePlusCommissionEmployee)) return false;

        BasePlusCommissionEmployee that = (BasePlusCommissionEmployee) o;

        if (getSSN().equalsIgnoreCase(that.getSSN())) return false;
        if (getFirstName() != null) if (!getFirstName().equalsIgnoreCase(that.getFirstName())) return false;
        if (getLastName() != null) if (!getLastName().equalsIgnoreCase(that.getLastName())) return false;
        if (getSalariedCommissionReward() != that.getSalariedCommissionReward()) return false;

        return true;
    }

    /**
     * This method gets the hashcode of an BasePlusCommissionEmployee
     * @return An integer representing the hashcode of an BasePlusCommissionEmployee
     */
    @Override
    public int hashCode() {
        return super.hashCode() + (int)salariedCommissionReward;
    }

    /**
     * The String representation of an BasePlusCommissionEmployee
     * @return Details about an BasePlusCommissionEmployee
     */
    @Override
    public String toString() {
        return "BasePlusCommissionEmployee extends " +
                super.toString() +
                "\nBase Plus Reward: $"  + salariedCommissionReward;
    }
}
