package com.padeoe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
    public String index_page(HttpServletRequest request, Model model) {
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
