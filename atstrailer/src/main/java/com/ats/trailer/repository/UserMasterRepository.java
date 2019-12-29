package com.ats.trailer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.trailer.model.UserMaster;

@Repository
public interface UserMasterRepository extends JpaRepository<UserMaster, Integer>{

}
