package com.ven.w.shop.web.controller;

import com.ven.w.shop.commons.context.SpringContext;
import com.ven.w.shop.entity.User;
import com.ven.w.shop.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {

    private UserService userService =  SpringContext.getBean("userService");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

       User admin = userService.login(email, password);
       //User admin = null;

        if (admin != null) {
            resp.sendRedirect("/main.jsp");
        } else {
            req.setAttribute("message", "用户名或密码错");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
