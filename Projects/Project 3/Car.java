public class Car implements Vehicle{
    /** Private member variables */
    private int size, gear, speed;
    private String color;

    /** Default Constructor */
    public Car(){
        this.size = 0;
        this.color = "None";
        this.setGear(0);
    }

    /** Overloaded Constructor */
    public Car(int size, String color){
        this.size = size;
        this.color = color;
        this.setGear(0);
    }

    /**
     * Gets the size (Max # of people) for the Car
     * @return The max # of people the Car can hold
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the size (Max # of people) for the Car
     * @param size The max # of people the Car can hold
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Gets the gear that the Car is set to
     * @return The gear that the Car is set to
     */
    public int getGear() {
        return gear;
    }

    /**
     * Sets the value of the gear box for the Car
     * @param gear The value of the gear box for the Car
     */
    public void setGear(int gear) {
        this.gear = gear;
    }

    /**
     * Gets the current speed of the Car
     * @return The current speed of the Car
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Sets the speed that the Car will be moving by
     * @param speed The current speed of the Car
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Gets the current color that the Car was set to
     * @return The current color of the Car
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the current color of the Car
     * @param color The current color of the car
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Gets the information about the attributes of the Car class
     * @return Information about the Car class attributes
     */
    @Override
    public String toString() {
        return "Car{" +
                "size=" + size +
                ", gear=" + gear +
                ", speed=" + speed +
                ", color='" + color + '\'' +
                '}';
    }

    /**
     * Implements abstract methods defined in the interface Vehicle
     * Changes the gear that the Vehicle is currently at
     * @param gear The gear value for the Vehicle
     */
    @Override
    public void changeGear(int gear) {
        this.gear = gear;
    }

    /**
     * Implements abstract methods defined in the interface Vehicle
     * Accelerates the Vehicle by increasing the speed
     * @param speed The value used to accelerate
     */
    @Override
    public void accelerate(int speed) {
        this.speed += speed;
    }

    /**
     * Implements abstract methods defined in the interface Vehicle
     * Decelerates the Vehicle by decreasing the speed
     * @param speed The value used to decelerate
     */
    @Override
    public void decelerate(int speed) {
        this.speed -= speed;
    }
}
