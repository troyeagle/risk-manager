package com.padeoe.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zafara on 2016/11/13.
 */
public class RiskController {
   private static String risk_content = "";
    private static String possibility = "";
    private static String influce_level = "";
    private static String threshold = "";
    private static String committer = "";
    private static String follower = "";


    // 加风险
    @RequestMapping("/addRisk")
    public String addRisk(HttpServletRequest request, Model model){
        String returnvalue = "addrisk test";
        return returnvalue;
    }

    @RequestMapping("/addRiskBL")
    public String addRiskBL(HttpServletRequest request, Model model){
        String returnvalue = "addRiskBL test";
        return returnvalue;
    }

    // 删风险
    @RequestMapping("/deleteRisk")
    public String deleteRisk(HttpServletRequest request, Model model){
        String returnvalue = "deleteRisk test";
        return returnvalue;
    }

    @RequestMapping("/deleteRiskBL")
    public String deleteRiskBL(HttpServletRequest request, Model model){
        String returnvalue = "deleteRiskBL test";
        return returnvalue;
    }

    // 改风险
    @RequestMapping("/changeRisk")
    public String changeRisk(HttpServletRequest request, Model model){
        String returnvalue = "changeRisk test";
        return returnvalue;
    }

    @RequestMapping("/changeRiskBL")
    public String changeRiskBL(HttpServletRequest request, Model model){
        String returnvalue = "changeRisk test";
        return returnvalue;
    }

    // 查风险
    @RequestMapping("/searchRisk")
    public String searchRisk(HttpServletRequest request, Model model){
        String returnvalue = "searchRisk test";
        return returnvalue;
    }

    @RequestMapping("/searchRiskBL")
    public String searchRiskBL(HttpServletRequest request, Model model){
        String returnvalue = "searchRiskBL test";
        return returnvalue;
    }
}
