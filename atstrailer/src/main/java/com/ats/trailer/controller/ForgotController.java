package com.ats.trailer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ats.trailer.service.ForgotService;

@Controller
public class ForgotController {
	@Autowired
	ForgotService forgotService;

	@RequestMapping("/forgotForm")
	public String forgotPage() {
		return "forgotPage";
	}

	@RequestMapping("/checkEmail")
	public String checkingEmail(@RequestParam("userName") String userName, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("userName", userName);
		if (forgotService.checkEmail(userName)) {
			model.addAttribute("userName", userName);
			return "setPasswordPage";
		} else {
			return "error";
		}
	}

	@RequestMapping("/setNewPassword")
	public String setNewPassword(@RequestParam("userPassword") String userPassword, HttpServletRequest request) {

		String userName = (String) request.getSession().getAttribute("userName");
		System.out.println(userName);
		forgotService.setNewPasswordService(userName, userPassword);
		return "redirect:/home";
	}
}
