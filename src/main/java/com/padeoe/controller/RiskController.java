package com.padeoe.controller;

import com.padeoe.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zafara on 2016/11/13.
 */
@Controller
    @RequestMapping("/risk")
public class RiskController {
    private static int upper_limit = 100;
   private static String risk_content = ""; //风险内容
    private static String possibility = ""; //可能性
    private static String influce_level = ""; //影响程度
    private static String threshold = ""; //阈值
    private static String committer = ""; //提交者
    private static String follower = ""; //跟踪者


    // 加风险
    @RequestMapping("/addRisk")
    public String addRisk(HttpServletRequest request, Model model){
        String returnvalue = "addrisk test";
        //权限控制？
        return returnvalue;
    }

    @RequestMapping("/addRiskBL")
    public String addRiskBL(HttpServletRequest request, Model model){
        String returnvalue = "addRiskBL test";
        boolean putInDatabase = true;
        //对数据有效性的后台检定

        risk_content = request.getParameter("risk_content");
        if(risk_content.equals("")||risk_content.equals(null)||risk_content.length()>upper_limit){
            returnvalue = "风险<内容>属性输入有误";
            putInDatabase = false;
        }

        possibility = request.getParameter("possibility");;  //只有高中低，选择？
        if(possibility.equals("高")||possibility.equals("中")||possibility.equals("低")){

        }
        else{
            returnvalue = "风险<可能性>属性输入有误";
            putInDatabase = false;
        }

        influce_level = request.getParameter("influce_level");;
        if(influce_level.equals("高")||possibility.equals("中")||possibility.equals("低")){

        }
        else{
            returnvalue = "风险<影响程度>属性输入有误";
            putInDatabase = false;
        }

        threshold = request.getParameter("threshold");;
        if(threshold.equals("")||threshold.equals(null)||threshold.length()>upper_limit){
            returnvalue = "风险<阈值>属性输入有误";
            putInDatabase = false;
        }

        committer = request.getParameter("id");

        follower = request.getParameter("follower");
        if(follower.equals("")||follower.equals(null)||follower.length()>upper_limit){
            returnvalue = "风险<跟踪者>属性输入有误";
            putInDatabase = false;
        }

        //数据加入到数据库中的操作
        if(putInDatabase != false){

        }
        return returnvalue;
    }

    // 删风险
    @RequestMapping("/deleteRisk")
    public String deleteRisk(HttpServletRequest request, Model model){
        String returnvalue = "deleteRisk test";
        // 权限控制？

        return returnvalue;
    }

    @RequestMapping("/deleteRiskBL")
    public String deleteRiskBL(HttpServletRequest request, Model model){
        String returnvalue = "deleteRiskBL test";
        //对数据有效性的后台检定

        // 查找删除risk
        return returnvalue;
    }

    // 改风险
    @RequestMapping("/changeRisk")
    public String changeRisk(HttpServletRequest request, Model model){
        String returnvalue = "changeRisk test";
        // 权限控制？
        return returnvalue;
    }

    @RequestMapping("/changeRiskBL")
    public String changeRiskBL(HttpServletRequest request, Model model){
        String returnvalue = "changeRisk test";
        //对数据有效性的后台检定

        // 修改risk
        return returnvalue;
    }

    // 查风险
    @RequestMapping("/searchRisk")
    public String searchRisk(HttpServletRequest request, Model model){
        String returnvalue = "searchRisk test";
        //权限控制
        return returnvalue;
    }

    @RequestMapping("/searchRiskBL")
    public String searchRiskBL(HttpServletRequest request, Model model){
        String returnvalue = "searchRiskBL test";
        //对数据有效性的后台检定

        // 修改risk
        return returnvalue;
    }

    protected String getUserNameWithID(String userId){

        return null;
    }
}
