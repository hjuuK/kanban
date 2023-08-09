package models.works;

public class WorkNotFoundException extends RuntimeException {
    public WorkNotFoundException() {
        super("등록된 작업이 아닙니다.");
    }
}
