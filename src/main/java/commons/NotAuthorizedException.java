package commons;

public class NotAuthorizedException extends RuntimeException {
    public NotAuthorizedException() {
        super("접근 권한이 없습니다.");
    }
}
