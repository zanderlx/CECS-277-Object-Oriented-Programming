import java.util.Arrays;
import java.util.Scanner;

// Start class Teacher
public class Teacher extends US_Citizen{
    // Private attributes for the Teacher class
    static int teacherID = 100;
    String[] nameOfCourses;
    int numOfCourses;

    /**
     * Default constructor for the Teacher class
     */
    public Teacher() {
        super();
        this.numOfCourses = 1;
        this.nameOfCourses = new String[numOfCourses];
        this.teacherID++;
    }

    /**
     * Overloaded constructor for Teacher class
     * @param isCitizen The boolean value that checks if the user is a US citizen
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
     * @param numOfCourses The number of courses the teacher is teaching
     */
    public Teacher(boolean isCitizen,
                   String name, String gender, String address, String eyeColor,
                   double weight, double height,
                   int age, int birthMonth, int birthDay, int birthYear, int numOfCourses) {
        super(isCitizen, name, gender, address, eyeColor, weight, height, age, birthMonth, birthDay, birthYear);
        this.numOfCourses = numOfCourses;
        this.nameOfCourses = new String[numOfCourses];
        this.setNameOfCourses(nameOfCourses);
        this.teacherID++;
    }

    /**
     * This method gets the teacher ID of the teacher
     * @return The teacher ID of the teacher
     */
    public int getTeacherID() {
        return teacherID;
    }

    /**
     * This method sets the teacher ID of the teacher
     * @param ID The teacher's ID
     */
    public void setTeacherID(int ID) {
        this.teacherID = ID;
    }

    /**
     * This method gets the number of courses that the teacher is teaching
     * @return The number of courses that the teacher is teaching
     */
    public int getNumOfCourses() {
        return numOfCourses;
    }

    /**
     * This method sets the number of courses that the teacher
     * @param numOfCourses The number of courses that a teacher is teaching
     */
    public void setNumOfCourses(int numOfCourses) {
        this.numOfCourses = numOfCourses;
    }

    /**
     * This method gets the name of the courses that the teacher is teaching
     * @return The name of the courses that the teacher is teaching
     */
    public String getNameOfCourses() {
        return nameOfCourses.toString();
    }

    /**
     * This method sets the name of the name of the courses that the teacher is teaching
     * @param nameOfCourses The name of the courses that the teacher is teaching
     */
    public void setNameOfCourses(String[] nameOfCourses) {
        Scanner in = new Scanner(System.in);
        System.out.println("What are the names of the " + getNumOfCourses() + " courses you are teaching?");
        for(int i = 0; i < getNumOfCourses(); i++) {
            System.out.print("Course " + (i+1) + ": ");
            nameOfCourses[i] = in.nextLine();
        }
    }

    /**
     * This method returns the information of the attributes for the Teacher class
     * @return The attributes for the teacher class
     */
    @Override
    public String toString(){
        return  "Teacher #" + getTeacherID() + " \n" +
                super.toString() +
                "\nTeacher" +
                "\n\tteacherID = " + getTeacherID() +
                "\n\tnumOfCourses = " + getNumOfCourses() +
                "\n\tcourseNames = " + Arrays.toString(nameOfCourses);
    }
}