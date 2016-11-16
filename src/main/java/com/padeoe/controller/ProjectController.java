package com.padeoe.controller;

import com.padeoe.pojo.Risk;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zafara on 2016/11/14.
 */
@Controller
    @RequestMapping("/project")
public class ProjectController {
    private static String name = "";
    private static String descriptoin = "";
    private static List<Risk> risklists;

    /**
     * 新增项目的页面 对应于 “addProject.jsp”
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/addProject_page")
    public String addRiskBL_page(HttpServletRequest request, Model model) {
        return "addProject";
    }

    /**
     * 新增项目的后台提交处理
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/addProject")
    public String addRiskBL(HttpServletRequest request, Model model) {
        String returnvalue = "addrisk test";
        name = request.getParameter("id");

        return returnvalue;
    }
}
