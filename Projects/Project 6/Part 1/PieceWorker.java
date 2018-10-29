public class PieceWorker extends Employee{
    // Private Data Members
    private int pieces;
    private double wage;

    // The Default Constructor
    public PieceWorker() {
        super();
        this.pieces = 0;
        setWage(0.0);
    }

    /**
     * The Overloaded Constructor
     * @param firstName The first name of an Employee
     * @param lastName  The last name of an Employee
     * @param SSN       An employee's social security number
     * @param pieces    The amount of pieces produced
     * @param wage      Wage per pieces produced
     */
    public PieceWorker(String firstName, String lastName, String SSN, int pieces, double wage) {
        super(firstName, lastName, SSN);
        this.pieces = pieces;
        setWage(wage);
    }

    /**
     * This method gets the number of pieces produced
     * @return The number of pieces produced
     */
    public int getPieces() {
        return pieces;
    }

    /**
     * This method sets the number of pieces produced
     * @param pieces The number of pieces produced
     */
    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    /**
     * This method gets the wage per piece produced
     * @return The wage per piece produced
     */
    public double getWage() {
        return wage;
    }

    /**
     * This method sets the wage per piece produced
     * @param wage The wage per piece produced
     */
    public void setWage(double wage) {
        this.wage = ( wage < 0.0 ) ? 0.0 : wage;
    }

    /**
     * Abstract method to get the earnings of a specific employee
     * @return The earnings of a specific employee
     */
    @Override
    public double earnings() {
        return wage * pieces;
    }

    /**
     * This method gets the equality of two PieceWorker objects
     * @param o An object to be compared to
     * @return A boolean value of equality
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null) return false;
        if (!(o instanceof PieceWorker)) return false;

        PieceWorker that = (PieceWorker) o;

        if (getSSN().equalsIgnoreCase(that.getSSN())) return false;
        if (getFirstName() != null) if (!getFirstName().equalsIgnoreCase(that.getFirstName())) return false;
        if (getLastName() != null) if(!getLastName().equalsIgnoreCase(that.getLastName())) return false;
        if (getPieces() != that.getPieces()) return false;
        if (getWage() != that.getWage()) return false;

        return true;
    }

    /**
     * This method gets the hashcode of a PieceWorker
     * @return An integer representing the hashcode of a PieceWorker
     */
    @Override
    public int hashCode() {
        return super.hashCode() + (int)wage + pieces;
    }

    /**
     * The String representation of a PieceWorker
     * @return Details about a PieceWorker
     */
    @Override
    public String toString() {
        return "Pieceworker extends" +
                super.toString() +
                "\nPieces Produced: " + pieces +
                "\nWage per Piece: $" + wage;
    }

}
