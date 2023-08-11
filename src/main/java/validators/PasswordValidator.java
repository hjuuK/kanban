package validators;

public interface PasswordValidator {
    default boolean passwordCheck(String pass, int level) {
        // level1 - 알파벳 소문자 1개 이상, 대문자 1개 이상
        if (level <= 1) {
            if (!pass.matches("[a-z]+") || !pass.matches("[A-Z]+")) {
                return false;
            }
        }

        // level2 - 숫자가 1개 이상 포함
        if (level <= 2 && !pass.matches("\\d+")) {
                return false;
        }

        // level3 - 특수문자가 1개 이상
        if (level > 2 && !pass.matches("[`~!@#\\^%&\\*()\\-_=\\+]+")) {
            return false;
        }

        return true;
    }
}
