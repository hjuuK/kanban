package validators;

// 필수 항목 검증
public interface RequiredValidator {
    // 문자열 필수 체크
    default void checkRequired(String value, RuntimeException e) {
        if (value == null || value.isBlank()) {
            throw e;
        }
    }

    // Enum 상수의 필수 체크
    default void checkRequired(Enum value, RuntimeException e) {
        if (value == null) {
            throw e;
        }
    }
}
