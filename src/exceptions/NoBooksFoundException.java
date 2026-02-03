package exceptions;

public class NoBooksFoundException extends LibraryException {
    public NoBooksFoundException(String message) {
        super(message);
    }
}
