package models.member;

import controllers.member.UserForm;
import jakarta.servlet.http.HttpServletRequest;

public class JoinService {
    private UsersDao usersDao;
    private JoinValidator validator;

    public JoinService(UsersDao usersDao, JoinValidator validator) {
        this.usersDao = usersDao;
        this.validator = validator;
    }

    public void join(UserForm userForm) {
        // 유효성 검사
        validator.check(userForm);

        // 유효성 검사 성공시 DB 처리
        if (!usersDao.register(userForm)) {
            throw new JoinValidationException("회원가입 실패하였습니다.");
        }
    }

    public void join(HttpServletRequest req) {
        UserForm userForm = UserForm.builder()
                .userId(req.getParameter("userId"))
                .userPw(req.getParameter("userPw"))
                .userPwRe(req.getParameter("userPwRe"))
                .userNm(req.getParameter("userNm"))
                .email(req.getParameter("email"))
                .mobile(req.getParameter("mobile"))
                .agree(req.getParameter("agree") == null ? false : true)
                .build();

        join(userForm);
    }
}
