package controllers.member;

import commons.ViewUtils;
import controllers.Controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.member.LoginService;
import models.member.MemberServiceManager;

import static commons.ScriptUtils.alertError;
import static commons.ScriptUtils.go;

public class LoginController implements Controller {
    public void get(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("addCss", new String[] {"member/login"});
        ViewUtils.load(req, resp, "member", "login");
    }

    public void post(HttpServletRequest req, HttpServletResponse resp) {
        try {
            LoginService loginService = MemberServiceManager.getInstance().loginService();
            loginService.login(req);

            // 로그인 성공 -> 작업 목록 이동
            go(resp, req.getContextPath() + "/works", "parent");
            
        } catch (Exception e) {
            alertError(resp, e);
        }
    }
}
