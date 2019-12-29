package com.ats.trailer.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ats.trailer.model.Person;
import com.ats.trailer.service.LoginService;
import com.ats.trailer.service.PersonService;

@Controller
public class AdminController {
	@Autowired
	LoginService loginService;

	@Autowired
	PersonService personService;

	@RequestMapping("/adminDashBoard")
	public String adminDashBoard() {
		return "adminDashBoard";
	}

	@RequestMapping("/addUser")
	public String addUserPage() {
		return "addUserAdminPage";
	}

	@RequestMapping("/saveUserByAdmin")
	public String saveUserByAdmin(Person person, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.setAttribute("person", person);
		model.addAttribute("person", person);
		if (personService.isEmailAvailable(person.getUserEmail())) {
			personService.savePerson(person);
			return "redirect:/sendEmail";
		} else {
			model.addAttribute("errorMsg", "Email Already Taken");
			return "againAddUserAdmin";
		}
	}

	@RequestMapping("/showUsers")
	public String viewAllUsers(Model model) {
		List<Person> list = personService.findAllUsers();
		model.addAttribute("list", list);
		return "displayAllUserAdmin";
	}

	@RequestMapping("/changeStatus")
	public String changeLockStatus(@RequestParam("userEmail")String userEmail,@RequestParam("userLock")String userLock) {
		if(userLock.contains("lock")) {
			System.out.println("in admin controller:"+userLock);
			loginService.changeToUnLock(userEmail);
			personService.updateUserLockByUserEmail(userEmail);
		}
		else{
			System.out.println("in admin controller:"+userLock);
			loginService.changeToLock(userEmail);
			personService.updateToLock(userEmail);
		}
		
		return "redirect:/showUsers";
	}
}
