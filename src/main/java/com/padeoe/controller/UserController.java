package com.padeoe.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.padeoe.pojo.User;
import com.padeoe.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.padeoe.pojo.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;

	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model, HttpSession session){
		User login_user = null;
		String return_value = "login";
		login_user = userService.getUserByName(request.getParameter("username"));
		if(login_user != null){
			if(login_user.getPassword().equals(request.getParameter("password"))){
				session.setAttribute("Id",login_user.getId());
				return_value = "index";
			}
			else{
				model.addAttribute("error", "密码输入错误");
			}
		}
		else{
			model.addAttribute("error", "未找到对应用户名");
		}
		return return_value;
	}

	@RequestMapping("/register")
	public String register(HttpServletRequest request,Model model){
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String Authority = request.getParameter("Authority");
		User temp_user = new User();
		temp_user.setPassword(password);
		temp_user.setUserName(name);
		temp_user.setAuthority(Authority);

		userService.saveUser(temp_user);
		return "showUser";
	}
}
