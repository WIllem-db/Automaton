package exceptions;

public class NoElementsFoundInDatabase extends RuntimeException {
    public NoElementsFoundInDatabase(String message) {
        super(message);
    }
}
