package com.ats.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ats.tx.TagTransactionTriggers;
import com.ats.tx.repository.TagTransactionTriggersRepository;
import com.ats.tx.until.KafkaConstants;

@Service
public class ConsumerServie {
	@Autowired TagTransactionTriggersRepository repo;

	@KafkaListener(groupId = KafkaConstants.GROUP_ID,topics = KafkaConstants.TOPIC )
	public TagTransactionTriggers ListenToTopic(TagTransactionTriggers txTriggers) {
		
		System.out.println("Received Transaction:"+txTriggers.toString());
		repo.save(txTriggers);
		return txTriggers;
	}
}
