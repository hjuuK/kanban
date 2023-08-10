package controllers.member;

import commons.ViewUtils;
import controllers.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.member.JoinService;
import models.member.MemberServiceManager;

import static commons.ScriptUtils.alertError;
import static commons.ScriptUtils.go;

public class JoinController implements Controller {
    public void get(HttpServletRequest req, HttpServletResponse resp) {
        ViewUtils.load(req, resp, "member", "join");
    }

    public void post(HttpServletRequest req, HttpServletResponse resp) {
        JoinService joinService = MemberServiceManager.getInstance().joinService();

        try {
            joinService.join(req);

            // 회원가입 성공시 로그인 페이지로 이동
            go(resp, req.getContextPath() + "/", "parent");

        } catch (Exception e) {
            alertError(resp, e);
        }
    }
}
