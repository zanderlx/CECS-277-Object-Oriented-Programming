/**
 * This class converts an infix expression into postfix
 */
import java.util.Stack;

// Start class InfixToPostfixConverter
public class InfixToPostfixConverter
{
    // Private Data Members
    private StringBuffer postfix;
    private Stack<Character> expStack;

    /**
     * Default Constructor for class InfixToPostfixConverter
     */
    public InfixToPostfixConverter()
    {
        this.postfix = new StringBuffer();
        this.expStack = new Stack<>();
    }

    /**
     * This method converts an infix expression into
     * a postfix expression
     * @param infix The infix expression to be converted
     * @return The converted infix expression (postfix notation)
     */
    public StringBuffer convertToPostfix(StringBuffer infix)
    {
        // Loops through entire infix expression and does a process
        for (int i = 0; i < infix.length(); i++)
        {
            // Checks if the character at an index is a digit (a number)
            if (Character.isDigit(infix.charAt(i)))
            {
                // Checks if the next character in the infix expression is a space
                if (i < infix.length() - 1 && (isOperator(infix.charAt(i + 1)) || infix.charAt(i + 1) == ' '))
                {
                    // If there is a space next, append a space to the postfix expression
                    postfix.append(infix.charAt(i));
                    postfix.append(' ');
                }
                else // Just append the character to the postfix expression
                    postfix.append(infix.charAt(i));
            }
            // If the current character is a '(' then push it into the expression stack
            else if (infix.charAt(i) == '(')
                expStack.push(infix.charAt(i));
            // Checks if the current character is an operator
            else if (isOperator(infix.charAt(i)))
            {
                // While the stack is not empty and the top of stack is not a '('
                while (!expStack.isEmpty() && expStack.peek() != '(')
                {
                    // Checks the precedence of the operators in the stack
                    if (precedence(expStack.peek()) >= precedence(infix.charAt(i)))
                        postfix.append(expStack.pop());
                    else
                        break;
                }
                // After all the appends have finished, push the current character into the stack
                expStack.push(infix.charAt(i));
            }
            // Checks if the current character is a ')'
            else if (infix.charAt(i) == ')')
            {
                // While the stack is not empty and the top of the stack is not a '('
                while (!expStack.isEmpty() && expStack.peek() != '(')
                {
                    // If the previous char in the postfix is not a space, put a space
                    if (postfix.charAt(postfix.length() - 1) != ' ')
                        postfix.append(' ');
                    // Pop the stack and append into the postfix expression
                    postfix.append(expStack.pop());
                    // Append a space into the postfix expression
                    postfix.append(' ');
                }
                // If the stack is not empty, pop the stack
                if (!expStack.isEmpty())
                    expStack.pop();
            }
        }
        // While the stack is not empty - ')' is found - pop the stack
        while (!expStack.isEmpty())
        {
            postfix.append(' '); // Append a space to the postfix expression
            postfix.append(expStack.pop());
        }

        // For each character in the postfix, fix the organization
        for (int j = 0; j < postfix.length() - 2; j++)
        {
            // Both if statements delete the spaces in the postfix expression
            if (postfix.charAt(j) == ' ' && !Character.isDigit(postfix.charAt(j + 1)))
                postfix.deleteCharAt(j);
            if (isOperator(postfix.charAt(j)) && postfix.charAt(j + 1) == ' ')
                postfix.deleteCharAt(j + 1);
        }

        // If the second to last character is a space, delete that space
        if (postfix.charAt(postfix.length() - 2) == ' ')
            postfix.deleteCharAt(postfix.length() - 2);

        // Adds spaces for better organization of the postfix expression
        String postfixBefore = "";
        for (int i = 0; i < postfix.length() - 1; i++)
        {
            // If the current char and next char is operator, put a space before the current char
            if (isOperator(postfix.charAt(i)) && isOperator(postfix.charAt(i + 1)))
                postfixBefore += " " + postfix.charAt(i);
            // If the current is just a operator, add a space before and after the current char
            else if (isOperator(postfix.charAt(i)))
                postfixBefore += " " + postfix.charAt(i) + " ";
            // Just add the current char to the postfix
            else
                postfixBefore += postfix.charAt(i);
            // Add a space to the second to the last index in the postfix expression
            if (i == postfix.length() - 2)
                postfixBefore += " " + postfix.charAt(postfix.length() - 1);
        }

        // Converts the correct String postfix into a StringBuffer postfix
        StringBuffer postfixAfter = new StringBuffer();
        for (int k = 0; k < postfixBefore.length(); k++)
            postfixAfter.append(postfixBefore.charAt(k));

        // Return the StringBuffer postfix
        return postfixAfter;
    } // End method convertToPostfix()

    /**
     * This methods checks if a certain character is an operator
     * @param c The character to be checked for as an operator
     * @return True if the char is an operator, else false
     */
    public static boolean isOperator(char c)
    {
        switch(c)
        { // If a character is an operator, return true
            case '^':
            case '*':
            case '/':
            case '%':
            case '+':
            case '-':
                return true;
            default: // Else return false
                return false;
        } // End switch statement
    } // End method isOperator()

    /**
     * This method checks the precedence of the operators
     * based on the greater number
     * @param operator An operator to be used to get its precedence
     * @return The operator's precedence
     */
    public static int precedence(char operator)
    {
        switch(operator)
        {
            case '^': // Exponentiation has the greatest precedence
                return 2;
            case '*': // Multiplication, Division, and Modulo have second precedence
            case '/':
            case '%':
                return 1;
            case '+': // Addition and Subtraction have lowest precedence
            case '-':
                return 0;
            default: // Defaults to -1 if operator is not found
                return -1;
        } // End switch statement
    } // End method precedence()
} // End class InfixToPostfixConverter()
