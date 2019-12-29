package com.ats.trailer.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ats.trailer.model.Person;
import com.ats.trailer.model.TagMaster;
import com.ats.trailer.service.PersonService;
import com.ats.trailer.service.TagMasterService;

@Controller
public class TagAccountController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TagAccountController.class);
	
	@Autowired
	PersonService personService;
	
	@Autowired
	TagMasterService masterService;
	
	/*this method displays the Tag Accounts for current login User */
	
	@RequestMapping("/tagAccountSummary")
	public String tagAccountDetais(Model model, HttpServletRequest request) {
		HttpSession  session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		LOGGER.info("Get the userId for the User Name:{}",userName);
		Person person = personService.findPIdByUserEmail(userName);
		int pid = (int) person.getPid();
		String name = person.getFirstName()+" "+person.getLastName();
		LOGGER.info("Searching and Retrieving all the Tags for this UserId:{}",pid);
		
		ArrayList<TagMaster> tagMasters = masterService.findByPersonId(pid);
		model.addAttribute("name",name);
		model.addAttribute("tagMasters",tagMasters);
		return "tagAccounts";
	}
	
	/* this method displays the recharge page for selected tag, where user cal recharge his account */
	
	@RequestMapping("/reCharge")
	public String rechargeTag(@RequestParam("tagId")String tgId,Model model,HttpServletRequest request) {
		int tagId = Integer.parseInt(tgId);
		LOGGER.info("Gettin Tag Balance for the selected tag");
		long tagBalance = masterService.findTagBalanceByTagId(tagId);
		request.getSession().setAttribute("tagId", tagId);
		model.addAttribute("tagBalance",tagBalance);
		model.addAttribute("tagId",tagId);
		return "rechargeTag";
	}
	
	/* this method will update the account Balance in the repository */
	@RequestMapping("/rechargeTagId")
	public String rechargeTagId(@RequestParam("amount")String amount,HttpServletRequest request) {
		Integer tagId =  (Integer) request.getSession().getAttribute("tagId");
		Long tagBalance = masterService.findTagBalanceByTagId(tagId);
		long rechAmount = Long.parseLong(amount);
		tagBalance = tagBalance + rechAmount;
		masterService.updateTagBalByTagId(tagId,rechAmount);
		return "redirect:/tagAccountSummary";
		
	}

}
