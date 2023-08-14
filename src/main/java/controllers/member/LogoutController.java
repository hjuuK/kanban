package controllers.member;

import controllers.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LogoutController implements Controller {

    @Override
    public void get(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        session.invalidate(); // 세션 비우기

        try {
            resp.sendRedirect(req.getContextPath() + "/member/login");
        } catch (IOException e) {}
    }

    @Override
    public void post(HttpServletRequest req, HttpServletResponse resp) {
        get(req, resp);
    }
}
