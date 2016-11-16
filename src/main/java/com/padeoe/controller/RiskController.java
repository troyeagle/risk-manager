package com.padeoe.controller;

import com.padeoe.pojo.Risk;
import com.padeoe.pojo.User;
import com.padeoe.service.IRiskService;
import com.padeoe.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zafara on 2016/11/13.
 */
@Controller
public class RiskController {
/*    public static List<RiskItem> riskItemList=new ArrayList<>();
    static {
        riskItemList.add(new RiskItem("riskBrief","风险简介"));
        riskItemList.add(new RiskItem("riskDetail","风险详情"));
        riskItemList.add(new RiskItem("possibility","风险可能性"));
        riskItemList.add(new RiskItem("influence","影响等级"));
        riskItemList.add(new RiskItem("threshold","触发阈值"));
    }*/
    @Resource
    private IRiskService iRiskService;

    // 加风险
    @RequestMapping("/addRiskBL")
    public String addRisk(HttpServletRequest request, Model model){
        Risk risk=new Risk();
/*        for(int i=0;i<riskItemList.size();i++){
            String itemInput=request.getParameter(riskItemList.get(i).riskEnglishName);
            if(itemInput==null){
                model.addAttribute("error", riskItemList.get(i).riskEnglishName+"未填写");
                return "addrisk_page";
            }
        }*/

        String riskBrief=request.getParameter("riskBrief");
        String riskDetail =request.getParameter("riskDetail");
        String possibility=request.getParameter("possibility");
        String influence=request.getParameter("influence");
        String threshold=request.getParameter("threshold");
        if(riskBrief==null){
            model.addAttribute("error", "风险简介未填写");
            return "addrisk";
        }
        if(riskDetail==null){
            model.addAttribute("error", "风险详情未填写");
            return "addrisk";
        }
        if(possibility==null){
            model.addAttribute("error", "风险可能性未填写");
            return "addrisk";
        }
        if(influence==null){
            model.addAttribute("error", "影响等级未填写");
            return "addrisk";
        }
        if(threshold==null){
            model.addAttribute("error", "触发阈值未填写");
            return "addrisk";
        }
        if(!(influence.equals("高")||influence.equals("中")||influence.equals("低"))){
            model.addAttribute("error", "影响等级填写错误");
            return "addrisk";
        }
        if(!(possibility.equals("高")||possibility.equals("中")||possibility.equals("低"))){
            model.addAttribute("error", "可能性填写错误");
            return "addrisk";
        }
        risk.setPossibility(Risk.getLevel(possibility));
        risk.setRiskDetail(riskDetail);
        risk.setRiskBrief(riskBrief);
        risk.setRiskDetail(riskDetail);
        risk.setInfluence(Risk.getLevel(influence));
        List<Risk>risks= iRiskService.searchRisk(risk);
        if(risks!=null&&risks.size()!=0){
            model.addAttribute("error", "完全相同的风险已经添加过了");
             return "addrisk";
        }
        iRiskService.saveRisk(risk);
        return "ridirect:riskmanage_page";
    }

    @RequestMapping("/addrisk_page")
    public String addRiskPage(HttpServletRequest request, Model model){
      //  iRiskService.getRiskById();
        return "addrisk";
    }

    @RequestMapping("/riskmanage_page")
    public String riskmanage_page(HttpServletRequest request, Model model) {
        return "riskmanage";
    }

    @RequestMapping("/riskmanage")
    public String riskmanage(HttpServletRequest request, Model model) {
        return "riskmanage";
    }


    @RequestMapping("/changeRiskBL")
    public String changeRiskBL(HttpServletRequest request, Model model){
        String returnvalue = "changeRisk test";
        //对数据有效性的后台检定

        // 修改risk
        return returnvalue;
    }


}

/*
class RiskItem{
    String riskEnglishName;
    String riskChineseName;

    public RiskItem(String riskEnglishName, String riskChineseName) {
        this.riskEnglishName = riskEnglishName;
        this.riskChineseName = riskChineseName;
    }
}*/
