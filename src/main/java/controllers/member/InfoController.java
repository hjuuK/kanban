package controllers.member;

import commons.ViewUtils;
import controllers.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InfoController implements Controller {
    public void get(HttpServletRequest req, HttpServletResponse resp) {
        ViewUtils.load(req, resp, "member", "info");
    }

    public void post(HttpServletRequest req, HttpServletResponse resp) {

    }
}
