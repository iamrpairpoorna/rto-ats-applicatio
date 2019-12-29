package com.ats.trailer.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.trailer.model.TagMaster;
import com.ats.trailer.repository.TagMasterRepository;

@Service
public class TagMasterService {
	
	@Autowired
	TagMasterRepository tagRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(TagMasterService.class);
	
	public Boolean  isNewRecord() {
		if(tagRepo.isNewRecord()==0)
			return true;
		else
			return false;
	}
	
	public void saveTagMaster(TagMaster tagMaster) {
		tagRepo.save(tagMaster);
	}

	public Integer findLastTagId() {
		
		return tagRepo.findTopByOrderByTagIdDesc();
	}

	public ArrayList<TagMaster> findByPersonId(Integer personId) {
		LOGGER.info("Searching in the Tag Master Repository for Tags");
		return tagRepo.findAllByPersonId(personId);
	}

	public long findTagBalanceByTagId(int tagId) {
		return tagRepo.findTagBalanceByTagId(tagId);
	}

	public Integer updateTagBalByTagId(int tagId, long tagBalance) {
		return tagRepo.updateTagBalByTagId(tagId,tagBalance);
	}
	
}
