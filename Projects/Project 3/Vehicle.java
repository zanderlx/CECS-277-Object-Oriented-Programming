public interface Vehicle {
    /**
     * Changes the gear that the Vehicle is currently at
     * @param gear The gear value for the Vehicle
     */
    void changeGear(int gear);

    /**
     * Accelerates the Vehicle by increasing the speed
     * @param speed The value used to accelerate
     */
    void accelerate(int speed);

    /**
     * Decelerates the Vehicle by decreasing the speed
     * @param speed The value used to decelerate
     */
    void decelerate(int speed);
}
