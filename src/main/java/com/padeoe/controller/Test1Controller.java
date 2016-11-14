package com.padeoe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zafara on 2016/11/14.
 */
@Controller
public class Test1Controller {
    @RequestMapping("/test1")
    public String addRisk(HttpServletRequest request, Model model){
        String returnvalue = request.getParameter("username");
        System.out.println(returnvalue);
        return returnvalue;
    }

}
