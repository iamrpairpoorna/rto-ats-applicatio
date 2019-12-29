package com.ats.trailer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ats.trailer.model.Person;
import com.ats.trailer.service.NotificationService;

@RestController
public class NotificationController {

	@Autowired
	NotificationService ns;
	@RequestMapping("/sendEmail")
	public ModelAndView sendNotification(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		Person person = (Person) session.getAttribute("person");
		System.out.println("in notification controller:"+person.getUserEmail());
		try {
			ns.sendNotification(person);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName("personPage");
		return mv;
	}
}
