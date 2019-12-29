package com.ats.toll.controller;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.toll.model.TagTransactionTriggers;
import com.ats.toll.service.ProducerService;

@RestController
public class ProducerController {
	
	@Autowired ProducerService producerService;
	
	@GetMapping("/getTagTx")
	public TagTransactionTriggers getTagTx() {
		return new TagTransactionTriggers(201, "TS08FL995", 345, 165l, "FAILED", "LOW_BAL", "P", new Date(), new Date(), "TOLL_GATE", "TOLL_GATE");
	}
	
	@PostMapping("/addTagTx")
	public String addTagTransaction(@RequestBody TagTransactionTriggers tagTransactionTriggers) {
		producerService.add(tagTransactionTriggers);
		return "Added Topic to Kafka Server Successfully";
	}

}
