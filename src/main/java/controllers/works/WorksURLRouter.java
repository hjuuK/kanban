package controllers.works;

import controllers.URLRouter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//- 작업목록 - /works
//- 작업등록 - /works/add
//- 작업조회 - /works/작업번호
//- 작업수정 - /works/edit/등록번호
//- 작업삭제 - /works/delete/등록번호
public class WorksURLRouter implements URLRouter {
    @Override
    public void route(HttpServletRequest req, HttpServletResponse resp, String location) {

    }
}
