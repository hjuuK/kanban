package commons;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ScriptUtils {
    public static void alertError(HttpServletResponse resp, Exception e, int goStep) {
        try {
            resp.setContentType("text/html; charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.printf("<script>alert('%s');</script>", e.getMessage());

            if (goStep != 0) {
                out.printf("<script>history.go(%d);</script>", goStep);
            }
        } catch (IOException e2) {}
    }

    public static void alertError(HttpServletResponse resp, Exception e) {
        alertError(resp, e, 0);
    }

    public static void go(HttpServletResponse resp, String url, String target) {    // 페이지가 목록으로 이동
        target = target == null || target.isBlank() ? "self" : target;
        try {
            resp.setContentType("text/html; charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.printf("<script>%s.location.replace('%s');</script>", target, url);
        } catch (IOException e) {}
    }

    public static void go(HttpServletResponse resp, String url) {
        go(resp, url, null);    // self
    }
}
