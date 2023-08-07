package controllers;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface URLRouter {
    void route(HttpServletRequest req, HttpServletResponse resp, String location);

    default String getMode(String URL, String location) {
        String mode = null;
        String pattern = location + "/([^/]*)";
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(URL);
        if (matcher.find()) {
            mode = matcher.group(1);
        }
        return mode;
    }
}
