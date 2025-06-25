package exception;

public class InvalidCustomerNumber extends RuntimeException {
    public InvalidCustomerNumber(final String message) {
        super(message);
    }
}
