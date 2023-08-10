package controllers.works;

import commons.UrlUtils;
import controllers.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.works.DeleteService;
import models.works.WorkServiceManager;

import static commons.ScriptUtils.alertError;

public class DeleteController implements Controller {
    @Override
    public void get(HttpServletRequest req, HttpServletResponse resp) {
        try {
            DeleteService deleteService = WorkServiceManager.getInstance().deleteService();
            long workNo = UrlUtils.getPatternData(req, "delete/(\\d*)");
            deleteService.delete(workNo);

            // 성공시 -> 목록 이동
            resp.sendRedirect(req.getContextPath() + "/works");
        } catch (Exception e) {
            alertError(resp, e, -1);
        }
    }

    @Override
    public void post(HttpServletRequest req, HttpServletResponse resp) {

    }
}
