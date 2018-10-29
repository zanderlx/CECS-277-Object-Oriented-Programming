import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This program makes a combination lock. The user of the program
 * has to open the lock (if they know the combination) or try to guess
 * the combination by the number of ticks the user wants to move to.
 * @author Lexzander Saplan - 014177252
 */
public class LabLock {
    public static void main(String[] args){
        // Creates a new lock with a set combination
        ComboLock myCombo = new ComboLock(6,17,13);
        int[] comboGuess = new int[3]; // An array to hold the values of the user's entry
        boolean opened = false; // Value to check if the lock was opened
        int guess1, guess2, guess3;

        System.out.println("Welcome!");
        lockedText();
        System.out.println("Combination is made up of 3 numbers... " +
                "Please enter the correct combination to open the lock...\n" +
                "When turning, you need to pass 0 only once to get to your next number...");
        // Moves the current number depending on how far the user wants to turn to
        while(!opened) {
            System.out.println("\nThe lock's pointer is at 0");
            // Turns right by a user's number of ticks to the first number
            System.out.print("Turn RIGHT to the first number by how many ticks? ");
            comboGuess[0] = integerValidation();
            myCombo.turnRight(comboGuess[0]);
            guess1 = (myCombo.getCurrent() % myCombo.getMAX_LOCK_TICKS());

            // Turns left by a user's number of ticks to the first number
            System.out.print("\nTurn LEFT to the second number by how many ticks? ");
            comboGuess[1] = integerValidation();
            myCombo.turnLeft(comboGuess[1]);
            guess2 = (myCombo.getCurrent() % myCombo.getMAX_LOCK_TICKS());

            // Turns right by a user's number of ticks to the first number
            System.out.print("\nTurn RIGHT to the last number by how many ticks? ");
            comboGuess[2] = integerValidation();
            myCombo.turnRight(comboGuess[2]);
            guess3 = (myCombo.getCurrent() % myCombo.getMAX_LOCK_TICKS());

            // Tells the user what the combination they entered was
            System.out.println("\nYou guessed the combination to be: " +
                    "(" + guess1 + ", " + guess2 + ", " + guess3 + ")");

            // Checks if all the combination guesses were correct
            if (myCombo.open()) {
                opened = true;
                System.out.println("That was the correct combination!" +
                        "\nYou opened the lock!");
                unlockedText();
            }
            else {
                lockedText();
                System.out.println("That is not the correct combination..." +
                        "Do you want to try again? (Y / N)");
                String tryAgain = validateUserInput();
                if(tryAgain.equalsIgnoreCase("N"))
                    opened = true;
                else
                    comboGuess = new int[3]; // Deletes the original array to enter the user's new guesses
                myCombo.setCurrent(0); // Resets the current location of the lock to 0
            }
        }
    }

    /**
     * This methods checks the if the value that the user enters is an integer
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
                if(userInteger > -1 && userInteger < 41) // Checks for negative input and range
                    isInteger = true;
                else
                    System.out.println("The value must be positive and less than or equal to 40! Try again!");
            }catch(NumberFormatException e){
                System.out.println("The value must be an integer! Try again!");
            }
        }
        return userInteger;
    } // End method integerValidation()

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
                    System.out.println("The key you entered is not valid! Please enter 'Y' or 'N...'");
                    valid = false;
                }
                else // If the user entered a Y or N then the input is valid
                    valid = true;
            } catch (InputMismatchException e){
                System.out.println("The key you entered is not valid! Please enter 'Y' or 'N'...");
                in.nextLine();
            }
        }
        return input;
    } // End method validateUserInput()

    /**
     * Shows text art for a LOCKED icon
     */
    public static void lockedText(){
        System.out.println("            .-\"\"-.\n" +
                "           / .--. \\\n" +
                "          / /    \\ \\\n" +
                "          | |    | |\n" +
                "          | |.-\"\"-.|         LOCKED!\n" +
                "         ///`.::::.`\\\n" +
                "        ||| ::/  \\:: ;\n" +
                "        ||; ::\\__/:: ;\n" +
                "         \\\\\\ '::::' /\n" +
                "          `=':-..-'`");
    }

    /**
     * Shows text art for a UNLOCKED icon
     */
    public static void unlockedText(){
        System.out.println("            .-\"\"-.\n" +
                "           / .--. \\\n" +
                "          / /    \\ \\\n" +
                "          | |    |_|\n" +
                "          | |       \n" +
                "          | |.-\"\"-.          UNLOCKED!\n" +
                "         ///`.::::.`\\\n" +
                "        ||| ::/  \\:: ;\n" +
                "        ||; ::\\__/:: ;\n" +
                "         \\\\\\ '::::' /\n" +
                "          `=':-..-'`");
    }
}
