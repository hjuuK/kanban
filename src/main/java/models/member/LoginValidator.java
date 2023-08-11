package models.member;

import jakarta.servlet.http.HttpServletRequest;
import org.mindrot.jbcrypt.BCrypt;
import validators.RequiredValidator;
import validators.Validator;

public class LoginValidator implements Validator<HttpServletRequest>, RequiredValidator {
    private UsersDao usersDao;

    public LoginValidator(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public void check(HttpServletRequest request) {
        /**
         *  1. 필수 항목 검증(userId, userPw)
         *  2. userId로 회원이 조회 되는지 체크
         *  3. 비밀번호 검증
         */

        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");

        // 1. 필수 항목 검증(userId, userPw)
        checkRequired(userId, new LoginValidatorException("아이디를 입력하세요."));
        checkRequired(userPw, new LoginValidatorException("비밀번호를 입력하세요."));

        String message = "아이디 또는 비밀번호가 일치하지 않습니다.";

        // 2. userId로 회원이 조회 되는지 체크
        Users users = usersDao.get(userId);
        if (users == null) {
            throw new LoginValidatorException(message);
        }

        // 3. 비밀번호 검증
        boolean match = BCrypt.checkpw(userPw, users.getUserPw());
        checkTrue(match, new LoginValidatorException(message));
    }
}
