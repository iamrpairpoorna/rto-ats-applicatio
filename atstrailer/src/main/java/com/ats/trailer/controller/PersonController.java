package com.ats.trailer.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ats.trailer.model.Person;
import com.ats.trailer.service.NotificationService;
import com.ats.trailer.service.PersonService;

@Controller
public class PersonController {
	@Autowired
	PersonService personService;
	
	@Autowired
	NotificationService ns;
	
	@RequestMapping("/home")
	public String home() {
		return "home";
		
	}
	
	
	
	
	@RequestMapping("/registerPerson")
	public String personPage() {
		return "registerUser";
		
	}
	
	@RequestMapping("/findPerson")
	public String findPerson() {
		return "searchPerson";
	}
	
	@RequestMapping("/saveUserDetails")
	public String savePerson(Person person,HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		person.setUserLock("lock");
		session.setAttribute("person", person);
		model.addAttribute("person", person);
		if(personService.isEmailAvailable(person.getUserEmail())) {
			personService.savePerson(person);
			return "redirect:/sendEmail";
		}
		else {
			model.addAttribute("errorMsg","Email Already Taken");
			return "backHome";
		}
		
	}
	
	
	@RequestMapping("/successPage")
	public String showSuccess() {
				return "personPage";
		
	}
	
	
	

}
