/**
 * This class is used to evaluate a postfix expression
 */
import java.util.Stack;

// Start class PostfixEvaluator
public class PostfixEvaluator
{
    // Private Data values
    private Stack<String> evalStack;
    private double operand1, operand2;

    /**
     * The Default constructor for the PostfixEvaluator class
     */
    public PostfixEvaluator()
    {
        this.operand1 = 0.0;
        this.operand2 = 0.0;
        this.evalStack = new Stack<>();
    }

    /**
     * This method evaluates a postfix expression to get a solution
     * @param postfix The postfix expression to be evaluated
     * @return The evaluated solution from the postfix expression
     */
    public double evaluatePostfix(StringBuffer postfix)
    {
        // Converts and splits the postfix expression for better manipulation
        String expression = postfix.toString();
        String[] expSplit = expression.split(" ");

        // For each value in the postfix expression...evaluate
        for (String value : expSplit)
        {
            // If the value is a number then push it into the stack
            if (isNumeric(value))
                evalStack.push(value);
            // If the value is not a number (an operator) then evaluate the stack
            // and push it back in
            else
            {
                operand2 = Double.parseDouble(evalStack.pop());
                operand1 = Double.parseDouble(evalStack.pop());
                evalStack.push(evaluateOperator(operand1, operand2, value) + "");
            }
        }
        // Returns the evaluated expression
        return Double.parseDouble(evalStack.pop());
    } // End method evaluatePostfix()

    /**
     * This method evaluates the values in a stack of a postfix expression
     * @param operand1 The first operand to use for evaluation
     * @param operand2 The second operand to use for evaluation
     * @param operator The operation that the evaluated expression will do
     * @return The evaluated value from two operands and a specific expression
     */
    public static double evaluateOperator(double operand1, double operand2, String operator)
    {
        // Checks which operator to use for evaluation
        switch (operator)
        {
            case "+": // Adds the two operands
                return operand1 + operand2;
            case "-": // Subtracts the two operands
                return operand1 - operand2;
            case "*": // Multiply the operands
                return operand1 * operand2;
            case "/": // Divide the operands
                return (double)operand1 / (double)operand2;
            case "%": // Modulo the operands
                return operand1 % operand2;
            case "^": // Exponentiate the operands
                return (int)Math.pow(operand1, operand2);
            default: // Else return -1
                return -1;
        } // End switch statement
    } // End method evaluateOperator()

    /**
     * This methods checks if a certain value is a number
     * @param value The value to be checked as a number
     * @return True if the value is a number, else it is false
     */
    public static boolean isNumeric(String value)
    {
        // If the String can be parsed into a double then
        // it is a number
        try {
            Double.parseDouble(value);
            return true;
        }
        // Catches an exception if the value is not a number
        catch (Exception e) {
            return false;
        }
    } // End method isNumeric()
} // End class PostfixEvaluator()
