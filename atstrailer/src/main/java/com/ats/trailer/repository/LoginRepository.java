package com.ats.trailer.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.trailer.model.LoginModel;
import com.ats.trailer.model.Person;

@Repository
public interface LoginRepository extends CrudRepository<LoginModel, String> {
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update LoginModel l set l.userPassword= :userPassword,l.lockUser='unlock' where l.userName=:userName")
	int updateByUserName(@Param("userName") String userName, @Param("userPassword") String userPassword);
	
	
	
	@Query("select userRole from LoginModel l where userName = :userName and userPassword=:userPassword")
	String getByUserNameAndUserPassword(@Param("userName")String userName ,@Param("userPassword")String userPassword);



	LoginModel findByUserName(String userName);
	
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update LoginModel l set l.lockUser='unlock' where l.userName=:userName")
	int changeToUnLock(@Param("userName") String userName);
		
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update LoginModel l set l.lockUser='lock' where l.userName=:userName")
	int changeToLock(@Param("userName") String userName);
		
	
	
	// String findUserPassword(String userName);

	// Integer findUserLock(String userName);

}
