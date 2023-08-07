package controllers.member;

import controllers.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InfoController implements Controller {
    public void get(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("정보 수정 - GET");
    }

    public void post(HttpServletRequest req, HttpServletResponse resp) {

    }
}
