package commons;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewUtils {
    public static void load(HttpServletRequest req, HttpServletResponse resp, String dir, String fileName) {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/" + dir + "/" + fileName + ".jsp");
        try {
            rd.forward(req, resp);  // 기존거를 취소하고 교체
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
