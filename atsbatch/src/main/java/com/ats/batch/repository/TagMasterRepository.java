package com.ats.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.batch.entity.TagMaster;


public interface TagMasterRepository extends JpaRepository<TagMaster, Integer>{
 
	public TagMaster findByTagId(Integer tagId);
 
}
