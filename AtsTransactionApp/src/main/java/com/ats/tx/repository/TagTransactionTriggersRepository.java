package com.ats.tx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.tx.TagTransactionTriggers;

@Repository
public interface TagTransactionTriggersRepository extends JpaRepository<TagTransactionTriggers,Integer> {

}
