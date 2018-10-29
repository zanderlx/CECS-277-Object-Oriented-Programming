/**
 * Project 4 - Bank Account
 * Dr. Susan Nachawatti
 * @author Lexzander Saplan
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws OverdraftReached{ // Start method main
        // Method that runs the program
        runProgram();
    } // End method main

    /**
     * This method runs the program from the main
     */
    public static void runProgram() throws OverdraftReached{ // start method runProgram
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome! \nWhat is your name?");
        String name = in.next();

        System.out.println("Are you a Student or an Instructor?");
        System.out.println("1) Student \n2) Instructor");
        int userChoice = 0;
        while(userChoice < 1 || userChoice > 2) {
            if(userChoice == 0)
                userChoice = validateInteger();
            else {
                System.out.println("Option not available! Try Again!");
                userChoice = validateInteger();
            }
        }

        // Assigns a person as a student or an instructor
        Person person;
        String title;
        if(userChoice == 1) {
            person = new Person(name);
            title = "Student ";
        }
        else {
            person = new Person(name);
            title = "Instructor ";
        }


        // counter for the months
        int i = 0;
        // Array of months
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        // boolean to check if the user wants to run program again
        boolean runAgain = true;

        //Introductions to the program
        System.out.println("\nDoing transactions for the month of " + months[i]);
        System.out.println("Hello " + title + person.getName() + "! What would you like to do?");
        menu(); // Displays menu

        // Main loop that runs the program and does interactions with the user
        while (runAgain) {
            // Returns the boolean value of the user's choice to restarting the program
            runAgain = transactions(person);
            // If the program is run again display the menu again
            if (runAgain){
                System.out.println("\n\nReturned back to the main menu...");
                menu();
            }
            // if the user exited the menu do a list of additional functionality
            if(!runAgain) {
                int input;
                // Asks user if it is the end of month to do end of month functions
                System.out.println("Is it the end of the month?");
                System.out.println("1) Yes  2) No");
                boolean endOfMonth = true;
                while(endOfMonth){
                    input = validateInteger();
                    switch(input) {
                        case 1: // Does case 1 if it is the end of the month
                            // Display the balance before and after end of the month fees
                            System.out.println("Balance before end of the month fees:");
                            // First checks if there are any active accounts for checking or savings
                            if (person.getChecking().isActive()) {
                                if (person.getChecking().getBalance() < 0)
                                    System.out.printf("\tChecking: -$%,.2f\n", Math.abs(person.getChecking().getBalance()));
                                else
                                    System.out.printf("\tChecking: $%,.2f\n", person.getChecking().getBalance());
                            } else
                                System.out.println("\tChecking: NOT ACTIVATED!");

                            // Checks if a savings account is active
                            if (person.getSavings().isActive()) {
                                System.out.printf("\tSavings: $%,.2f", person.getSavings().getBalance());
                            } else
                                System.out.println("\tSavings: NOT ACTIVATED!");

                            // Displays the balance at the end of the month including the fees
                            System.out.println("\nBalance including end of the month fees:");
                            // Checks if a checking account is active
                            if (person.getChecking().isActive()) {
                                person.getChecking().endOfMonth();
                                if (person.getChecking().getBalance() < 0)
                                    System.out.printf("\tChecking: -$%,.2f\n", Math.abs(person.getChecking().getBalance()));
                                else
                                    System.out.printf("\tChecking: $%,.2f\n", person.getChecking().getBalance());
                            } else
                                System.out.println("\tChecking: NOT ACTIVATED!");

                            // Checks if a savings account is active
                            if (person.getSavings().isActive()) {
                                person.getSavings().endOfMonth();
                                System.out.printf("\tSavings: $%,.2f", person.getSavings().getBalance());
                            } else
                                System.out.println("\tSavings: NOT ACTIVATED!");
                            i++; // Increment to the next month
                            endOfMonth = false;

                            // Go to the next month to do transactions
                            System.out.println("\n\nDo you want to continue transactions to next month?");
                            System.out.println("1) Yes  2) No");
                            input = validateInteger();
                            switch(input){
                                case 1: // Case 1 does transactions for the next month
                                    System.out.println("Doing transactions for the month of " + months[i]);
                                    System.out.println("\n\nWelcome back!");
                                    menu();
                                    person.getChecking().setNumOfTransactions(0);
                                    runAgain = true;
                                    break;
                                case 2: // Ends the program
                                    endOfMonth = false;
                                    runAgain = false;
                                    System.out.println("Goodbye... Program ended");
                                    break;
                            }
                            break;
                        case 2: // Case 2 asks user if they want to make another transaction in the same month
                            System.out.println("Do you want to make another transaction for the month of " + months[i]);
                            System.out.println("1) Yes  2) No");
                            input = validateInteger();
                            switch (input) {
                                case 1: // Restarts the program if the user wants to make another transaction
                                    System.out.println("\n\nWelcome back!");
                                    menu();
                                    endOfMonth = false;
                                    runAgain = true;
                                    break;
                                case 2: // Ends the program
                                    System.out.println("\nGoodbye... Program ended");
                                    endOfMonth = false;
                                    runAgain = false;
                            }
                            break;
                        case 3: // No option available
                            System.out.println("Option not available");
                    } // Ends large switch statement for monthly functionality
                } // Ends end of month loop
            }// Ends end transaction loop
        } // Ends run again loop
    } // Ends method runProgram

    /** Method to display interactive menu */
    public static void menu(){ // Start method menu
        System.out.println("1) Activate an account");
        System.out.println("2) Deposit");
        System.out.println("3) Withdraw");
        System.out.println("4) Show Balance");
        System.out.println("5) Exit");
    } // End method menu

    /**
     * Method that runs the transactions of the user such as activating an account,
     * depositing, withdrawing, and viewing the balance
     * @param person The person using the transaction machine
     * @return The boolean value if the user wants to restart transactions
     */
    public static boolean transactions(Person person) throws OverdraftReached{ // Start method transactions
        Scanner in = new Scanner(System.in);
        boolean runAgain = true;
        int choice;
        double amount;

        // Gets user input based on the interactive menu and continues the program
        choice = validateInteger();
        try {
            BankAccount account;
            switch (choice) {
                case 1: // Activates an account for the user
                    activateAccount(person);
                    break;
                case 2: // Allows user to deposit into their account
                    account = getAccount("deposit", person);
                    System.out.print("How much do you want to deposit? $");
                    amount = in.nextDouble();
                    account.deposit(amount);
                    break;
                case 3: // Allows user to withdraw from their account
                    account = getAccount("withdraw", person);
                    System.out.print("How much do you want to withdraw? $");
                    amount = in.nextDouble();
                    account.withdraw(amount);
                    break;
                case 4: // Gets the balance of the user's account
                    System.out.println("Your balance for your accounts:");
                    // First checks if there are activated accounts on the account
                    if (person.getChecking().isActive()) {
                        account = person.getChecking();
                        if (account.getBalance() < 0)
                            System.out.printf("\tChecking: -$%,.2f\n", Math.abs(account.getBalance()));
                        else
                            System.out.printf("\tChecking: $%,.2f\n", account.getBalance());
                    }
                    else {
                        System.out.println("\tChecking: NOT ACTIVATED!");
                    }

                    // Checks if a savings account is activated
                    if (person.getSavings().isActive()) {
                        account = person.getSavings();
                        System.out.printf("\tSavings: $%,.2f", account.getBalance());
                    }
                    else
                        System.out.println("\tSavings: NOT ACTIVATED!");
                    break;
                case 5: // End the transactions
                    runAgain = false;
                    break;
                default: // No available option from the menu
                    throw new OptionNotAvailable("Option not available!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Try Again!");
            in.nextLine();
        } catch (OptionNotAvailable e) {
            System.out.println(e.getMessage());
        }

        return runAgain; // The option if the transaction method runs again
    } // End method transactions

    /**
     * This method activates accounts that the user might want to activate
     * @param person The person who the account belongs to
     */
    public static void activateAccount(Person person){ // Start method activateAccounts
        int choice;
        // Asks which account to activate
        System.out.println("Which account do you want to activate?");
        System.out.println("1) Checking");
        System.out.println("2) Savings");
        choice = validateInteger();
        switch(choice){
            case 1: // Performs functionality to activate checking account
                if (person.getChecking().isActive()){ // Checks if a checking account is already activated
                    System.out.println("Checking account already activated!");
                }
                else { // Activates a checking account
                    person.getChecking().setActive(true);
                    System.out.println("Checking account is now activated!");
                }
                break;
            case 2: // Performs functionality to activate savings account
                if (person.getSavings().isActive()){ // Checks if a savings account is already activated
                    System.out.println("Savings account already activated!");
                }
                else { // Activates a savings account
                    person.getSavings().setActive(true);
                    System.out.println("Savings account is now activated!");
                }
                break;
        } // End switch statement that activates accounts
    } // End method activateAccounts

    /**
     * This method gets the account depending on the functionality of their choices.
     * It corresponds to what the user wants to do with their account
     * @param transaction The type of transaction they want to do
     * @param person The owner of the account
     * @return The account that the user wants to do a transaction on
     */
    public static BankAccount getAccount(String transaction, Person person) { // Start method getAccount
        Scanner in = new Scanner(System.in);
        subMenu(transaction);
        BankAccount type = new BankAccount();

        // Loops through the program to get the account of the user
        while (true) {
            int account;
            try {
                account = in.nextInt();
                switch(account) {
                    case 1: // Gets the user's checking account
                        if (person.getChecking().isActive())
                            type = person.getChecking();
                        else { // Checks if a checking account is active
                            System.out.println("Checking account is not active!");
                            System.out.println("Please activate before making any transactions...\n");
                            activateAccount(person);
                            type = person.getChecking();
                        }
                        break;
                    case 2: // Gets the user's savings account
                        if (person.getSavings().isActive())
                            type = person.getSavings();
                        else { // Checks if a savings account is active
                            System.out.println("Savings account is not active!");
                            System.out.println("Please activate before making any transactions...\n");
                            activateAccount(person);
                            type = person.getSavings();
                        }
                        break;
                    default: // No option for the menu
                        System.out.println("Option not available... Try Again!");
                        break;
                }
                // Breaks the loop if option 1 or 2 was chosen
                if (account == 1 || account == 2)
                    break;
                // Catches exceptions for the try-catch statement
            } catch (InputMismatchException e) {
                in.nextLine();
                System.out.println("\nInvalid Input!");
                subMenu(transaction);
            }
        }
        return type; // Returns the type of account that the user wants to do transactions on
    } // End method getAccount

    /**
     * This method shows the submenu for the main menu that the user will be interacting with
     * @param transaction he type of transaction the user wants to perform
     */
    public static void subMenu(String transaction){ // Start method subMenu
        if (transaction.equalsIgnoreCase("deposit"))
            System.out.println("Which account do you want to " + transaction + " to?");
        else if (transaction.equalsIgnoreCase("withdraw"))
            System.out.println("Which account do you want to " + transaction + " from?");
        else
            System.out.println("Which account do you want to activate?");
        System.out.println("1) Checking");
        System.out.println("2) Savings");
    } // End method subMenu

    /**
     * This method validates the user's entry for integers
     * @return The validated input that the user entered
     */
    public static int validateInteger() { // Start method integer
        Scanner in = new Scanner(System.in);
        int input;
        while (true) {
            try {
                // Tries to get an integer from the user
                input = in.nextInt();
                break;
            } catch (InputMismatchException e) { // Catches exception when input is not an integer
                System.out.println("Invalid Input! Try Again!");
                in.nextLine();
            }
        }
        return input; // Returns the validated integer
    } // End method validateInteger
}
