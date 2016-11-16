package com.padeoe.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.padeoe.pojo.User;
import com.padeoe.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.padeoe.pojo.User;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    public static final int MAX_USERNAME_LENGTH = 15;
    public static final int MIN_USERNAME_LENGTH = 6;
    public static final int MAX_PASSWORD_LENGTH = 24;
    public static final int MIN_PASSWORD_LENGTH = 6;

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        model.addAttribute("user", user);
        return "showUser";
    }

    @RequestMapping("/login_page")
    public String login_page() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model, HttpSession session) {
/*        User login_user = null;
        String return_value = "login";
        login_user = userService.getUserByName(request.getParameter("username"));
        if (login_user != null) {
            if (login_user.getPassword().equals(request.getParameter("password"))) {
                session.setAttribute("Id", login_user.getId());
                return_value = "index";
            } else {
                model.addAttribute("error", "密码输入错误");
            }
        } else {
            model.addAttribute("error", "未找到对应用户名");
        }
        return return_value;*/
        return "index";
    }

    @RequestMapping("/register_page")
    public String register_page() {
        return "register";
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request, Model model) {
        String name = request.getParameter("username");
        if (name == null) {
            model.addAttribute("error", "用户名名称不符合规范");
            return "register";
        } else {
            if (name.length() < MIN_USERNAME_LENGTH) {
                model.addAttribute("error", "用户名太短，至少" + MIN_USERNAME_LENGTH + "个字符");
                return "register";
            }
            if (name.length() > MAX_USERNAME_LENGTH) {
                model.addAttribute("error", "用户名太长，最多" + MAX_USERNAME_LENGTH + "个字符");
                return "register";
            }
            String password = request.getParameter("password");
            if (password == null) {
                model.addAttribute("error", "未输入密码");
                return "register";
            } else {
                if (password.length() < MIN_PASSWORD_LENGTH) {
                    model.addAttribute("error", "密码太短，至少" + MIN_USERNAME_LENGTH + "个字符");
                    return "register";
                }
                if (password.length() > MAX_PASSWORD_LENGTH) {
                    model.addAttribute("error", "密码太长，最多" + MAX_USERNAME_LENGTH + "个字符");
                    return "register";
                }
                String authority = request.getParameter("Authority");
                if (authority == null) {
                    model.addAttribute("error", "未设置权限信息");
                    return "register";
                } else {
                    userService.saveUser(new User(name, password, authority));
                    return "index";
                }
            }
        }


    }


}
