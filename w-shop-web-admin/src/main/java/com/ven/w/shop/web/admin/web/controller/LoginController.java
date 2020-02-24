package com.ven.w.shop.web.admin.web.controller;


import com.ven.w.shop.commons.constant.ConstantUtils;
import com.ven.w.shop.commons.utils.CookieUtils;
import com.ven.w.shop.domain.User;
import com.ven.w.shop.web.admin.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {


    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 跳转带登录页
     * @return
     */
    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login(HttpServletRequest request) {
        String userInfo = CookieUtils.getCookieValue(request, "userInfo");
        if (StringUtils.isNotBlank(userInfo)) {
            String[] values = userInfo.split(":");
            request.setAttribute("email", values[0]);
            request.setAttribute("password", values[1]);
            request.setAttribute("isRemember", true);
        }
        return "login";
    }

    /**
     * 登陆验证
     * @param email
     * @param password
     * @param request
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam String email, @RequestParam String password,
                        @RequestParam(required = false) String isRemember, HttpServletRequest request, HttpServletResponse response) {
        User user = userService.login(email, password);

        //登录失败
        if (user == null) {
            request.setAttribute("message", "账号或密码错");
            return "login";
        }
        //登录成功
        else {
            request.getSession().setAttribute(ConstantUtils.SESSION_USER, user);
            if (isRemember != null) {
                CookieUtils.setCookie(request, response, "userInfo",
                        String.format("%s:%s", email, password), 60 * 60 * 24 * 7);
            } else {
                CookieUtils.deleteCookie(request, response, "userInfo");
            }
            return "redirect:/main";
        }
    }

    /**
     * 登出
     * @return
     */
    @RequestMapping( value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().invalidate();
        return "login";
    }


}
