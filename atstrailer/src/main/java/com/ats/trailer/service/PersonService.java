package com.ats.trailer.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ats.trailer.model.Person;
import com.ats.trailer.repository.PersonRepository;

@Service
public class PersonService {
		
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);
	@Autowired
	PersonRepository<Person> personRepo;
	
	@Autowired
	LoginService loginService;
	
	@Transactional
	public void savePerson(Person person) {
		personRepo.save(person);
	}
	
	@Transactional
	public Optional<Person> getById(Long pid) {
		return personRepo.findById(pid);
	}

	public boolean isEmailAvailable(String userEmail) {
		if(loginService.getByUserName(userEmail)==null) {
			return true;
		}
		else {
		return false;
		}
	}
	
	@Transactional
	public int updateUserLockByUserEmail(String userEmail) {
		LOGGER.info("In PersonService UnLocking User");
		return personRepo.updateByUserEmail(userEmail);
	}
	
	public List<Person> findAllPersons(){
		return (ArrayList<Person>) personRepo.findAll();
	}
	
	public List<Person> findAllUsers(){
		return (ArrayList<Person>) personRepo.findAllByUserRole("user");
	}

	@Transactional
	public int updateToLock(String userEmail) {
		return personRepo.changeToLock(userEmail);
	}

	public Person findByUserName(String userEmail) {
		LOGGER.info("In Person Service -- Getting Person Data using UserEmail");
		Person person = personRepo.findByUserEmail(userEmail);
		return person;
	}

	public Person findPIdByUserEmail(String userEmail) {
		LOGGER.info("Request for User Id for user Email:{}",userEmail);
		return personRepo.findPIdByUserEmail(userEmail);
	}
}
