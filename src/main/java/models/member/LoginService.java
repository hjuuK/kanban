package models.member;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginService {
    private LoginValidator validator;
    private UsersDao usersDao;

    public LoginService(LoginValidator validator, UsersDao usersDao) {
        this.validator = validator;
        this.usersDao = usersDao;
    }

    public void login(HttpServletRequest request, HttpServletResponse response) {
        validator.check(request);

        // 검증 성공 -> 로그인 처리
        HttpSession session = request.getSession();
        String userId = request.getParameter("userId");
        Users users = usersDao.get(userId);
        session.setAttribute("users", users);

        // 아이디 저장 처리
        Cookie cookie = new Cookie("saveId", userId);
        cookie.setHttpOnly(true); // 스크립트에서 조회 X, 보안 O
        if (request.getParameter("saveId") == null) { // 아이디 저장 미체크
            // 기존 저장 쿠키 삭제
            cookie.setMaxAge(0);
        } else { // 아이디 저장 체크 상태
            // 쿠키 저장
            cookie.setMaxAge(60 * 60 * 24 * 365);   // 60초 60분 24시간 365일
        }
        response.addCookie(cookie);
    }
}
