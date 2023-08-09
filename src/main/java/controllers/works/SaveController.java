package controllers.works;

import static commons.ScriptUtils.*;

import commons.ScriptUtils;
import commons.UrlUtils;
import commons.ViewUtils;
import controllers.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.works.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SaveController implements Controller {
    @Override
    public void get(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String URI = req.getRequestURI();
            String mode = URI.indexOf("edit") != -1 ? "edit" : "add";

            Work work = null;
            if (mode.equals("edit")) { //수정
                InfoService infoService = WorkServiceManager.getInstance().infoService();
                long workNo = UrlUtils.getPatternData(req, "edit/(\\d*)");
                work = infoService.get(workNo); // 작업 번호 가져오기
                if (work == null) {
                    throw new WorkNotFoundException();
                }
            } else { // 추가
                work = new Work();
            }

            req.setAttribute("work", work);

            String[] addScript = {"ckeditor/ckeditor", "work/form"}; // .js
            req.setAttribute("addScript", addScript);

            ViewUtils.load(req, resp, "works", mode);
        } catch (Exception e) {
            alertError(resp, e, -1);    // 에러 메세지 alert로 출력, history.go(-1);
        }
    }

    @Override
    public void post(HttpServletRequest req, HttpServletResponse resp) {
        SaveService saveService = WorkServiceManager.getInstance().saveService();
        try {
            saveService.save(req);

            //resp.sendRedirect(req.getContextPath() + "/works"); // Location : /kanban/works`// 현재창( 자기창으로 이동)

            // 추가, 수정 성공시 목록으로 이동
            go(resp, req.getContextPath() + "/works", "parent");
        } catch (Exception e) {
            //ScriptUtils.alertErrors(resp, e);
            alertError(resp, e);       // import static commons.ScriptUtils.*; -> 하므로써 앞에 ScriptUtils 생략 가능
            e.printStackTrace();
        }
    }
}
