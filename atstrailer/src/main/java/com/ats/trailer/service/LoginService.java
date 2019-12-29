package com.ats.trailer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ats.trailer.model.LoginModel;
import com.ats.trailer.model.Person;
import com.ats.trailer.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepo;
	
	@Autowired
	PersonService ps;

	public void saveLoginDetails(LoginModel lm) {
		loginRepo.save(lm);
	}
	
	@Transactional
	public boolean updateLoginService(String userName, String oldPass, String userPassword) {
		if (checkPasswords(userName, oldPass)!=null) {
			loginRepo.updateByUserName(userName, userPassword);
			ps.updateUserLockByUserEmail(userName);
			
			return true;
		} else {
			return false;
		}
	}

	public String checkPasswords(String userName,String oldPass) {
		String userRole=loginRepo.getByUserNameAndUserPassword(userName,oldPass);
		if(userRole!=null) {
			return userRole;
		}
		else
			return "na";
		
	}

	public LoginModel getByUserName(String userName) {
		LoginModel lm = loginRepo.findByUserName(userName);
		return lm;
	}
	
	@Transactional
	public int changeToLock(String userName) {
		return loginRepo.changeToLock(userName);
	}
	
	@Transactional
	public int changeToUnLock(String userName) {
		System.out.println("In the Login Service:"+userName);
		return loginRepo.changeToUnLock(userName);
	}
}
