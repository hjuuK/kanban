package models.member;

import controllers.member.UserForm;
import validators.RequiredValidator;
import validators.Validator;

public class JoinValidator implements Validator<UserForm>, RequiredValidator {
    private UsersDao usersDao;

    public JoinValidator(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public void check(UserForm userForm) {
        /*
            1. 필수 항목 검증(userId, userPw, userPwRe, userNm, email, 약관동의)
            2. 아이디 자리수는 6자리 이상, 비밀번호는 8자리 이상
            3. 아이디 중복 여부
            4. userPw(비밀번호), userPwRe(비밀번호 확인) 일치
         */

        String userId = userForm.getUserId();
        String userPw = userForm.getUserPw();
        String userPwRe = userForm.getUserPwRe();
        String userNm = userForm.getUserNm();
        String email = userForm.getEmail();

        // 1. 필수 항목 검증
        checkRequired(userId, new JoinValidationException("아이디를 입력하세요."));
        checkRequired(userPw, new JoinValidationException("비밀번호를 입력하세요."));
        checkRequired(userPwRe, new JoinValidationException("비밀번호를 확인하세요."));
        checkRequired(userNm, new JoinValidationException("회원명을 입력하세요."));
        checkRequired(email, new JoinValidationException("이메일을 입력하세요."));


        // 2. 아이디 자리수는 6자리 이상, 비밀번호는 8자리 이상
        if (userId.length() < 6) {
            throw new JoinValidationException("아이디는 6자리 이상 입력하세요.");
        }

        if (userPw.length() < 8) {
            throw new JoinValidationException("비밀번호는 8자리 이상 입력하세요.");
        }

        // 3. 아이디 중복 여부
        if (usersDao.exists(userId)) {
            throw new JoinValidationException("이미 가입된 회원 아이디 입니다.");
        }

        // 4. userPw(비밀번호), userPwRe(비밀번호 확인) 일치
        if (!userPw.equals(userPwRe)) {
            throw new JoinValidationException("비밀번호가 일치하지 않습니다.");
        }
    }
}
