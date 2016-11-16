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

    @RequestMapping("/riskmanage_page")
    public String riskmanage_page(HttpServletRequest request, Model model) {
        return "riskmanage";
    }

    @RequestMapping("/addrisk_page")
    public String addrisk_page(HttpServletRequest request, Model model) {
        return "addrisk";
    }

    @RequestMapping("/addrisk_op_page")
    public String addrisk_op(HttpServletRequest request, Model model) {
        return "addrisk_op";
    }
}
