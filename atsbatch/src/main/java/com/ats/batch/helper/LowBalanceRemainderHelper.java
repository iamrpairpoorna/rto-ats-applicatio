package com.ats.batch.helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ats.batch.entity.BatchRunSummary;
import com.ats.batch.entity.TagMaster;
import com.ats.batch.entity.UserMaster;
import com.ats.batch.service.BatchRunDetailsService;
import com.ats.batch.service.BatchRunSummaryService;
import com.ats.batch.service.TagMasterService;
import com.ats.batch.service.TagTransactionTriggersService;
import com.ats.batch.service.UserMasterService;

@Service
public class LowBalanceRemainderHelper {
	
	private JavaMailSender javaMailSender;

	@Autowired
	BatchRunDetailsService batchRunService;

	@Autowired
	BatchRunSummaryService summaryService;

	@Autowired
	TagTransactionTriggersService triggerService;
	
	@Autowired
	TagMasterService tagMasterService;
	
	@Autowired
	UserMasterService userMasterService;
	
	
	
	public LowBalanceRemainderHelper(JavaMailSender javaMailSender) throws Exception {
		super();
		this.javaMailSender = javaMailSender;
	}

	public void sendRemainderEmails(Integer tagId) {
		
		 TagMaster tagMaster = tagMasterService.findByTagId(tagId);
		  long userId = tagMaster.getUserId();
		  UserMaster userMaster = userMasterService.findByUserId(userId);

		SimpleMailMessage smm = new SimpleMailMessage();
		System.out.println("in service:" + userMaster.getUserEmail());
		smm.setTo(userMaster.getUserEmail());
		// smm.setFrom("chandurapolu@gmail.com");
		smm.setSubject("ATS Toll Failure Message");
		String content = mailContent(userMaster);
		//System.out.println(content);
		smm.setText(content);
		

		javaMailSender.send(smm);
	}

	public String mailContent(UserMaster userMaster){

		
		String line = "";
		String oldPut = "", outPut = "";
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("src/main/resources/success.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while ((line = br.readLine()) != null) {
				oldPut = oldPut + line + "\n";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		oldPut = oldPut.replaceAll("FName", userMaster.getFirstName());
		oldPut = oldPut.replaceAll("LName", userMaster.getLastName());
		return oldPut;
	}

	public void sendRemainderSms(Integer PhNo) {
		// TODO logic to send msg to Phno;
	}

	public void updateRunStatus(Integer runId) {
		batchRunService.updateRunStatus(runId);
	}

	public void createBatchRunSummary(BatchRunSummary batchRunSummary) {
		summaryService.saveBatchRunSummary(batchRunSummary);
	}

	public void updateTagTxTrigger(Integer txId, String batchName) {
		triggerService.updateUpdatedBy(txId, batchName);
	}
}
