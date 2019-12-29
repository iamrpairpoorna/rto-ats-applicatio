package com.ats.batch.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.batch.entity.TagTransactionTriggers;
import com.ats.batch.repository.TagTransactionTriggersRepository;

@Service
public class TagTransactionTriggersService {
	@Autowired
	TagTransactionTriggersRepository tttrepo;

	public void saveTagTransactionTriggers(TagTransactionTriggers ttt) {
		tttrepo.save(ttt);
	}

	public List<Integer> findTagIdsOf(String failureReason, String rmnderMsgswtch) {

		return tttrepo.findUserIdAndUserEmails(failureReason, rmnderMsgswtch);

	}

	public Integer findTxIdByTagId(Integer tagId) {
		return tttrepo.findTxIdByTagId(tagId);
	}

	public void updateUpdatedBy(Integer txId, String batchName) {
		tttrepo.updateUpdateBy(txId,batchName);
	}
}
