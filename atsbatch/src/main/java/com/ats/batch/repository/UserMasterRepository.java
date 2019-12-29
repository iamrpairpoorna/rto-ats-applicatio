package com.ats.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.batch.entity.UserMaster;


@Repository
public interface UserMasterRepository extends JpaRepository<UserMaster, Integer>{

	public UserMaster findByUserId(long userId); 
}
