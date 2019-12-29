package com.ats.batch.main;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ats.batch.entity.BatchRunDetails;
import com.ats.batch.entity.BatchRunSummary;
import com.ats.batch.entity.TagMaster;
import com.ats.batch.entity.UserMaster;
import com.ats.batch.helper.LowBalanceRemainderHelper;
import com.ats.batch.service.BatchRunDetailsService;
import com.ats.batch.service.TagMasterService;
import com.ats.batch.service.TagTransactionTriggersService;
import com.ats.batch.service.UserMasterService;


@Component
public class LowBalanceRemainderJob implements BatchProccess {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LowBalanceRemainderJob.class);

	private static final String BATCH_NAME = "LOW_BAL_RMNDER";
	private static Integer TOTAL_COUNT = 0;
	private static Integer SUCCESS_COUNT = 0;
	private static Integer FAILURE_COUNT = 0;
	private Integer runId;

	@Autowired
	BatchRunDetailsService batchRunDetailsService;

	@Autowired
	TagTransactionTriggersService tttService;

	@Autowired
	TagMasterService tagMasterService;

	@Autowired
	LowBalanceRemainderHelper helper;

	@Autowired
	UserMasterService userMasterService;
	
	
	

	ExecutorService executorService = Executors.newFixedThreadPool(10);

	public void test() {
		LOGGER.info("In the test() -- LowBalRemainderJob");
		preProcess();
		start();
		postProcess();
	}

	@Override
	public Integer preProcess() {
		LOGGER.info("In the preprocess()");
		BatchRunDetails brd = new BatchRunDetails();
		brd.setBatchName(BATCH_NAME);
		brd.setRunStatus("ST");
		brd.setCreatedBy(BATCH_NAME);
		brd.setStartDt(new Date());
		batchRunDetailsService.saveBatchRunDetails(brd);
		LOGGER.info("BatchRunDetails saved successfully");
		runId = brd.getRunId();
		return runId;

	}

	@Override
	public void start() {
		LOGGER.info("In the start()");
		Date dt = new Date();
		Timestamp createDt =  new java.sql.Timestamp( dt.getTime());
		ArrayList<Integer> tagIds = (ArrayList<Integer>) tttService.findTagIdsOf("LOW_BAL", "P");
		System.out.println(tagIds.size());
		Iterator<Integer> itr = tagIds.iterator();
		int SIZE = tagIds.size();
		LOGGER.info("Total Retrieved tagIds:{}",SIZE);
		for(int i=0;i<SIZE;i++) {
			Integer tagId = itr.next();
			LOGGER.info("Creating Thread Pool and staring run method with tagId:{}",tagId);
			process(tttService.findTxIdByTagId(tagId),tagId);
			
			
			/*
			 * executorService.execute(new Runnable() { public void run() {
			 * process(tttService.findTxIdByTagId(tagId),tagId); } });
			 */
			
		  TOTAL_COUNT++;
		}
		executorService.shutdown();
	}

	@Override
	public void process(Integer txId, Integer tagId) {
		try {
			LOGGER.info("In the Process(){}",txId,tagId);
			helper.sendRemainderEmails(tagId);
			helper.sendRemainderSms(tagId);
			helper.updateTagTxTrigger(txId, BATCH_NAME);
			SUCCESS_COUNT++;

		} catch (Exception e) {
			LOGGER.error("Exception occured in process()");
			FAILURE_COUNT++;
			System.out.println(e);
		}
	}

	@Override
	public void postProcess() {
		LOGGER.info("In The postProcess()");
		helper.updateRunStatus(runId);
		LOGGER.info("BatchRunDetails table updated");
		String smmryDtls = "Total tag tx fails=" + TOTAL_COUNT + " No of mails sent =" + SUCCESS_COUNT;

		BatchRunSummary batchRunSummary = new BatchRunSummary();
		batchRunSummary.setBatchName(BATCH_NAME);
		batchRunSummary.setCreatedBy(BATCH_NAME);
		batchRunSummary.setSummaryDts(smmryDtls);
		batchRunSummary.setUpdatedBy(BATCH_NAME);
		helper.createBatchRunSummary(batchRunSummary);
		LOGGER.info("BatchRunSummary tble entry saved");

	}

}
