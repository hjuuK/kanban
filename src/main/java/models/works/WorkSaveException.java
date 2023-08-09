package models.works;

public class WorkSaveException extends RuntimeException {
    public WorkSaveException() {
        super("작업 저장에 실패하였습니다");
    }
}
