package models.works;

public class WorkValidationException extends RuntimeException {
    public WorkValidationException(String message) {
        super(message);
    }
}
