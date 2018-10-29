public class HourlyEmployee extends Employee{

    // Private Data Members
    private double hourlyRate;
    private double hoursWorked;
    private final double OVERTIME_RATE = 1.5;
    private final double NON_OVERTIME_HOURS = 40;

    // Default Constructor
    public HourlyEmployee() {
        super();
        this.hourlyRate = 0;
        this.hoursWorked = 0;
    }

    /**
     * The Overloaded Constructor
     * @param firstName The first name of an employee
     * @param lastName The last name of an employee
     * @param SSN The SSN of an employee
     * @param hourlyRate The hourly wage of an employee
     * @param hoursWorked the amount of hours worked by an employee
     */
    public HourlyEmployee(String firstName, String lastName, String SSN, double hourlyRate, double hoursWorked) {
        super(firstName, lastName, SSN);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    /**
     * This method gets the hourly wage of an employee
     * @return The hourly wage of an employee
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * This method sets the hourly wage of an employee
     * @param hourlyRate The hourly wage of an employee
     */
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = (hourlyRate < 0.0) ? 0.0 : hourlyRate;
    }

    /**
     * This method gets the hours worked
     * @return The hours worked for an employee
     */
    public double getHoursWorked() {
        return hoursWorked;
    }

    /**
     * This method sets the hours worked
     * @param hoursWorked The hours worked for an employee
     */
    public void setHoursWorked(double hoursWorked) {
        double maxHoursInAWeek = 168.0;
        this.hoursWorked = (hoursWorked >= 0.0) && (hoursWorked <= maxHoursInAWeek) ? hoursWorked : 0.0;
    }

    /**
     * This method gets the earnings for an hourly employee
     * @return The earnings for an hourly employee
     */
    @Override
    public double earnings() {
        double earnings;
        if (hoursWorked <= NON_OVERTIME_HOURS) // If the hours worked is less than or equal to 40
            earnings = hoursWorked * hourlyRate;
        else // Employee worked overtime
            earnings = NON_OVERTIME_HOURS * hourlyRate + (hoursWorked - NON_OVERTIME_HOURS) * hourlyRate * OVERTIME_RATE;
        return earnings;
    }

    /**
     * This method gets the equality of two HourlyEmployee objects
     * @param o An object to be compared to
     * @return A boolean value of equality
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof HourlyEmployee)) return false;

        HourlyEmployee that = (HourlyEmployee) o;

        if (getSSN().equalsIgnoreCase(that.getSSN())) return false;
        if (getFirstName() != null) if (!getFirstName().equalsIgnoreCase(that.getFirstName())) return false;
        if (getLastName() != null) if(!getLastName().equalsIgnoreCase(that.getLastName())) return false;
        if (getHoursWorked() != that.getHoursWorked()) return false;
        if (getHourlyRate() != that.getHourlyRate()) return false;

        return true;
    }

    /**
     * This method gets the hashcode of an HourlyEmployee
     * @return An integer representing the hashcode of an HourlyEmployee
     */
    @Override
    public int hashCode() {
        return super.hashCode() + (int)hourlyRate + (int)hoursWorked;
    }

    /**
     * The String representation of an HourlyEmployee
     * @return Details about an HourlyEmployee
     */
    @Override
    public String toString() {
        return "HourlyEmployee extends" +
                super.toString() +
                "\nHourly Rate: $" + hourlyRate +
                "\nHours Worked: " + hoursWorked +
                "\nOvertime Hours Rate: $" + OVERTIME_RATE +
                "\nNormal Hours: " + NON_OVERTIME_HOURS;
    }
}
