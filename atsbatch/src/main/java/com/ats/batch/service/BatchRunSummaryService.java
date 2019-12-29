package com.ats.batch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.batch.entity.BatchRunSummary;
import com.ats.batch.repository.BatchRunSummaryRepository;

@Service
public class BatchRunSummaryService {
	
	@Autowired
	BatchRunSummaryRepository batchRunSummaryRepo;
	
	public void saveBatchRunSummary(BatchRunSummary batchRunSummary) {
		batchRunSummaryRepo.save(batchRunSummary);
	}

}
