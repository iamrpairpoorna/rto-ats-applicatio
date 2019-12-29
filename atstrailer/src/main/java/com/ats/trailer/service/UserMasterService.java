package com.ats.trailer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.trailer.model.UserMaster;
import com.ats.trailer.repository.UserMasterRepository;

@Service
public class UserMasterService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserMasterService.class);
	
	@Autowired UserMasterRepository userRepo;
	
	public void saveUserMaster(UserMaster userMaster) {
		LOGGER.info("saving the User Master");
		userRepo.save(userMaster);
		
	}
}
