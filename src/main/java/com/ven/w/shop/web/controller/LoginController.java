package com.ven.w.shop.web.controller;

import com.ven.w.shop.commons.context.SpringContext;
import com.ven.w.shop.commons.utils.CookieUtils;
import com.ven.w.shop.entity.User;
import com.ven.w.shop.service.UserService;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {

    private static final String COOKIE_NAME_USER_INFO = "userInfo";

    private UserService userService =  SpringContext.getBean("userService");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInfo = CookieUtils.getCookieValue(req, COOKIE_NAME_USER_INFO, true);
        if (StringUtils.isNotBlank(userInfo)) {
            String[] userInfoArray = userInfo.split(":");
            String email = userInfoArray[0];
            String password = userInfoArray[1];
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.setAttribute("isRemember", true);
        }
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        boolean isRemember = req.getParameter("isRemember") == null ? false : true;

       User admin = userService.login(email, password);

        if (admin != null) {
            if (isRemember) {
                CookieUtils.setCookie(req, resp, COOKIE_NAME_USER_INFO,
                        String.format("%s:%s", email, password), 7*24*60*60, true);
            } else {
                CookieUtils.deleteCookie(req, resp, COOKIE_NAME_USER_INFO);
            }
            resp.sendRedirect("/main.jsp");
        } else {
            req.setAttribute("message", "用户名或密码错");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
