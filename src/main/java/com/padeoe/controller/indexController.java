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
    @RequestMapping("/index_page")
    public String index(HttpServletRequest request, Model model) {
        return "index";
    }
}
