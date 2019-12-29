package com.ats.trailer.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.trailer.model.TagMaster;

@Repository
public interface TagMasterRepository extends JpaRepository<TagMaster, Integer>{

	@Query(value="select count(*) from TagMaster")
	public Integer isNewRecord();

	/* @Query(value="select max(tagId) from TagMaster where order by tagId desc") */
	
	@Query(value="select max(tagId) from TagMaster")
	public Integer findTopByOrderByTagIdDesc();

	public ArrayList<TagMaster> findAllByPersonId(Integer personId);

	@Query(value="select tagBalance from TagMaster where tagId = :tagId")
	public long findTagBalanceByTagId(int tagId);
	
	@Modifying
	@Transactional
	@Query(value="update TagMaster set tagBalance = :tagBalance where tagId = :tagId")
	public Integer updateTagBalByTagId(int tagId, long tagBalance);
}
