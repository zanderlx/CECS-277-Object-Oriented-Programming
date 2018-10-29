public class CommissionEmployee extends Employee {

    // Private Data Members
    private double sales;
    private double percentOfSales;

    // The Default Constructor
    public CommissionEmployee(){
        super();
        this.sales = 0;
        this.percentOfSales = 0.0;
    }

    /**
     * The Overloaded Constructor
     * @param firstName The first name of a Commission Employee
     * @param lastName The last name of a Commission Employee
     * @param SSN The SSN of a Commission Employee
     * @param sales The sales that an employee has made
     * @param percentOfSales Percentage of sales to be used for earnings
     */
    public CommissionEmployee(String firstName, String lastName, String SSN, double sales, double percentOfSales) {
        super(firstName, lastName, SSN);
        this.sales = sales;
        this.percentOfSales = percentOfSales;
    }

    /**
     * This method gets the sales
     * @return The sales of the employee
     */
    public double getSales() {
        return sales;
    }

    /**
     * This method sets the sales
     * @param sales The sales of an employee
     */
    public void setSales(double sales) {
        this.sales = (sales < 0.0) ? 0.0 : sales;
    }

    /**
     * This method gets the percentage of the sales
     * @return The percentage of the sales
     */
    public double getPercentOfSales() {
        return percentOfSales;
    }

    /**
     * This method sets the percentage of the sales
     * @param percentOfSales The percentage of the sales
     */
    public void setPercentOfSales(double percentOfSales) {
        this.percentOfSales = (percentOfSales > 0.0 && percentOfSales < 1.0) ? percentOfSales : 0.0;
    }

    /**
     * This method gets the earnings of a Commission Employee
     * @return The earnings of this employee
     */
    @Override
    public double earnings() {
        return sales * percentOfSales;
    }

    /**
     * This method gets the equality of two CommissionEmployee objects
     * @param o An object to be compared to
     * @return A boolean value of equality
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof CommissionEmployee)) return false;

        CommissionEmployee that = (CommissionEmployee) o;

        if (getSSN().equalsIgnoreCase(that.getSSN())) return false;
        if (getFirstName() != null) if (!getFirstName().equalsIgnoreCase(that.getFirstName())) return false;
        if (getLastName() != null) if(!getLastName().equalsIgnoreCase(that.getLastName())) return false;

        return true;
    }

    /**
     * This method gets the hashcode of an CommissionEmployee
     * @return An integer representing the hashcode of an CommissionEmployee
     */
    @Override
    public int hashCode() {
        return super.hashCode() + (int)sales + (int)percentOfSales;
    }

    /**
     * The String representation of an CommissionEmployee
     * @return Details about an CommissionEmployee
     */
    @Override
    public String toString() {
        return "\nCommissionEmployee{" +
                super.toString() +
                "sales=" + sales +
                ", percentOfSales=" + percentOfSales;
    }
}
