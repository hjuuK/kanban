package models.works;

public class WorkDeleteException extends RuntimeException {
    public WorkDeleteException() {
        super("작업 삭제 실패하였습니다.");
    }
}
