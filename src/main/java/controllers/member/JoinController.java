package controllers.member;

import commons.ViewUtils;
import controllers.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JoinController implements Controller {
    public void get(HttpServletRequest req, HttpServletResponse resp) {
        ViewUtils.load(req, resp, "member", "join");
    }

    public void post(HttpServletRequest req, HttpServletResponse resp) {

    }
}
