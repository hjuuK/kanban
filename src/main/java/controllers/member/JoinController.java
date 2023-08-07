package controllers.member;

import controllers.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JoinController implements Controller {
    public void get(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("회원 가입 - GET");
    }

    public void post(HttpServletRequest req, HttpServletResponse resp) {

    }
}
