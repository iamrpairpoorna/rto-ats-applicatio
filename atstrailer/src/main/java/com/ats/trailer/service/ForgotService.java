package com.ats.trailer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.trailer.repository.LoginRepository;

@Service
public class ForgotService {
	@Autowired
	LoginService ls;

	@Autowired
	LoginRepository loginRepo;

	public boolean checkEmail(String userName) {
		if (ls.getByUserName(userName) != null) {
			return true;
		} else {
			return false;
		}
	}

	public void setNewPasswordService(String userName, String userPassword) {
		loginRepo.updateByUserName(userName, userPassword);
	}

}
