package exceptions;

public class ClientAlreadyRegisteredException extends LibraryException {
    public ClientAlreadyRegisteredException(String message) {
        super(message);
    }
}
