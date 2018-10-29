import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *  Postal Bar Code Program - Project 1
 *  This program converts bar code into a ZIP code or a ZIP code into a bar code.
 *  User input is required to do the conversions or user can decide to convert a
 *  random bar code into its ZIP code or a random ZIP code into its bar code.
 *  @ author Lexzander Saplan - 014177252
 */
public class PostalBarCode { // Start class PostalBarCode
    // Scanner is declared globally to be used in multiple methods
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) { // Start method main()
                // Checks the value of restart to see if program is restarted
                boolean restart = false;
                while(!restart){
                    startProgram(); // Calls the method to restart the program
                    restart = restartProgram(); // Checks boolean value in order to decide if program is restarted
                }
                in.close(); // Closes the scanner
        } // End method main()

    /**
     * This methods starts the program and opens a menu that the user can interact
     * with. Other methods are called to provide interaction and to run the program.
     * The user can choose which path to take depending on what they want to use the
     * program for.
     */
    public static void startProgram() { // Start method startProgram()
        System.out.println("Welcome to the Postal Bar Code Converter Program!");
        System.out.println("What would you like to convert? \n(1) Bar Code -> ZIP Code \n(2) ZIP Code -> Bar Code");

        int input; // This variable is used to store the user's decisions. It can dynamically change...
        input = validateUserInput();
        if(input == 1){ // User chose to convert a bar code into a ZIP code
            System.out.println("Do you want to enter your own bar code or use a randomized one?");
            System.out.println("(1) Enter my own bar code \n(2) Generate a random bar code");
            input = validateUserInput();
            if(input == 1){ // User chose to enter their own bar code
                System.out.println("Do you want to include the FRAME BARS and CORRECTION DIGIT with your bar code?");
                System.out.println("(1) Yes, I want to include the FRAME BARS and CORRECTION DIGIT in my input");
                System.out.println("(2) No, I DO NOT want to include the FRAME BARS and CORRECTION DIGIT in my input");
                input = validateUserInput();
                if(input == 1){ // User wanted to include the FRAME BARS and CORRECTION DIGIT
                    System.out.print("Enter your bar code now (Please include the FRAME BARS and CORRECTION DIGIT): ");
                    String barCode = inputBarCode(32); // Length is 32 with FRAME BARS and CORRECTION DIGIT
                    printZipCode(barCode);
                }
                else{ // User DID NOT want to include the FRAME BARS and CORRECTION DIGIT
                    System.out.print("Enter your bar code now (Please DO NOT include the FRAME BARS and CORRECTION DIGIT): ");
                    String barCode = inputBarCode(25); // Length is 25 when FRAME BARS and CORRECTION DIGIT is not included
                    printZipCode(barCode);
                }
            }
            else{ // User wanted to generate a random bar code to be converted into a ZIP code
                randomBarCode(); // DISCLAIMER: This does not get the correct CORRECTION DIGIT unfortunately...
            }
        }
        else{ // User wanted to convert a ZIP code into its bar code
            System.out.println("Do you want to enter your own ZIP code or use a randomized one?");
            System.out.println("(1) Enter my own ZIP code \n(2) Generate a random ZIP code");
            input = validateUserInput();
            if(input == 1){ // User wanted to enter their own ZIP code
                System.out.print("Enter your ZIP code now: ");
                int zipCode = inputZipCode();
                printBarCode(zipCode);
            }
            else{ // User wanted to convert a random ZIP code into its bar code
                int randZip = randomZipCode();
                System.out.print("The randomly generated ZIP code is: " + randZip);
                printBarCode(randZip);
            }
        }
    } // End method startProgram()

    /**
     * This method is used to determine if the user wants to run the program again
     * @return The boolean value (True or False) that the program checks to restart
     */
    public static boolean restartProgram(){ // Start method restartProgram()
        boolean restart = false;

        while(!restart) {
            System.out.println("\n\nDo you want to run the program again? (y / n)");
            String runAgain = in.next();
            while (runAgain.equalsIgnoreCase("y") || runAgain.equalsIgnoreCase("n")) {
                if (runAgain.equalsIgnoreCase("y")) { // User wanted to use the program again
                    restart = false;
                    break;
                }
                else { // User wanted to stop using the program
                    System.out.println("We hope to see you again! Goodbye...");
                    restart = true;
                    break;
                }
            }
            if(restart == false) // User would like to restart
                break;
        }
        System.out.println("\n");

        return restart;

    } // End method restartProgram()

    /**
     * This method validates the user's input in their decision to choose a path
     * depending on what they want to do in the program.
     * @return The value (1 or 2) that the program uses for the user's decisions
     */
    public static int validateUserInput(){ // Start method validateUserInput()
        boolean valid = false;
        int input = 0;
        // The user's input is first a String and is then parsed into an integer to
        // check for non-digits and then checks between an integer range
        while(!valid){
            try{
                input = in.nextInt();
                if(input < 0 || input > 2){
                    System.out.println("The key you entered is not valid! Please Try Again!");
                    valid = false;
                }
                else
                    valid = true;
            } catch (InputMismatchException e){
                System.out.println("The key you entered is not valid! Please Try Again!");
                in.nextLine();
            }
        }
        return input;
    } // End method validateUserInput()

    /**
     * Converts the integer parameter into the appropriate bar code pattern.
     * Does not return a value but simply prints out the bar code of the integer
     * @param digit The integer to be converted into a bar code
     */
    public static void printDigit(int digit){ // Start method printDigit()
        // Explicit representation of the bar code using the corresponding digit
        switch(digit){
            case 0:
                System.out.print("||:::");
                break;
            case 1:
                System.out.print(":::||");
                break;
            case 2:
                System.out.print("::|:|");
                break;
            case 3:
                System.out.print("::||:");
                break;
            case 4:
                System.out.print(":|::|");
                break;
            case 5:
                System.out.print(":|:|:");
                break;
            case 6:
                System.out.print(":||::");
                break;
            case 7:
                System.out.print("|:::|");
                break;
            case 8:
                System.out.print("|::|:");
                break;
            case 9:
                System.out.print("|:|::");
                break;
        }
    } // End method printDigit()

    /**
     * This is the method that converts the user's ZIP code input
     * and prints out the entire barcode. The check digit is also included
     * with the printed bar code
     * @param zipCode The integer that the user input's for the ZIP code
     */
    public static void printBarCode(int zipCode){ // Start method printBarCode()
        System.out.println("\nConverting the ZIP Code into its Bar Code...");
        System.out.println("Input: " + zipCode);
        ArrayList<Integer> myZip = new ArrayList<>();

        // Loops through zipCode and places each digit in a separate index
        // in the myZip array list
        while(zipCode > 0){
            myZip.add(zipCode % 10);
            zipCode /= 10;
        }

        // Gets the valid correction digit from getCheckDigit() method
        int checkDigit = getCheckDigit(myZip);

        // Individually checks the digits of the ZIP code and prints out
        // the bar code representation of that digit
        int counter = 0;
        System.out.print("Output: |");

        // The digits are stored backwards in the array list so I need to check the
        // array list backwards to print correctly
        while (counter > -1 && counter < myZip.size()){
            counter++;
            printDigit(myZip.get(myZip.size() - counter));
        }
        printDigit(checkDigit); // Separate print digit for the check digit which is done last
        System.out.print("|    (FRAME BARS and CORRECTION DIGIT included)");
    } // End method printBarCode()

    /**
     * Separate method to get the correction digit of the ZIP code
     * @param myZip The ZIP code that is used to get the correction digit
     * @return The correction digit obtained from the ZIP code
     */
    public static int getCheckDigit(ArrayList<Integer> myZip){ // Start method getCheckDigit()
        // Adds all the values in zip code
        int sum = 0;
        for(int index = 0; index < myZip.size(); index++)
            sum += myZip.get(index);

        // Formula to get the check digit via POSTNET wiki
        int remainder = sum % 10;
        int checkDigit = 10 - remainder;

        return checkDigit;
    } // End method getCheckDigit()

    /**
     * Prints the ZIP code when given a bar code
     * @param barCode The bar code that the user input's for the program
     */
    public static void printZipCode(String barCode){ // Start method printZipCode()
        System.out.println("\nConverting your Bar Code into its ZIP Code...");
        System.out.println("Input: " + barCode);
        System.out.print("Output: ");
        String[] barCodeSplit = barCode.split("");

        // Corresponding to the chart given on the prompt, this calculates the appropriate
        // value that corresponds to the bar code pattern
        int index = 0, counter = 0, total = 0;
        while (index < barCodeSplit.length){
            // Uses a counter variable to count 5 digits because that is how much digits a
            // bar code uses to get a value. Checks only for straight vertical lines
            if (barCodeSplit[index].equals("|") && counter < 5){
                switch (counter){
                    case 0:
                        total += 7;
                        break;
                    case 1:
                        total += 4;
                        break;
                    case 2:
                        total += 2;
                        break;
                    case 3:
                        total += 1;
                        break;
                }
            }
            counter++;
            index++;
            // When counter hits 5 then that means a bar code was converted into a digit
            // so we need to reset the counter to convert the next bar code pattern
            if(counter == 5){
                counter = 0;
                // If the total is 0 the bar code is represented as a 0
                if (total == 11)
                    total = 0;
                System.out.print(total);
                total = 0; // Resets total so the next bar code pattern can be stored in it
            }
        }
        // Print statement mentioning the appearance of a correction digit, if necessary
        System.out.print("  (If there are 6 digits, the LAST DIGIT is the CORRECTION DIGIT)");
    } // End method printZipCode()

    /**
     * This method gets the bar code that the user wants to enter and validates
     * for errors. Bar code length depends on user's choice to include the
     * FRAME BARS and CORRECTION DIGIT or not
     * @param barCodeLength Value that depends on if the FRAME BARS and CORRECTION DIGIT is included or not
     * @return The validated bar code that the user wants to use for the program
     */
    public static String inputBarCode(int barCodeLength){ // Start method inputBarCode()
        String barCodeInput = in.next();

        // Length needs to be regulated because it might include the FRAME BARS and CORRECTION DIGIT
        while(barCodeInput.length() != barCodeLength) {
            if(barCodeLength == 32)
                System.out.print("Bar code length needs to be "+ barCodeLength + " digits! (FRAME BARS and CORRECTION DIGIT included)");
            else
                System.out.println("Bar code length needs to be "+ barCodeLength + " digits! (FRAME BARS and CORRECTION DIGIT not included)");
            System.out.print("\nTry Again : ");
            barCodeInput = in.next();
        }
        // Validates the bar code patterns for errors
        String[] barCodeSplit = barCodeInput.split("");
        int counter = 0, index = 0;
        String patternCheck = "", pattern = "";
        boolean keepChecking;
        int barCodeSplitLength = 0;

        if(barCodeLength == 32){
            index = 1;
            barCodeSplitLength = barCodeSplit.length - 1;
        }
        else if(barCodeLength == 25){
            index = 0;
            barCodeSplitLength = barCodeSplit.length;
        }

        while(index < barCodeSplitLength){
            keepChecking = false;
            if ((barCodeSplit[index].equals("|") || barCodeSplit[index].equals(":")) && counter < 5){
                patternCheck += barCodeSplit[index];
            }
            else{
                System.out.println("The barcode has an error! Unknown bar code symbol: " + barCodeSplit[index]);
                keepChecking = true;
            }
            counter++;
            index++;
            // Stops looping through the patterns once an error is found and sets
            // the output to a single zero
            if(keepChecking == true) {
                System.out.println("Barcode had an error! Please run the program again...");
                pattern = "ERROR!! OUTPUT WILL BE A SINGLE ZERO...";
                break;
            }
            // The pattern has passed the validation process and is ready to be added to
            // the completed pattern that the program will use
            if(counter == 5){
                counter = 0;
                String[] barCodeData = barCodeDataBase();
                for(int i = 0; i < barCodeData.length; i++) {
                    if (patternCheck.equals(barCodeData[i])) { // Pattern is found
                        pattern += patternCheck;
                        break;
                    }
                }
                patternCheck = ""; // Resets the pattern checking process
            }
        }
        return pattern;
    } // End method inputBarCode()

    /**
     * This methods is used to get the ZIP code from the user. Validation included
     * @return The validated ZIP code that the program will use
     */
    public static int inputZipCode(){ // Start method inputZIPCode()
        int zipCode;
        zipCode = integerValidation();
        // Validates the number of digits the user inputs because a ZIP code can
        // only have 5 digits
        /* https://stackoverflow.com/questions/1306727/way-to-get-number-of-digits-in-an-int */
        int nDigits = (int)Math.floor(Math.log10(Math.abs(zipCode))) + 1;
        while(nDigits != 5){
            System.out.println("The ZIP code has to be 5 digits and cannot start with 0. Please try again!");
            zipCode = integerValidation();
            nDigits = (int)Math.floor(Math.log10(Math.abs(zipCode))) + 1;
        }
        return zipCode;
    } // End method inputZIPCode()

    /**
     * This methods checks the if the value that the user inputs is an integer
     * @return The valid integer value that the user wants to use for the program
     */
    public static int integerValidation(){ // Start method integerValidation()
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
                System.out.println("The ZIP has to be a 5 digit number. Please try again!");
            }
        }
        return userInteger;
    } // End method integerValidation()

    /**
     * This method generates a random bar code by first generating a random ZIP code.
     * The random ZIP code is then converted into the appropriate bar code.
     */
    public static void randomBarCode(){ // Start method randomBarCode()
        int zipCode = randomZipCode(); // Makes a bar code from a random ZIP code
        int zipCodeTemp = zipCode; // Temp variable to be printed at the end of method
        ArrayList<Integer> myZip = new ArrayList<>();
        // Loops through zipCode and places each digit in a separate index
        // in the myZip array list
        while(zipCode > 0){
            myZip.add(zipCode % 10);
            zipCode /= 10;
        } // In the end of the loop, zipCode = 0

        // Gets the valid correction digit from getCheckDigit() method
        int checkDigit = getCheckDigit(myZip);

        // This is the process of using the random ZIP code to print its corresponding pattern
        System.out.println("\nConverting a Random Bar Code into its ZIP Code...");
        System.out.print("Input: |");
        int counter = 0;
        while (counter > -1 && counter < myZip.size()){
            counter++;
            printDigit(myZip.get(myZip.size() - counter));
            System.out.print("");
        }
        printDigit(checkDigit);
        System.out.print("| (FRAME BARS and CORRECTION DIGIT included)");
        System.out.println("\nOutput: " + zipCodeTemp + checkDigit + " (Last digit is the CORRECTION DIGIT)");
    } // End method randomBarCode()

    /**
     * Generates a random ZIP code using numbers between 0 - 9
     * @return A randomly generated ZIP code
     */
    public static int randomZipCode(){ // Start method randomZIPCode()
        int counter = 0;
        String num = "";
        while(counter < 5){
            int rand = new Random().nextInt(10);
            // While the first index of the string num/zip is 0 then generate a new random
            // number because the first number in a ZIP code cannot be 0
             while (counter == 0 && rand == 0)
                rand = new Random().nextInt(10);
            num += rand; // Keep adding random numbers for the random ZIP code
            counter++;
        }
        // Parses the string representation of the ZIP code into an integer
        int randomZip = Integer.parseInt(num);

        return randomZip;
    } // End method randomZIPCode()

    /**
     * A "database" of explicitly determined values that represent a barcode pattern.
     * The bar code pattern is in relation of the current index it is located at.
     * The bar code pattern was created with the actual pattern used in POSTNET
     * @return An array containing all the possible bar code patterns for a ZIP code
     */
    public static String[] barCodeDataBase(){ // Start method barCodeDataBase()
        String[] barCode = new String[10];
        barCode[0] = "||:::";
        barCode[1] = ":::||";
        barCode[2] = "::|:|";
        barCode[3] = "::||:";
        barCode[4] = ":|::|";
        barCode[5] = ":|:|:";
        barCode[6] = ":||::";
        barCode[7] = "|:::|";
        barCode[8] = "|::|:";
        barCode[9] = "|:|::";
        return barCode;
    } // End method barCodeDataBase()
} // End class PostalBarCode