package exceptions;

public class MaxLoanReachedException extends LibraryException {
    public MaxLoanReachedException(String message) {
        super(message);
    }
}
