package com.ats.batch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.batch.entity.TagMaster;
import com.ats.batch.repository.TagMasterRepository;

@Service
public class TagMasterService {
	@Autowired
	TagMasterRepository tagMasterRepo;
	
	public void saveTagMaster(TagMaster tagMaster) {
		tagMasterRepo.save(tagMaster);
	}
	
	public TagMaster findByTagId(Integer tagId) {
		return tagMasterRepo.findByTagId(tagId);
	}
}
