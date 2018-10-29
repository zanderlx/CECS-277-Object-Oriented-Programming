public class CommissionEmployee {

    private String firstName, lastName;
    private int SSN;
    private double commissionRate, gross;

    public CommissionEmployee() {
        this.firstName = "No First Name";
        this.lastName = "No Last Name";
        this.SSN = 0;
        this.commissionRate = 0.0;
        this.gross = 0.0;
    }

    public CommissionEmployee(String firstName, String lastName, int SSN, double commissionRate, double gross) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.commissionRate = commissionRate;
        this.gross = gross;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getGross() {
        return gross;
    }

    public void setGross(int gross) {
        this.gross = gross;
    }

    /**
     * This method overrides the equals method from the Object class
     * @param o The object being compared
     * @return The boolean value
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof CommissionEmployee)) return false;

        CommissionEmployee that = (CommissionEmployee) o;

        if (getSSN() != that.getSSN()) return false;
        if (getCommissionRate() != that.getCommissionRate()) return false;
        if (getGross() != that.getGross()) return false;
        if (getFirstName() != null)
            if (!getFirstName().equals(that.getFirstName())) return false;
        else return false;
        if (getLastName() != null)
            if(!getLastName().equals(that.getLastName())) return false;

        return true;
    }

    public String getClassType(){
        return "Class Type is " + this.getClass().getName();
    }

    @Override
    public int hashCode() {
        int result = 0;

        for (int i = 0; i < getFirstName().length(); i++) {
            char letter = getFirstName().charAt(i);
            result += (int)letter;
        }

        for (int j = 0; j < getLastName().length(); j++) {
            char letter = getFirstName().charAt(j);
            result += (int)letter;
        }

        result += getSSN();
        result += (int)getCommissionRate();
        result += (int)getGross();

        return result;
    }

    @Override
    public String toString() {
        return "CommissionEmployee{" +
                "Class=" + this.getClass() + '\'' +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", SSN=" + SSN +
                ", commissionRate=" + commissionRate +
                ", gross=" + gross +
                '}';
    }
}
