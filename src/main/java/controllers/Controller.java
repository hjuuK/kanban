package controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
    void get(HttpServletRequest req, HttpServletResponse resp);
    void post(HttpServletRequest req, HttpServletResponse resp);
}
