package com.ats.batch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.batch.entity.BatchRunDetails;
import com.ats.batch.repository.BatchRunDetailsRepository;

@Service
public class BatchRunDetailsService {
	
	@Autowired
	BatchRunDetailsRepository brds;
	
 public void saveBatchRunDetails(BatchRunDetails batchRunDetails) {
	 brds.save(batchRunDetails);
 }

public void updateRunStatus(Integer runId) {
		brds.updateRunStatus(runId);
}
}
