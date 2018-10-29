/**
 * Student: Lexzander Saplan - 014177252
 * Class: CECS 277
 * Professor: Dr. Susan Nachawati
 * Assignment: InfixToPostfix Converter
 */
import java.util.Scanner;

// Start class Main
public class Main
{
    // Start method main
    public static void main(String[] args)
    {
        // Data members to start the program
        boolean restartProgram = true;
        StringBuffer infix;
        StringBuffer postfix = new StringBuffer();
        PostfixEvaluator postfixEvaluator;
        Scanner in = new Scanner(System.in);

        // Checks if program should be restarted
        while (restartProgram) {
            // Variable checking if a valid expression was entered
            boolean validExpression = false;
            try {
                // Menu for the user
                System.out.println("\nWelcome to the Expression Calculator!");
                System.out.println("What would you like to do?");
                System.out.println("1) Convert an infix expression to a postfix expression");
                System.out.println("2) Evaluate a postfix expression");

                // Selection 1 converts infix to postfix
                if (getMenuSelection() == 1)
                {
                    // Creates an object that is used to convert infix to postfix
                    InfixToPostfixConverter infixToPostfixConverter = new InfixToPostfixConverter();
                    // Keeps repeating until valid expression is entered
                    while (!validExpression)
                    {
                        infix = new StringBuffer(); // Creates new StringBuffer for infix
                        System.out.println("Enter a valid infix arithmetic expression: ");
                        infix.append(in.nextLine()); // Stores an infix string

                        // Prints out the infix that the user entered
                        System.out.println("Infix Expression: " + infix.toString());
                        // Converts infix to postfix
                        postfix = infixToPostfixConverter.convertToPostfix(infix);

                        // This checks to see if the expression was correct
                        postfixEvaluator = new PostfixEvaluator();
                        postfixEvaluator.evaluatePostfix(postfix);
                        validExpression = true;
                    }
                    // If the expression was true, this prints out the postfix
                    System.out.println("Converted from Infix to Postfix: " + postfix.toString());
                }
                else // Selection 2 is for evaluating a postfix expression
                    {
                    postfix = new StringBuffer(); // Creates new StringBuffer for the postfix
                    System.out.println("Please enter a valid postfix expression: ");
                    postfix.append(in.nextLine()); // Stores a postfix string

                    // Creates a new object for evaluating the postfix string
                    postfixEvaluator = new PostfixEvaluator();
                    System.out.println("Evaluated Postfix Expression: " + postfixEvaluator.evaluatePostfix(postfix));
                }

                // Asks and validates if user wants to restart the program
                System.out.println("\nDo you want to run the program again?");
                System.out.println("1) Yes \n2) No");

                // Restarts the program based on the selection
                restartProgram = (getMenuSelection() == 1);
            } catch (Exception e) {
                // Catches if an expression has an error
                System.out.println("Expression is not valid! Try Again...\n");
            }
        }
    } // End method main()

    /**
     * This method validates on the choices of the menu shown
     * @return 1 or 2 depending on what the user wants to do
     */
    public static int getMenuSelection()
    {
        Scanner in = new Scanner(System.in);
        int choice = 0;
        boolean isInteger = false;
        // Keeps checking until a valid integer is found
        while (!isInteger)
        {
            // Gets a string and if it can be parsed into an integer is is valid
            try {
                String num = in.next();
                // If the parse fails then it is not an integer
                choice = Integer.parseInt(num);
                // Integer must be 1 or 2
                if (choice < 1 || choice > 2)
                {
                    System.out.println("Please enter a 1 or a 2");
                    isInteger = false;
                }
                // If a valid integer is found, stops looping
                else
                    isInteger = true;
            } catch (Exception e) {
                // Catches error if the input is not an integer
                System.out.println("Please enter an integer!");
                isInteger = false;
            }
        }
        // Return validated integer
        return choice;
    } // End method getMenuSelection()
} // End class Main

// ((15 / (7 - (1 + 1))) * 3) - (2 + (1 + 1))