package controllers.member;

import controllers.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginController implements Controller {
    public void get(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("로그인 - GET");
    }

    public void post(HttpServletRequest req, HttpServletResponse resp) {

    }
}
