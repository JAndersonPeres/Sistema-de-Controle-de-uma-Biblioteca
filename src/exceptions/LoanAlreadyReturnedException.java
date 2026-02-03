package exceptions;

public class LoanAlreadyReturnedException extends LibraryException {
    public LoanAlreadyReturnedException(String message) {
        super(message);
    }
}
