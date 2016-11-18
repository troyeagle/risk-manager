package com.padeoe.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.padeoe.pojo.RiskOperation;
import com.padeoe.pojo.User;
import com.padeoe.service.IRiskOperationService;
import com.padeoe.service.IRiskService;

/**
 * 用于风险条目的增删改
 * 
 * @author luohaoran
 */
@Controller
public class RiskOperationController {
	@Resource IRiskOperationService riskOpService;
	@Resource IRiskService riskService;

	private final Map<String, Integer> riskPossibility = new HashMap<>(); 
	private final Map<String, Integer> riskInfluence = new HashMap<>(); {
		riskPossibility.put("高", 3);	riskPossibility.put("普通", 2);	riskPossibility.put("低", 1);
		riskInfluence.put("一般", 1);	riskInfluence.put("较大", 2);	riskInfluence.put("致命", 3);
	}
	
	/* Routers */
	public @RequestMapping("/addrisk_op") String routeAddRiskOp() 		{		return "addrisk_op";		}
	public @RequestMapping("/modifyrisk_op") String routeModifyRiskOp() {		return "/modifyrisk_op";	}
	
	private String formatItem(String name, int index) {
		return name + "_" + index;
	}
	
	/**
	 * 插入风险条目流程
	 * 1. 用户进入某一项目
	 * 2. 用户选择导入风险
	 * 3. 进行风险的筛选（Search.Program.Import）
	 * 4. 在页面中修改某些值（Program.RiskItem.Insert）
	 * 5. 提交表单到该服务
	 * 6. 该服务完成执行或报告错误
	 */
	
	@RequestMapping("/insertRiskOpBL")
	public String insertRiskOp(HttpServletRequest request, Model model, HttpSession session) {
		User operator = (User) session.getAttribute("user");
		if(operator == null) {
			model.addAttribute("error", "进行操作前请先登陆！");
			return "login";
		}
		int totalRisk = Integer.parseInt(request.getParameter("totalRisk"));
		String project = request.getParameter("project");
		Date currentTime = new Date();
		
		try {
			ArrayList<RiskOperation> operations = new ArrayList<>();
			for(int i = 0; i < totalRisk; i ++) {
				if(!request.getParameter(formatItem("check", i)).equals("true")) continue;
				
				//Shared amongst import.
				RiskOperation operation = new RiskOperation();
				operation.setUpdateTime(currentTime);
				operation.setProjectName(project);
				operation.setCreatorName(operator.getUsername());
				operation.setState(1);	// 导入全部当成识别风险
				
				// No check needed.
				operation.setRiskId(Integer.parseInt(request.getParameter(formatItem("id", i))));
				operation.setDescription(request.getParameter(formatItem("detail", i)));
				operation.setTracerName(request.getParameter(formatItem("tracer", i) + i));
				
				// Check needed.
				String possibilityString = request.getParameter(formatItem("possibility", i) + i);
				Integer possibility = riskPossibility.get(possibilityString);
				if(possibility == null) throw new Exception("无法识别的可能性：" + possibilityString);
				operation.setPossibility(possibility);

				String influenceString = request.getParameter(formatItem("influence", i));
				Integer influence = riskInfluence.get(influenceString);
				if(influence == null) throw new Exception("无法识别的影响等级：" + influenceString);
				operation.setInfluence(influence);
				
				// Add to update queue.
				operations.add(operation);
			}
			
			for(RiskOperation op : operations)
				riskOpService.saveRiskOperation(op);
			
			return "project_page";
		}
		catch(Exception e) {
			model.addAttribute("error", e.getMessage());
			return "addrisk_op";
		}
	}
}
