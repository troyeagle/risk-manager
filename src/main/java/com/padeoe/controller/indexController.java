package com.padeoe.controller;

import com.padeoe.pojo.Notification;
import com.padeoe.pojo.User;
import com.padeoe.service.INotificationService;
import com.padeoe.service.IUserService;
import com.padeoe.service.impl.NotificationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zafara on 2016/11/14.
 */
@Controller
public class indexController {
    @Resource
    private INotificationService NotificationService;

    @RequestMapping("/")
    public String homepage(HttpServletRequest request, Model model) {
        return "login";
    }


    @RequestMapping("/index_page")
    public String index_page(HttpServletRequest request, Model model, HttpSession session) {
        String username =  ((User)session.getAttribute("user")).getUsername().toString();
        List<Notification> notifications=NotificationService.listNotification(username);
        if(notifications==null){
            notifications= new ArrayList<Notification>();
            notifications.add(new Notification());
            model.addAttribute("notify",new ArrayList<Notification>());
        }
        else{
            model.addAttribute("notify",notifications);
        }
        return "index";
    }

    @RequestMapping("/notify_page")
    public String notify_page(HttpServletRequest request, Model model) {
        String id =  request.getParameter("id");
        model.addAttribute("notify",NotificationService.openNotification(Integer.getInteger(id)));
        return "notify";
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
