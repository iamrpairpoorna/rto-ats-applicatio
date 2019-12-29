package com.ats.trailer.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.ats.trailer.model.Person;
import com.ats.trailer.model.PerviewModel;
import com.ats.trailer.model.TagMaster;
import com.ats.trailer.model.UserMaster;
import com.ats.trailer.service.PersonService;
import com.ats.trailer.service.TagMasterService;
import com.ats.trailer.service.UserMasterService;
import com.ats.trailer.service.VehicleDetialsService;
import com.ats.trailer.service.VehicleOwnerAddressService;
import com.ats.trailer.service.VehicleOwnerService;

@Controller
public class PurchaseTagController {

	private static final Logger LOGGER = LoggerFactory.getLogger("PurchaseTagController");

	@Autowired
	VehicleDetialsService vds;

	@Autowired
	VehicleOwnerAddressService voas;

	@Autowired
	VehicleOwnerService vos;

	@Autowired
	PersonService personService;

	@Autowired
	UserMasterService userService;

	@Autowired
	TagMasterService tagService;

	/* Accepting the request to show Purchage Tag Page */

	@RequestMapping("/purchaseTag")
	public String purchaseTag() {
		LOGGER.info("Displaying the web Page to enter Vehicle Registration No.");
		return "searchVehicleByNo";
	}

	/* Method to search vehicle Registration Number in RTO app through RestAPI */

	@RequestMapping(value = "/searchVehicle")
	public String searchVehicleByNo(@RequestParam("regNo") String regNo, Model model, HttpServletRequest request) {
		LOGGER.info("Received Vehicle Registration No:{}", regNo);
		request.getSession().setAttribute("regNo", regNo);
		String uri = "http://localhost:8181/api/vehicleNo?regnNum=" + regNo;
		PerviewModel pm = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			LOGGER.info("Making Rest Call to get Vehicle and Owner Details from RTO application");
			pm = restTemplate.getForObject(uri, PerviewModel.class);
		} catch (HttpClientErrorException e) {
			LOGGER.error("Invalid Registration Number");
			String errorMsg = "InCorrect Vehicle Registration No.";
			model.addAttribute("errorMsg", errorMsg);
			return "searchVehicleByNo";	
		}
		catch(HttpServerErrorException e) {
			LOGGER.error("Invalid Registration Number");
			String errorMsg = "InCorrect Vehicle Registration No.";
			model.addAttribute("errorMsg", errorMsg);
			return "searchVehicleByNo";	
		
	}
		LOGGER.info("Retrieved Owner Details for given Vehicle Registration No. & saved in session");
		HttpSession session = request.getSession();
		session.setAttribute("pm", pm);

		model.addAttribute("o", pm.getVehicleOwner());
		model.addAttribute("od", pm.getVehicleOwnerAddress());
		model.addAttribute("vd", pm.getVehicle_details());
		LOGGER.info("Added Vehicle Owner Details to model attribute for user perview");
		return "preview";
	}

	/* Method to save vehicle owner,address and vehicle details in the DB */

	@RequestMapping(params = "storeVehicleDeails", path = "/saveVehicleDetails")
	public String saveVehicleDetails(HttpServletRequest request) {
		PerviewModel pm = (PerviewModel) request.getSession().getAttribute("pm");
		LOGGER.info("Controller-Saving Owner - Vehicle - Address ,retreived from RTO app");
		vos.saveVehicleOwner(pm.getVehicleOwner());
		voas.saveVehicleOwnerAddress(pm.getVehicleOwnerAddress());
		vds.saveVehicleDetailsService(pm.getVehicle_details());
		LOGGER.info("Owner,Owner address and Vehicle Details are saved in the DB");
		return "redirect:/saveUserMaster";
	}

	/* Method to save User Master table by getting the data from the person table */

	@RequestMapping("/saveUserMaster")
	public String saveUserMaster(HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("userName");
		LOGGER.info("Generating Tag for User Name:{}", userName);
		Person person = new Person();
		LOGGER.info("Getting the Person data from DB using userName");
		person = personService.findByUserName(userName);
		UserMaster userMaster = new UserMaster();
		userMaster.setFirstName(person.getFirstName());
		userMaster.setLastName(person.getLastName());
		userMaster.setUserEmail(person.getUserEmail());
		userMaster.setUserGender(person.getUserGender());
		userMaster.setUserPhone(person.getUserPhone());
		LOGGER.info("Saving User Data in UserMaster Table");
		userService.saveUserMaster(userMaster);
		return "redirect:/generateTag";
	}

	/* method to Generate a Tag and fill in all details in the Tag Master table */

	@RequestMapping("/generateTag")
	public String generateTag(HttpServletRequest request) {
		TagMaster tagMaster = new TagMaster();
		if (tagService.isNewRecord()) {
			LOGGER.info("It is First Tag is being generated");
			tagMaster.setTagId(1);
		} else {
			LOGGER.info("New Tag is creating");
			Integer tagId = tagService.findLastTagId();
			LOGGER.info("Retrieved TagId From DB:{}",tagId);
			tagMaster.setTagId(tagId + 1);
		}
		PerviewModel pm = (PerviewModel) request.getSession().getAttribute("pm");
		tagMaster.setVehicleRegNum((String) request.getSession().getAttribute("regNo"));
		tagMaster.setCreatedBy((String) request.getSession().getAttribute("userName"));
		tagMaster.setVehicleType(pm.getVehicle_details().getVehicle_type());
		tagMaster.setUpdatedBy((String) request.getSession().getAttribute("userName"));

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, 3);
		Date date = cal.getTime();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		tagMaster.setTagEndDt(sqlDate);
		tagService.saveTagMaster(tagMaster);
		LOGGER.info("saved TagMaster table in DB");
		return "dashBoard";
	}

	@RequestMapping(params = "previous_v")
	public String previousPreview() {
		return "redirect:/purchaseTag";
	}
}
