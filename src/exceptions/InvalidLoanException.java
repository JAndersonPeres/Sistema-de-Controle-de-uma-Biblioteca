package exceptions;

public class InvalidLoanException extends LibraryException {
    public InvalidLoanException(String message) {
        super(message);
    }
}
