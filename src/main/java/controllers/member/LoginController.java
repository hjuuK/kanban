package controllers.member;

import commons.ViewUtils;
import controllers.Controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginController implements Controller {
    public void get(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("addCss", new String[] {"member/login"});
        ViewUtils.load(req, resp, "member", "login");
    }

    public void post(HttpServletRequest req, HttpServletResponse resp) {

    }
}
