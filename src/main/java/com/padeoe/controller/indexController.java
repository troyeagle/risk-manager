package com.padeoe.controller;

import com.padeoe.pojo.User;
import com.padeoe.service.impl.NotificationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by zafara on 2016/11/14.
 */
@Controller
public class indexController {
    @RequestMapping("/")
    public String homepage(HttpServletRequest request, Model model) {
        return "login";
    }

    @RequestMapping("/index_page")
    public String index_page(HttpServletRequest request, Model model, HttpSession session) {

       String username =  ((User)session.getAttribute("user")).getUsername().toString();
        NotificationServiceImpl ins = new NotificationServiceImpl();
        model.addAttribute("notify",ins.listNotification(username));
        return "index";
    }


    @RequestMapping("/addrisk_op_page")
    public String addrisk_op(HttpServletRequest request, Model model) {
        return "addrisk_op";
    }

    @RequestMapping("/addrisk_op_advantage_page")
    public String addrisk_op_advantage(HttpServletRequest request, Model model) {
        return "addrisk_op_advantage";
    }

/*    @RequestMapping("/project_page")
    public String project(HttpServletRequest request, Model model) {
        return "project";
    }*/

    @RequestMapping("/piecharttest_page")
    public String piecharttest_page(HttpServletRequest request, Model model) {
        return "piecharttest";
    }

    @RequestMapping("/piechart_page")
    public String piechart_page(HttpServletRequest request, Model model) {
        return "piechart";
    }
}
