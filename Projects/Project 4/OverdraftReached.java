public class OverdraftReached extends Exception{

    public OverdraftReached() {
        super("Overdraft Limit Reached!");
    }

    public OverdraftReached(String message) {
        super(message);
    }
}
