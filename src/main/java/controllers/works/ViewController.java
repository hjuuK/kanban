package controllers.works;

import commons.ViewUtils;
import controllers.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewController implements Controller {
    @Override
    public void get(HttpServletRequest req, HttpServletResponse resp) {
        ViewUtils.load(req, resp, "works", "view");
    }

    @Override
    public void post(HttpServletRequest req, HttpServletResponse resp) {

    }
}
