package com.ats.trailer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ats.trailer.service.LoginService;

@Controller
public class UpdateLoginController {
	@Autowired
	LoginService ls;

	@RequestMapping("/updatePage")
	public String updatePageShow() {
		return "loginUpdatePage";
	}

	@RequestMapping("/updateLoginDetails")
	public String UpdateLoginDetails(@RequestParam("userName") String userName,
			@RequestParam("tempPass") String tempPass, @RequestParam("newPass") String newPass) {
		if (ls.updateLoginService(userName, tempPass, newPass)) {
			return "redirect:/home";
		} else {
			return ("redirect:/updateLoginDetails");
		}

	}

}
