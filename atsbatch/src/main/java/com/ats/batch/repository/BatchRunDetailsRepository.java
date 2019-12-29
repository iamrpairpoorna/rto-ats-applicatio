package com.ats.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.batch.entity.BatchRunDetails;

@Repository
public interface BatchRunDetailsRepository extends JpaRepository<BatchRunDetails, Integer>{
	
	
	@Modifying
	@Transactional
	@Query(value="update BatchRunDetails set runStatus='ED' where runId = :runId")
	void updateRunStatus(Integer runId);

}
