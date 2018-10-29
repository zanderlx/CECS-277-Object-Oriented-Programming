public class OptionNotAvailable extends Exception{

    public OptionNotAvailable() {
        super("Option not available!");
    }

    public OptionNotAvailable(String message) {
        super(message);
    }
}
