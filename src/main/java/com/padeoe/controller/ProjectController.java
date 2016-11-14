package com.padeoe.controller;

import com.padeoe.pojo.Risk;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zafara on 2016/11/14.
 */
@Controller
    @RequestMapping("/project")
public class ProjectController {
    private static String name = "";
    private static String descriptoin = "";
    private static Risk[] risklists;

    @RequestMapping("/addProjectBL")
    public String addRiskBL(HttpServletRequest request, Model model) {
        String returnvalue = "addrisk test";
        name = request.getParameter("id");

        return returnvalue;
    }
}
