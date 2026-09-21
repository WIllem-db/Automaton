package exceptions;

public class WorkoutAlreadyExists extends RuntimeException {
    public WorkoutAlreadyExists(String message) {
        super(message);
    }
}
