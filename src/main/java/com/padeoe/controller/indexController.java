package com.padeoe.controller;

import com.padeoe.pojo.Notification;
import com.padeoe.pojo.RiskSearchResult;
import com.padeoe.pojo.User;
import com.padeoe.service.INotificationService;
import com.padeoe.service.ISearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zafara on 2016/11/14.
 */
@Controller
public class indexController {
    @Resource
    private INotificationService NotificationService;
    private ISearchService iSearchService;

    @RequestMapping("/")
    public String homepage(HttpServletRequest request, Model model) {
        return "login";
    }


    @RequestMapping("/index_page")
    public String index_page(HttpServletRequest request, Model model, HttpSession session) {
        String username = ((User) session.getAttribute("user")).getUsername().toString();
        List<Notification> notifications = NotificationService.listNotification(username);
        if (notifications == null) {
            notifications = new ArrayList<Notification>();
            notifications.add(new Notification());
            model.addAttribute("notify", new ArrayList<Notification>());
        } else {
            model.addAttribute("notify", notifications);
        }
        return "index";
    }

    @RequestMapping("/notify_page")
    public String notify_page(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        int i =Integer.parseInt(id);
        Notification notification = NotificationService.openNotification(i);
        String notify =  notification.getContent();
       model.addAttribute("notify", notify);
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

    @RequestMapping("/piechart_page")
    public String piechart_page(HttpServletRequest request, Model model) {
        model.addAttribute("rsr",new ArrayList<>());
        return "piechart";
    }

    @SuppressWarnings("deprecation")
	@RequestMapping("/piechartsearch")
    public String piechartShow(HttpServletRequest request, Model model) {
        String startDate = request.getParameter("startdate");
        String enddate = request.getParameter("enddate");
        String type = request.getParameter("type");
        if (type == null || startDate == null || enddate == null) {
            model.addAttribute("error", "参数错误");
            return "piechart_page";
        }
        int type_int;
        if (type.equals("shibie")) {
            type_int = 1;
        }
        else
        if (type.equals("wenti")) {
            type_int = 2;
        }
        else{
            model.addAttribute("error", "未知的图表类型");
            return "piechart_page";
        }
        System.out.println(startDate);
        System.out.println(enddate);
        Date start=new Date(Integer.parseInt(startDate.substring(0,4))-1900,Integer.parseInt(startDate.substring(5,7))-1,Integer.parseInt(startDate.substring(8,10)));
        Date end=new Date(Integer.parseInt(enddate.substring(0,4))-1900,Integer.parseInt(enddate.substring(5,7))-1,Integer.parseInt(enddate.substring(8,10)));
         List<RiskSearchResult> results=iSearchService.searchByCondition(type_int,null,start,end);
        model.addAttribute("rsr",results);
        return "piechart";
    }
}
