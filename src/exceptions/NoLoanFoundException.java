package exceptions;

public class NoLoanFoundException extends LibraryException {
    public NoLoanFoundException(String message) {
        super(message);
    }
}
