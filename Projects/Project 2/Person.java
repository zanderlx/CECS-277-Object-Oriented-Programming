public class Person {
    // Private attributes for the Person class
    private String name, gender, address, eyeColor;
    private double weight, height;
    private int age, birthDay, birthMonth, birthYear;

    /**
     * Default constructor for the Person class
     */
    // Start default constructor Person()
    public Person(){
        this.name = "No Name";
        this.gender = "Male";
        this.address = "No Address";
        this.eyeColor = "No Eye Color";
        this.weight = 0.0d;
        this.height = 0.0d;
        this.age = 0;
        this.birthDay = 1;
        this.birthMonth = 1;
        this.birthYear = 2017;
    } // End default constructor Person()

    /**
     * Overloaded constructor for the Person class
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
    // Start overloaded constructor Person()
    public Person(String name, String gender, String address,
                  String eyeColor, double weight,
                  double height, int age, int birthMonth,
                  int birthDay, int birthYear) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.eyeColor = eyeColor;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
    } // End overloaded constructor Person()

    /**
     * This method gets the name of the person
     * @return The name of the person
     */
    // Start method getName()
    public String getName() {
        return name;
    } // End method getName()

    /**
     * This method sets the name of the person
     * @param name The value that person's name will be set to
     */
    // Start method setName()
    public void setName(String name) {
        this.name = name;
    } // End method setName()

    /**
     * This method gets the gender of the person
     * @return The gender of the person
     */
    // Start method getGender()
    public String getGender() {
        return gender;
    } // End method getGender()

    /**
     * This method sets the gender of the person
     * @param gender The value that the person's gender will be set to
     */
    // Start method setGender()
    public void setGender(String gender) { this.gender = gender; } // End method setGender()

    /**
     * This method gets the address of the person
     * @return The address of the person
     */
    // Start method getAddress()
    public String getAddress() {
        return address;
    } // End method getAddress()

    /**
     * This method sets the address of the person
     * @param address  The address of the person
     */
    // Start method setAddress()
    public void setAddress(String address) {
        this.address = address;
    } // End method setAddress()

    /**
     * This method gets the eye color of the person
     * @return The person's eye color
     */
    // Start method getEyeColor()
    public String getEyeColor() {
        return eyeColor;
    } // End method getEyeColor()

    /**
     * This method sets the eye color of the person
     * @param eyeColor The person's eye color
     */
    // Start method setEyeColor()
    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    } // End method setEyeColor()

    /**
     * This method gets the weight of the person
     * @return The weight of the person
     */
    // Start method getWeight()
    public double getWeight() {
        return weight;
    } // End method getWeight()

    /**
     * This method sets the weight of the person
     * @param weight The weight of the person
     */
    // Start method setWeight()
    public void setWeight(double weight) {
        this.weight = weight;
    } // End method setWeight()

    /**
     * This method gets the height of the person
     * @gender The height of the person
     */
    // Start method getHeight()
    public double getHeight() {
        return height;
    } // End method getHeight()

    /**
     * This method sets the height of the person
     * @param height The height of the person
     */
    // Start method setHeight()
    public void setHeight(double height) {
        this.height = height;
    } // End method setHeight()

    /**
     * This method gets the age of the person
     * @return age The age of the person
     */
    // Start method getAge()
    public int getAge() {
        return age;
    } // End method getAge()

    /**
     * This method sets the age of the person
     * @param age The age of the person
     */
    // Start method setAge()
    public void setAge(int age) {
        this.age = age;
    } // End method setAge()

    /**
     * This method gets the day that the person was born
     * @return birthDay The day that the person was born
     */
    // Start method getBirthDay()
    public int getBirthDay() {
        return birthDay;
    } // End method getBirthDay()

    /**
     * This method sets the day that the person was born
     * @param birthDay Tbe day that the person was born
     */
    // Start method setBirthDay()
    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    } // End method setBirthDay()

    /**
     * This method gets the month that the person was born
     * @return The month that the person was born
     */
    // Start method getBirthMonth()
    public String getBirthMonth() {
        String month = "";
        switch(birthMonth){
            case 1: month = "January"; break;
            case 2: month = "February"; break;
            case 3: month = "March"; break;
            case 4: month = "April"; break;
            case 5: month = "May"; break;
            case 6: month = "June"; break;
            case 7: month = "July"; break;
            case 8: month = "August"; break;
            case 9: month = "September"; break;
            case 10: month = "October"; break;
            case 11: month = "November"; break;
            case 12: month = "December"; break;
        }
        return month;
    } // End method getBirthMonth()

    /**
     * This method sets the month that the person was born
     * @param birthMonth The month that the person was born
     */
    // Start method setBirthMonth()
    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    } // End method setBirthMonth()

    /**
     * This method gets the year that the person was born
     * @return The year that the person was born
     */
    // Start method getBirthYear()
    public int getBirthYear() {
        return birthYear;
    } // End method getBirthYear()

    /**
     * This method sets the year that the person was born
     * @param birthYear The year that the person was born
     */
    // Start method setBirthYear()
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    } // End method setBirthYear()

    /**
     * This method prints out attribute information of the Person class
     * @return Information about the attributes
     */
    // Start method toString()
    @Override
    public String toString() {
        return "Person\n" +
                "\tname = " + getName() +
                "\n\tgender = " + getGender() +
                "\n\taddress = " + getAddress() +
                "\n\teyeColor = " + getEyeColor() +
                "\n\tweight = " + getWeight() + "lbs" +
                "\n\theight = " + getHeight() + "ft" +
                "\n\tbirthday = " + getBirthMonth() + " " + getBirthDay() + ", " + getBirthYear() +
                "\n\tage = " + getAge();
    } // End method toString()
}
