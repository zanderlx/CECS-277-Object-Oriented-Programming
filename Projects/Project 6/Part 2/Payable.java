public interface Payable {
    /**
     * This method gets the amount that must be paid for any
     * object that implements this interface
     * @return The amount that must be paid
     */
    double getPaymentAmount();
}
