public class Truck extends Car{
    /** Private member variables */
    private int numOfPassengers;

    /** Default Constructor */
    public Truck(){
        super();
        this.numOfPassengers = 0;
    }

    /** Overloaded Constructor */
    public Truck(int maxNumOfPassengers, String color){
        super(maxNumOfPassengers, color);
        this.numOfPassengers = 1;
    }

    /**
     * Gets the number of passengers in the vehicle
     * @return The number of passengers in the vehicle
     */
    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    /**
     * Sets the number of passengers in the vehicle
     * @param numOfPassengers The number of passengers in the vehicle
     */
    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }

    /**
     * Gets the information of the attributes of this class and its superclass
     * @return Information of the attributes of this class and its superclass
     */
    @Override
    public String toString() {
        return  super.toString() +
                "\nTruck{" +
                "numOfPassengers=" + numOfPassengers +
                '}';
    }
}
