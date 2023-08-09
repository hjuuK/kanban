package controllers.member;

import commons.ViewUtils;
import controllers.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FindIdController implements Controller {
    @Override
    public void get(HttpServletRequest req, HttpServletResponse resp) {
        ViewUtils.load(req, resp, "member", "find_id");
    }

    @Override
    public void post(HttpServletRequest req, HttpServletResponse resp) {

    }
}
