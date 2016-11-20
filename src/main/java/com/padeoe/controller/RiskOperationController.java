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

import com.padeoe.pojo.Notification;
import com.padeoe.pojo.Risk;
import com.padeoe.pojo.RiskOperation;
import com.padeoe.pojo.User;
import com.padeoe.service.INotificationService;
import com.padeoe.service.IRiskOperationService;
import com.padeoe.service.IRiskService;
import com.padeoe.service.ISearchService;

/**
 * 用于风险条目的增删改
 * 
 * @author luohaoran
 */
@Controller
public class RiskOperationController {
	@Resource IRiskOperationService riskOpService;
	@Resource IRiskService riskService;
	@Resource ISearchService searchService;
	@Resource INotificationService notificationService;

	private final Map<String, Integer> riskPossibility = new HashMap<>(); 	private final String[] riskPossibilityReverse;
	private final Map<String, Integer> riskInfluence = new HashMap<>(); 	private final String[] riskInfluenceReverse;
	private final Map<String, Integer> riskState = new HashMap<>(); 		private final String[] riskStateReverse; {
		riskPossibilityReverse = new String[] {null, "低", "普通", "高"};
		for(int i = 1; i < riskPossibilityReverse.length; i ++)
			riskPossibility.put(riskPossibilityReverse[i], i);
		
		riskInfluenceReverse = new String[] {null, "一般", "较大", "致命"};
		for(int i = 1; i < riskInfluenceReverse.length; i ++)
			riskInfluence.put(riskInfluenceReverse[i], i);
		
		riskStateReverse = new String[] {null, "被发现", "演变为问题", "解决中", "已解决"};
		for(int i = 1; i < riskStateReverse.length; i ++)
			riskState.put(riskStateReverse[i], i);	
	}
	
	/* Routers */
	@SuppressWarnings("deprecation")
	public @RequestMapping("/addrisk_op") String routeAddRiskOp(HttpServletRequest request) {
		// Error
		String error = request.getParameter("error");
		
		// Project
		String project = request.getParameter("name");
		
		// Type
		String type = request.getParameter("type");
		if(type == null) type = "";
		
		// Start date.
		String startdate = request.getParameter("startdate");
		Date startDateObj = null;
		if(startdate != null && startdate.length() > 0) 
			startDateObj = new Date(startdate);
		
		// End date.
		String enddate = request.getParameter("enddate");
		Date endDateObj = null;
		if(enddate != null && enddate.length() > 0)
			endDateObj = new Date(enddate);
		
		// Search
		ArrayList<Risk> list;
		switch(type) {
			case "被识别的风险":
				list = new ArrayList<Risk>(
						searchService.searchByCondition(1, project, startDateObj, endDateObj));
			break;
			case "转化为问题的风险":
				list = new ArrayList<Risk>(
						searchService.searchByCondition(2, project, startDateObj, endDateObj));
			break;
			default: 
				list = new ArrayList<Risk>(searchService.selectExcludeProject(project));
			break;
		}
		
		request.setAttribute("name", project);
		request.setAttribute("list", list);
		request.setAttribute("type", type);
		request.setAttribute("startdate", startdate);
		request.setAttribute("enddate", enddate);
		request.setAttribute("error", error);
		
		return "addrisk_op";
	}
	public @RequestMapping("/modifyrisk_op") String routeModifyRiskOp(HttpServletRequest request) {
		// Risk Operation
		RiskOperation riskOperation = riskOpService.selectById(
				Integer.parseInt(request.getParameter("id")));
		request.setAttribute("riskop", riskOperation);
		
		// Risk
		Risk risk = riskService.getRiskById(riskOperation.getRiskId());
		request.setAttribute("risk", risk);
		
		return "modifyrisk_op";	
	}
	
	private String formatItem(String name, int index) {
		return name + "_" + index;
	}
	
	/** 
	 * Clone some critical fields so that comparison could be done.
	 */
	private RiskOperation cloneCriticals(RiskOperation source) {
		RiskOperation destination = new RiskOperation();
		destination.setCreatorName(source.getCreatorName());
		destination.setDescription(source.getDescription());
		destination.setInfluence(source.getInfluence());
		destination.setPossibility(source.getPossibility());
		destination.setState(source.getState());
		destination.setTracerName(source.getTracerName());
		return destination;
	}
	
	/**
	 * Push attributes into another risk operation.
	 * 
	 * @throws Exception when some fields malformed.
	 */
	
	private void primeRiskOperation(RiskOperation operation, Date updateTime,
			String description, String tracerName, String possibilityString, 
			String influenceString, String status) throws Exception {
		operation.setUpdateTime(updateTime);
		operation.setDescription(description);
		operation.setTracerName(tracerName);
		
		operation.setState(riskState.get(status));
		if(operation.getState() == null) 
			throw new Exception("无法识别的状态：" + status);

		operation.setPossibility(riskPossibility.get(possibilityString));
		if(operation.getPossibility() == null) 
			throw new Exception("无法识别的可能性：" + possibilityString);

		operation.setInfluence(riskInfluence.get(influenceString));
		if(operation.getInfluence() == null) 
			throw new Exception("无法识别的影响等级：" + influenceString);
	}
	
	/**
	 * Notify after insertion of modification is done.
	 */
	
	private void notify(Date sendTime, User operator, RiskOperation before, 
			RiskOperation operation, String title, String content) {
		if(operation.getTracerName() == null) return;
		if(operation.getTracerName().length() == 0) return;
		
		Notification notification = new Notification();
		notification.setFromUser(operator.getUsername());
		notification.setToUser(operation.getTracerName());
		if(title != null && title.length() > 0) notification.setTitle(title);
		else {
			if(before == null) notification.setTitle("风险" + riskStateReverse[1] + "消息");
			else if(before.getState().compareTo(operation.getState()) != 0)
				notification.setTitle("风险" + riskStateReverse[operation.getState()] + "消息");
			else notification.setTitle("风险状态变更消息");
		}
		
		if(content != null && content.length() > 0) notification.setContent(content);
		else {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(operation.getDescription()).append("\n\n\n");
			stringBuilder.append("[系统消息]我们还发现了以下变化：\n");
			
			if(before.getInfluence().compareTo(operation.getInfluence()) != 0)
				stringBuilder.append("风险影响度：")
					.append(riskInfluenceReverse[before.getInfluence()]).append(" -> ")
					.append(riskInfluenceReverse[operation.getInfluence()]).append('\n');
			
			if(before.getPossibility().compareTo(operation.getPossibility()) != 0)
				stringBuilder.append("风险可能性：")
					.append(riskPossibilityReverse[before.getPossibility()]).append(" -> ")
					.append(riskPossibilityReverse[operation.getPossibility()]).append('\n');
			
			if(before.getTracerName().compareTo(operation.getTracerName()) != 0)
				stringBuilder.append("跟踪者：")
					.append(before.getTracerName()).append(" -> ")
					.append(operation.getTracerName()).append('\n');
					
			notification.setContent(new String(stringBuilder));
		}
		
		notification.setRiskOperationId(operation.getId());
		notification.setTime(sendTime);
		
		notificationService.notify(notification);
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
				if(!"on".equals(request.getParameter(formatItem("check", i)))) continue;
				
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
						possibilityString, influenceString, "被发现");
				
				// Add to update queue.
				operations.add(operation);
			}
			
			for(RiskOperation op : operations) {
				riskOpService.saveRiskOperation(op);
				notify(currentTime, operator, null, op, null, null);
			}
			
			return "redirect:project_page?name=" + project;
		}
		catch(Exception e) {
			return "redirect:addrisk_op?name=" + project 
					+ "&error=" + e.getMessage();
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
		String id = request.getParameter("id");
		
		try {
			RiskOperation victim = riskOpService.selectById(Integer.parseInt(id));
			if(victim == null) throw new Exception("风险条目不存在！");
			
			RiskOperation formerState = cloneCriticals(victim);
			String riskDetail = request.getParameter("riskDetail");
			String tracerName = request.getParameter("tracer");
			String possibilityString = request.getParameter("possibility");
			String influenceString = request.getParameter("influence");
			String state = request.getParameter("state");
			
			primeRiskOperation(victim, currentTime, riskDetail, tracerName, 
					possibilityString, influenceString, state);
			
			riskOpService.saveRiskOperation(victim);
			if("true".equals(request.getParameter("Notification"))) 
				notify(currentTime, operator, formerState, victim, 
						request.getParameter("Notificationtitle"), 
						request.getParameter("Notificationmessage"));
			
			return "redirect:project_page?name=" + victim.getProjectName();
		}
		catch(Exception e) {
			return "redirect:modifyrisk_op?id=" 
					+ id + "&error=" + e.getMessage();
		}
	}
}
