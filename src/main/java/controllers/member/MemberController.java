package controllers.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//- 회원가입 - /member/join
//- 로그인 - /member/login
//- 정보수정 - /member/info
@WebServlet("/member/*")
public class MemberController extends HttpServlet {
    private MemberURLRouter router;

    @Override
    public void init() throws ServletException {
        router = new MemberURLRouter();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        router.route(req, resp, "member");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
