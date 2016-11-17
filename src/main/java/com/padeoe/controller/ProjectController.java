package com.padeoe.controller;

import com.padeoe.pojo.Project;
import com.padeoe.pojo.Risk;
import com.padeoe.service.IProjectService;
import com.padeoe.service.IRiskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zafara on 2016/11/14.
 */
@Controller
public class ProjectController {
    @Resource
    private IProjectService iProjectService;

    /**
     * 新增项目的页面 对应于 “addProject.jsp”
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/addproject_page")
    public String addRiskBL_page(HttpServletRequest request, Model model) {
        return "addproject";
    }

    /**
     * 新增项目的后台提交处理
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/addProjectBL")
    public String addRiskBL(HttpServletRequest request, Model model) {
        String name=request.getParameter("name");
        String description=request.getParameter("description");
        if(name!=null&&description!=null&&name.length()>0&&description.length()>0){
            Project project=new Project();
            project.setName(name);
            project.setDescription(description);
            iProjectService.saveProject(project);
            return "redirect:projectmanage_page";
        }
        else{
            model.addAttribute("error","项目名称或描述未填写");
            return "addproject";
        }
    }

    /**
     * 新增项目的后台提交处理
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/projectmanage_page")
    public String projectShow(HttpServletRequest request, Model model) {
        model.addAttribute("list",iProjectService.getProjects());
        return "projectmanage";
    }

    @RequestMapping("/deleteproject")
    public String deleteProject(HttpServletRequest request, Model model) {
        String name=request.getParameter("name");
        if(name!=null&&name.length()>0){
            iProjectService.deleteProject(name);
            return "redirect:projectmanage_page";
        }
        else{
            model.addAttribute("error","未指定要删除的项目名称");
            return "redirect:projectmanage_page";
        }
    }

}
