package com.ats.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.batch.entity.BatchRunSummary;


public interface BatchRunSummaryRepository extends JpaRepository<BatchRunSummary, Integer>{

}
