package com.padeoe.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
	
	private void primeRiskOperation(RiskOperation operation, Date updateTime,
			String description, String tracerName, String possibilityString, 
			String influenceString, String status) throws Exception {
		operation.setUpdateTime(updateTime);
		operation.setDescription(description);
		operation.setTracerName(tracerName);
		operation.setState(Integer.parseInt(status));

		Integer possibility = riskPossibility.get(possibilityString);
		if(possibility == null) throw new Exception("无法识别的可能性：" + possibilityString);
		operation.setPossibility(possibility);

		Integer influence = riskInfluence.get(influenceString);
		if(influence == null) throw new Exception("无法识别的影响等级：" + influenceString);
		operation.setInfluence(influence);
	}
	
	private void notify(User operator, RiskOperation operation) {
		// doNotify!
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
				operation.setProjectName(project);
				operation.setCreatorName(operator.getUsername());
				operation.setRiskId(Integer.parseInt(
						request.getParameter(formatItem("id", i))));
				
				String riskDetail = request.getParameter(formatItem("detail", i));
				String tracerName = request.getParameter(formatItem("tracer", i));
				String possibilityString = request.getParameter(formatItem("possibility", i));
				String influenceString = request.getParameter(formatItem("influence", i));
				
				primeRiskOperation(operation, currentTime, riskDetail, tracerName, 
						possibilityString, influenceString, "1");
				
				// Add to update queue.
				operations.add(operation);
			}
			
			for(RiskOperation op : operations) {
				riskOpService.saveRiskOperation(op);
				notify(operator, op);
			}
			
			return "project_page?name=" + project;
		}
		catch(Exception e) {
			model.addAttribute("error", e.getMessage());
			return "addrisk_op";
		}
	}
	
	@RequestMapping("/modifyRiskOpBL")
	public String modifyRiskOp(HttpServletRequest request, Model model, HttpSession session) {
		User operator = (User) session.getAttribute("user");
		if(operator == null) {
			model.addAttribute("error", "进行操作前请先登陆！");
			return "login";
		}
		Date currentTime = new Date();
		
		try {
			RiskOperation victim = new RiskOperation();
			victim.setId(Integer.parseInt(request.getParameter("id")));
			List<RiskOperation> result = riskOpService.queryByCondition(victim);
			if(result.size() != 1) throw new Exception("风险条目不存在！");
			victim = result.get(0);

			String riskDetail = request.getParameter("riskDetail");
			String tracerName = request.getParameter("tracer");
			String possibilityString = request.getParameter("possibility");
			String influenceString = request.getParameter("influence");
			String state = request.getParameter("state");
			
			primeRiskOperation(victim, currentTime, riskDetail, tracerName, 
					possibilityString, influenceString, state);
			
			riskOpService.updateRiskOperation(victim);
			if("true".equals(request.getParameter("Notification"))) 
				notify(operator, victim);
			
			return "project_page?name=" + victim.getProjectName();
		}
		catch(Exception e) {
			model.addAttribute("error", e.getMessage());
			return "modifyrisk_op";
		}
	}
}
