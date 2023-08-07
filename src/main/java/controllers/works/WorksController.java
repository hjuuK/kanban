package controllers.works;

import controllers.URLRouter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//- 작업목록 - /works
//- 작업등록 - /works/add
//- 작업수정 - /works/등록번호
//- 작업삭제 - /works/delete/등록번호
@WebServlet("/works/*")
public class WorksController extends HttpServlet {
    private URLRouter router;

    @Override
    public void init() throws ServletException {
        router = new WorksURLRouter();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        router.route(req, resp, "works");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        router.route(req, resp, "works");
    }
}
