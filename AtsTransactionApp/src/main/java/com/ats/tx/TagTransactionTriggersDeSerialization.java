package com.ats.tx;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TagTransactionTriggersDeSerialization implements Deserializer<TagTransactionTriggers>{

	@Override
	public TagTransactionTriggers deserialize(String topic, byte[] data) {
		ObjectMapper mapper = new ObjectMapper();
		TagTransactionTriggers txTriggers = null;
		 try {
			 txTriggers = mapper.readValue(data, TagTransactionTriggers.class);
		 } catch (Exception e) {
		 
		 e.printStackTrace();
		 }
		 return txTriggers;
	}

}
