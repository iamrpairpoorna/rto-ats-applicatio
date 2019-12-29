package com.ats.trailer.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.trailer.model.Person;

@Repository
public interface PersonRepository<P> extends CrudRepository<Person, Long>{
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update Person p set p.userLock='unlock' where p.userEmail=:userEmail")
	int updateByUserEmail(@Param("userEmail") String userEmail);
	

	ArrayList<Person> findAllByUserRole(String userRole);

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update Person p set p.userLock='lock' where p.userEmail=:userEmail")
	int changeToLock(@Param("userEmail") String userEmail);

	@Query(value="from Person where userEmail = :userEmail")
	Person findByUserEmail(String userEmail);

	@Query(value="from Person where userEmail = :userEmail")
	Person findPIdByUserEmail(String userEmail);
}
