package com.padeoe.controller;

import com.padeoe.pojo.User;
import com.padeoe.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 管理用户登录，用户注册
 */
@Controller
public class UserController {
    @Resource
    private IUserService userService;

    public static final int MAX_USERNAME_LENGTH = 15;
    public static final int MIN_USERNAME_LENGTH = 6;
    public static final int MAX_PASSWORD_LENGTH = 24;
    public static final int MIN_PASSWORD_LENGTH = 6;

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model) {
        String username = request.getParameter("username");
        User user = this.userService.getUserByName(username);
        model.addAttribute("user", user);
        return "showUser";
    }

    @RequestMapping("/login_page")
    public String login_page() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model, HttpSession session) {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        if(username==null||password==null){
            model.addAttribute("error", "用户名或密码未填写");
            return "login";
        }
        else{
            User user=new User();
            user.setUsername(username);
            user.setPassword(password);
            List<User> users=userService.getUserByCondition(user);
            if(users!=null&&users.size()==1){
                user=users.get(0);
                session.setAttribute("user",user);
                return "index";
            }
            else{
                model.addAttribute("error", "用户名密码错误");
                return "login";
            }
        }
    }

    @RequestMapping("/register_page")
    public String register_page() {
        return "register";
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request, Model model, HttpSession session) {
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
                    User u = new User();
                    u.setUsername(name);
                    u.setPassword(password);
                    if(authority.equals("管理员"))
                        u.setAuthority(0);
                    else if(authority.equals("用户"))
                        u.setAuthority(1);
                    userService.saveUser(u);
                    session.setAttribute("user",u);
                    return "index";
                }
            }
        }


    }


}
