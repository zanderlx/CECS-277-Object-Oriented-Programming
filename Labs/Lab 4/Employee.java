import java.lang.Comparable;

/** An abstract class Employee that represents the general concept of an employee */
public abstract class Employee implements Comparable<Employee>
{
    // Private data members
    private String firstName, lastName, SSN;

    // Default Constructor
    public Employee()
    {
        this.firstName = "No First Name";
        this.lastName = "No Last Name";
        this.SSN = "No SSN";
    }

    /**
     * The Overloaded Constructor
     * @param firstName The first name of an Employee
     * @param lastName The last name of an employee
     * @param SSN An employee's social security number
     */
    public Employee(String firstName, String lastName, String SSN)
    {
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
     * @return The last name of an employee
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
     * Abstract method to get the earnings of a specific employee
     * @return The earnings of a specific employee
     */
    public abstract double earnings();

    /**
     * This method returns the integer value of the comparisons of two characters
     * @param employee The explicit object that we are comparing to
     * @return <0 if implicit object is less than explicit object, 0 if implicit object is equal to explicit object,
     *          >0 if implicit object is greater than explicit object
     */
    @Override
    public int compareTo(Employee employee)
    {
        if (getFirstName().toLowerCase().charAt(1) == employee.getFirstName().toLowerCase().charAt(1)) return 0;
        else return (getFirstName().toLowerCase().charAt(1) < employee.getFirstName().toLowerCase().charAt(1)) ? -1 : 1;
    }

    /**
     * This method gets the equality of two Employee objects
     * @param o An object to be compared to
     * @return A boolean value of equality
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Employee)) return false;

        Employee that = (Employee) o;

        if (getSSN().equalsIgnoreCase(that.getSSN())) return false;
        if (getFirstName() != null) if (!getFirstName().equalsIgnoreCase(that.getFirstName())) return false;
        if (getLastName() != null) if(!getLastName().equalsIgnoreCase(that.getLastName())) return false;

        return true;
    }

    /**
     * This method gets the hashcode of an Employee
     * @return An integer representing the hashcode of an Employee
     */
    @Override
    public int hashCode(){
        int result = 0;

        for (int x = 0; x < getFirstName().length(); x++) {
            char letter = getFirstName().charAt(x);
            result += (int)letter;
        }

        for (int y = 0; y < getLastName().length(); y++) {
            char letter = getLastName().charAt(y);
            result += (int)letter;
        }

        for (int z = 0; z < getSSN().length(); z++) {
            char letter = getSSN().charAt(z);
            result += (int)letter;
        }

        return result;
    }

    /**
     * The String representation of an Employee
     * @return Details about an Employee
     */
    @Override
    public String toString() {
        return "\nEmployee" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", SSN=" + SSN + "\n";
    }
}
