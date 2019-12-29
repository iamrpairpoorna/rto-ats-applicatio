package com.ats.toll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ats.toll.model.TagTransactionTriggers;
import com.ats.toll.util.KafkaConstants;


@Service
public class ProducerService {
	
	@Autowired private KafkaTemplate<String, TagTransactionTriggers> kafkaTemplate;
	
	public String add(TagTransactionTriggers tagTransactionTriggers) {
		
		kafkaTemplate.send(KafkaConstants.TOPIC,tagTransactionTriggers);
		System.out.println("Topic added successfully:"+tagTransactionTriggers.toString());
		
		return "Single Record added successfully to Kafka queue";
	}

}
