public class ComboLock
{
    // Private data attributes for the ComboLock class
    private int code1, code2, code3, current;
    private boolean found1, found2, found3;
    private final int MAX_LOCK_TICKS;

    /**
     * An overloaded constructor (and only constructor) for the ComboLock class
     * @param code1 The correct code for the first number in the combination
     * @param code2 The correct code for the first number in the combination
     * @param code3 The correct code for the first number in the combination
     */
    public ComboLock(int code1, int code2, int code3)
    {
        reset();
        this.code1 = code1;
        this.code2 = code2;
        this.code3 = code3;
        this.found1 = false;
        this.found2 = false;
        this.found3 = false;
        this.MAX_LOCK_TICKS = 40;
    }

    /**
     * Resets everything about the interactions for the lock
     */
    public void reset()
    {
        this.current = 0;
        this.found1 = false;
        this.found2 = false;
        this.found3 = false;
    }

    /**
     * Turns the knob LEFT by a number of ticks
     * @param ticks The number of ticks the user wants to turn by
     */
    public void turnLeft(int ticks)
    {
        current -= ticks;
        if(current < 0)
            current += MAX_LOCK_TICKS;
        System.out.print("You landed on " + (current % MAX_LOCK_TICKS) + "\n");
        if(current % MAX_LOCK_TICKS == code2)
            found2 = true;
    }

    /**
     * Turns the knob RIGHT by a number of ticks
     * @param ticks The number of ticks the user wants to turn by
     */
    public void turnRight(int ticks)
    {
        current += ticks;
        System.out.print("You landed on " + (current % MAX_LOCK_TICKS) + "\n");
        if(current % MAX_LOCK_TICKS == code1)
            found1 = true;
        else if(current % MAX_LOCK_TICKS == code3 && found1 == true)
            found3 = true;
    }

    /**
     * Checks if the lock was opened based on the correction of the
     * user's correct combination
     * @return The boolean value (true or false) based on if all
     * the combination guesses were correct
     */
    public boolean open()
    {

        if(found1 && found2 && found3)
            return true;
        return false;
    }

    /**
     * Gets the first code for the correct combination
     * @return
     */
    public int getCode1() {
        return code1;
    }

    /**
     * Sets the first code of the combination
     * @param code1 The first number of the combination
     */
    public void setCode1(int code1) {
        this.code1 = code1;
    }

    /**
     * Gets the second code for the correct combination
     * @return
     */
    public int getCode2() {
        return code2;
    }

    /**
     * Sets the second code of the combination
     * @param code2 The first number of the combination
     */
    public void setCode2(int code2) {
        this.code2 = code2;
    }

    /**
     * Gets the third code for the correct combination
     * @return
     */
    public int getCode3() {
        return code3;
    }

    /**
     * Sets the third code of the combination
     * @param code3 The first number of the combination
     */
    public void setCode3(int code3) {
        this.code3 = code3;
    }

    /**
     * Gets the current location of the pointer on the lock
     * @return The location of the pointer on the lock
     */
    public int getCurrent() {
        return current;
    }

    /**
     * Sets the current location of the pointer on the lock
     * (This should not be able to change)
     * @param current The current location of the pointer on the lock
     */
    public void setCurrent(int current) {
        this.current = current;
    }

    /**
     * Checks if the first number for the combination was found
     * @return True if first number is found, else false
     */
    public boolean isFound1() {
        return found1;
    }

    /**
     * Sets the condition for the value of being found
     * (This should not be changed by the user while running the program)
     * @param found1 The condition for the value of being found
     */
    public void setFound1(boolean found1) {
        this.found1 = found1;
    }

    /**
     * Checks if the second number for the combination was found
     * @return True if second number is found, else false
     */
    public boolean isFound2() {
        return found2;
    }

    /**
     * Sets the condition for the value of being found
     * (This should not be changed by the user while running the program)
     * @param found2 The condition for the value of being found
     */
    public void setFound2(boolean found2) {
        this.found2 = found2;
    }

    /**
     * Checks if the third number for the combination was found
     * @return True if third number is found, else false
     */
    public boolean isFound3() {
        return found3;
    }

    /**
     * Sets the condition for the value of being found
     * (This should not be changed by the user while running the program)
     * @param found3 The condition for the value of being found
     */
    public void setFound3(boolean found3) {
        this.found3 = found3;
    }

    /**
     * Gets the number of max ticks for the lock.
     * This value CANNOT be changed
     * @return The number of max ticks for the lock
     */
    public int getMAX_LOCK_TICKS() {
        return MAX_LOCK_TICKS;
    }

    /**
     * Gets the string representation for all the attributes
     * for the ComboLock class
     * @return The string representation for all attributes
     */
    @Override
    public String toString() {
        return "ComboLock{" +
                "code1=" + code1 +
                ", code2=" + code2 +
                ", code3=" + code3 +
                ", current=" + current +
                ", found1=" + found1 +
                ", found2=" + found2 +
                ", found3=" + found3 +
                ", MAX_LOCK_TICKS=" + MAX_LOCK_TICKS +
                '}';
    }
}
