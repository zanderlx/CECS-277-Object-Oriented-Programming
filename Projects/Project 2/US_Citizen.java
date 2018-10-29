import java.util.Random;

// Start class US_Citizen
public class US_Citizen extends Person{
    // Private data attributes for the US_Citizen class
    private boolean isUSCitizen;
    private String SSN;

    /**
     * Default Constructor for the US_Citizen class
     */
    // Start default constructor US_Citizen()
    public US_Citizen(){
        super();
        SSN = "000 00 0000";
    } // End default constructor US_Citizen()

    /**
     * Overloaded constructor for the US_Citizen class
     * @param isUSCitizen The boolean value that checks if the user is a US citizen
     * @param name The name of the user
     * @param gender The gender of the user
     * @param address The address of the user
     * @param eyeColor The eye color of the user
     * @param weight The weight of the user
     * @param height The height of the user
     * @param age The age of the user
     * @param birthMonth The month that the user was born
     * @param birthDay The day that the user was born
     * @param birthYear The year that the user was born
     */
    // Start overloaded constructor US_Citizen()
    public US_Citizen(boolean isUSCitizen,
                      String name, String gender, String address, String eyeColor,
                      double weight, double height,
                      int age, int birthMonth, int birthDay, int birthYear) {
        super(name, gender, address, eyeColor, weight, height, age, birthMonth, birthDay, birthYear);
        this.isUSCitizen = isUSCitizen;
        // Checks if Person is a citizen
        if(isUSCitizen == true)
            SSN = generateSSN();
        else
            SSN = "999 99 9999";
    } // End overloaded constructor US_Citizen()

    /**
     * This method generates a random social security number
     * @return A randomly generated social security number
     */
    // Start method generateSSN()
    public String generateSSN(){
        String SSN = "";
        int counter = 0;
        // Loops through a range to create a random social security number
        for(int i = 0; i < 11; i++) {
            int rand = new Random().nextInt(10);
            if(counter == 3 || counter == 6) { // Creates spaces in specific locations for format
                SSN += " ";
                counter++;
            }
            else {
                SSN += rand;
                counter++;
            }
        }
        return SSN;
    } // End method generateSSN()

    /**
     * This method gets the boolean value checking if the user is a US Citizen
     * @return The boolean value for being a US citizen
     */
    // Start method getIsUSCitizen()
    public boolean getIsUSCitizen() {
        return isUSCitizen;
    } // End method getIsUSCitizen()

    /**
     * This method sets the boolean value if the user is a US Citizen
     * @param isUSCitizen The boolean value for being a US Citizen
     */
    // Start method setCitizen()
    public void setCitizen(boolean isUSCitizen) {
        this.isUSCitizen = isUSCitizen;
    } // End method setCitizen()

    /**
     * This method gets the SSN of the user
     * @return The SSN of the user
     */
    // Start method getSSN()
    public String getSSN() {
        return SSN;
    } // End method getSSN()

    /**
     * This method sets the SSN of the user
     * @param SSN The SSN of the user
     */
    // Start method setSSN()
    public void setSSN(String SSN) {
        this.SSN = SSN;
    } // End method setSSN()

    /**
     * This method gets the information of the attributes of the US_Citizen class
     * @return The information for the attributes of the US_Citizen class
     */
    // Start method toString()
    @Override
    public String toString() {
        return  super.toString() +
                "\nUS_Citizen\n" +
                "\tisUSCitizen = " + getIsUSCitizen() +
                "\n\tSSN = " + getSSN();
    } // End method toString()
} // End class US_Citizen
