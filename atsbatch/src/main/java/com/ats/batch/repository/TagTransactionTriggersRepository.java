package com.ats.batch.repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ats.batch.entity.TagTransactionTriggers;


public interface TagTransactionTriggersRepository extends JpaRepository<TagTransactionTriggers, Integer> {
	
	@Query(value="select tagId from TagTransactionTriggers where trFailureReason =:failureReason and trRemainderMsg= :rmnderMsgswtch")
	public List<Integer> findUserIdAndUserEmails(String failureReason,String rmnderMsgswtch);
	
	@Query(value="select transactionId from TagTransactionTriggers where tagId = :tagId")
	public Integer findTxIdByTagId(Integer tagId);
	
	
	@Modifying
	@Transactional
	@Query(value="update TagTransactionTriggers set trRemainderMsg = 'C' ,updatedBy = :batchName where transactionId = :txId")
	public void updateUpdateBy(Integer txId, String batchName);
}
