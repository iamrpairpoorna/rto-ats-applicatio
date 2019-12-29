package com.ats.trailer.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ats.trailer.model.LoginModel;
import com.ats.trailer.service.LoginService;

@Controller
public class LoginUserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginUserController.class);

	@Autowired
	LoginService loginService;

	@RequestMapping("/checkDetails")
	public ModelAndView loginCheck(@RequestParam("userName") String userName,
			@RequestParam("password") String userPassword, Model model,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		LOGGER.info("Checking User Name and Password");
		String userRole = loginService.checkPasswords(userName, userPassword);
		if (userRole.equalsIgnoreCase("user")) {
			LOGGER.info("Logged in Customer has a user role");
			request.getSession().setAttribute("userName", userName);
			mv.setViewName("dashBoard");
		} else if (userRole.equalsIgnoreCase("admin")) {
			LOGGER.info("Logged in Customer has a admin role");
			mv.setViewName("adminDashBoard");
		} else if(userRole.equalsIgnoreCase("na")) {
			LOGGER.error("User Name and Password are invalid");
			mv.addObject("errorMsg", "Invalid UserName/Password");
			mv.setViewName("home");
		}

		return mv;
	}

}
