package com.ats.batch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.batch.entity.UserMaster;
import com.ats.batch.repository.UserMasterRepository;

@Service
public class UserMasterService {
	@Autowired
	UserMasterRepository userMasterRepo;
	
	public void saveUserMaster(UserMaster userMaster) {
		userMasterRepo.save(userMaster);
	}

	public UserMaster findByUserId(long userId) {
		return userMasterRepo.findByUserId(userId);
	}
}
