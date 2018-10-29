/**
 * This program implements the use of inheritance among the classes.
 * Creates a student and a teacher class that inherits the US citizen class
 * The US citizen then inherits the person class
 * CECS 277 - Project 2
 * @author Lexzander Saplan
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main { // Start class Main
    // Start method main()
    public static void main(String[] args){
        Student defaultStudent = new Student();
        System.out.println(defaultStudent.toString() + "\n");
        US_Citizen defaultUSCitizen = new Teacher();
        System.out.println(defaultUSCitizen.toString() + "\n");
        System.out.println("////////////////////////////////////////////\n");
        Student s1 = createStudent();
        System.out.println(s1.toString());
        System.out.println("////////////////////////////////////////////\n");
        US_Citizen t1 = createTeacher();
        System.out.println(t1.toString());
    } // End method main()

    /**
     * This method is used to get validation from the user to be used in a new Student instance.
     * @return a new student instance with the user's validated input
     */
    // Start method createStudent()
    public static Student createStudent(){
        //All the variables and attributes needed to create a new Student
        String name, gender, address, eyeColor;
        String[] addressArray;
        int age, birthMonth, birthDay, birthYear, numOfCoursesTaken;
        double weight, height;
        boolean isCitizen = false;
        String userInput;

        Scanner in = new Scanner(System.in);

        //To be used for the Person Class
        System.out.println("Welcome new student!");
        System.out.println("What is your name?");
        name = in.nextLine();
        System.out.println("What is your gender? (M / F)");
        gender = validateGender();
        System.out.println("What is your eye color?");
        eyeColor = in.next();
        System.out.println("What is your height? (In feet)");
        height = doubleValidation();
        System.out.println("What is your weight? (In pounds)");
        weight = doubleValidation();
        in.nextLine();
        System.out.println("What is your address?");
        addressArray = in.nextLine().split(" ");
        address = "";
        for(int i = 0; i < addressArray.length; i++){
            address += addressArray[i] + " ";
        }
        System.out.println("What month were you born? (1-12)");
        birthMonth = validateDOB("month");
        System.out.println("What day where you born? (1-31)");
        birthDay = validateDOB("day");
        System.out.println("What year were you born?");
        birthYear = integerValidation();
        System.out.println("Did you already have your birthday this year? (Y / N))");
        userInput = validateUserInput();
        // Determines the age of the user depending on if the user has already celebrated their birthday this year
        if(userInput.equalsIgnoreCase("Yes") || userInput.equalsIgnoreCase("Y"))
            age = 2017 - birthYear;
        else
            age = 2017 - (birthYear+1);

        // To be used for the US Citizen Class
        System.out.println("Are you a US Citizen? (Y / N)");
        userInput = validateUserInput();
        if(userInput.equalsIgnoreCase("Yes") || userInput.equalsIgnoreCase("Y"))
            isCitizen = true;

        // To be used for the Student Class
        System.out.println("As a student, how many courses are you taking?");
        numOfCoursesTaken = integerValidation();

        return new Student(numOfCoursesTaken, isCitizen, name, gender, address, eyeColor, weight, height,
                            age, birthMonth, birthDay, birthYear);
    } // End method createStudent()

    /**
     * This method is used to get validation from the user to be used in a new Teacher instance.
     * @return a new teacher instance with the user's validated input
     */
    // Start method createTeacher
    public static US_Citizen createTeacher() {
        // All the variables and attributes to be used in the new teacher instance
        String name, gender, address, eyeColor;
        String[] addressArray;
        int age, birthMonth, birthDay, birthYear, numOfCourses;
        double weight, height;
        boolean isCitizen = false;
        String userInput;

        Scanner in = new Scanner(System.in);

        //To be used in the Person Class
        System.out.println("Welcome new teacher!");
        System.out.println("What is your name?");
        name = in.nextLine();
        System.out.println("What is your gender? (M / F)");
        gender = in.next();
        System.out.println("What is your eye color?");
        eyeColor = in.next();
        System.out.println("What is your height? (In feet)");
        height = in.nextDouble();
        System.out.println("What is your weight? (In pounds)");
        weight = in.nextDouble();
        in.nextLine();
        System.out.println("What is your address?");
        addressArray = in.nextLine().split(" ");
        address = "";
        for(int i = 0; i < addressArray.length; i++){
            address += addressArray[i] + " ";
        }
        System.out.println("What month were you born? (1-12)");
        birthMonth = validateDOB("month");
        System.out.println("What day were you born? (1-31)");
        birthDay = validateDOB("day");
        System.out.println("What year were you born?");
        birthYear = integerValidation();
        System.out.println("Did you already have your birthday this year? (Y / N))");
        userInput = validateUserInput();
        // Checks the user's age depending on whether the user has already celebrated their birthday this year
        if(userInput.equalsIgnoreCase("Y"))
            age = 2017 - birthYear;
        else
            age = 2017 - (birthYear+1);

        // To be used in the US Citizen Class
        System.out.println("Are you a US Citizen? (Y / N)");
        userInput = validateUserInput();
        if(userInput.equalsIgnoreCase("Y"))
            isCitizen = true;

        // To be used in the Teacher Class
        System.out.println("As a teacher, how many courses do you teach?");
        numOfCourses = integerValidation();

        return new Teacher(isCitizen, name, gender, address, eyeColor, weight, height, age, birthMonth, birthDay, birthYear, numOfCourses);
    } // End method createTeacher()

    /**
     * This method validates the user input whenever the user needs to make a Y or N decision
     * @return The validated user input which can only be a Y or N
     */
    // Start method validateUserInput()
    public static String validateUserInput(){
        Scanner in = new Scanner(System.in);
        boolean valid = false;
        String input = "";
        // Keeps looping until a valid key is entered
        while(!valid){
            try{
                input = in.next();
                // Checks if the user entered a Y or N
                if(!(input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("Yes") ||
                        input.equalsIgnoreCase("N") || input.equalsIgnoreCase("No"))){
                    System.out.println("The key you entered is not valid! Please enter 'Y' or 'N'");
                    valid = false;
                }
                else // If the user entered a Y or N then the input is valid
                    valid = true;
            } catch (InputMismatchException e){
                System.out.println("The key you entered is not valid! Please Try Again!");
                in.nextLine();
            }
        }
        return input;
    } // End method validateUserInput()

    /**
     * This method validates the user's input for the date of birth values. The validation depends on the type of
     * date that the user will enter. i.e., Month or Day
     * @param type The type of date that the user entered that the program will validate
     * @return The validated user input for the specific type of date
     */
    // Start method validateDOB()
    public static int validateDOB(String type){
        int dobValidation = integerValidation();
        if(type.equals("day")){ // Validates for the day which can only be between 1-31
            while(dobValidation < 1 || dobValidation > 31){
                System.out.println("The day must be a value between 1-31! Try Again!");
                dobValidation = integerValidation();
            }
        }
        else if(type.equals("month")){ // Validates for the month which can only be from 1-12
            while(dobValidation < 1 || dobValidation > 12){
                System.out.println("The month must be a value between 1-12! Try Again!");
                dobValidation = integerValidation();
            }
        }
        return dobValidation;
    } // End method validateDOB()

    public static String validateGender(){
        Scanner in = new Scanner(System.in);
        String gender = in.next();
        while(!(gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F"))){
            System.out.println("Please enter M or F! (Male or Female)");
            gender = in.next();
        }
        return gender;
    }

    /**
     * This methods checks the if the value that the user inputs is an integer
     * @return The valid integer value that the user wants to use for the program
     */
    // Start method integerValidation()
    public static int integerValidation(){
        Scanner in = new Scanner(System.in);
        boolean isInteger = false;
        int userInteger = 0;
        // Validates user's input as long as the input is an integer
        while(!isInteger){ //Keep checking until number is an integer even after parsing
            try {
                String input = in.next(); //Inputs a String
                userInteger = Integer.parseInt(input); // Parses string into an integer
                if(userInteger > -1) // Checks for negative input
                    isInteger = true;
                else
                    System.out.println("Input is negative! Try again!");
            }catch(NumberFormatException e){
                System.out.println("The value must be an integer! Try again!");
            }
        }
        return userInteger;
    } // End method integerValidation()

    /**
     * This method validates user input for doubles
     * @return The validated double that the user wants to use
     */
    // Start method doubleValidation()
    public static double doubleValidation(){
        Scanner in = new Scanner(System.in);
        double userDouble = 0.0d;
        boolean isInteger = false;
        while(!isInteger){ //Keep checking until number is an double even after parsing
            try {
                String input = in.next(); //Inputs a String
                userDouble = Double.parseDouble(input); // Parses string into an double
                if(userDouble > -1.0) // Checks for negative input
                    isInteger = true;
                else
                    System.out.println("Input is negative! Try again!");
            }catch(NumberFormatException e){
                System.out.println("The value must be a double! Try again!");
            }
        }
        return userDouble;
    } // End method doubleValidation()
} // End class Main
