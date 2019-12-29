package com.ats.toll;

import org.apache.kafka.common.serialization.Serializer;

import com.ats.toll.model.TagTransactionTriggers;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TagTxTriggersSerialization implements Serializer<TagTransactionTriggers> {

	@Override
	public byte[] serialize(String topic, TagTransactionTriggers txTrigger) {
		byte[] serializedBytes = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			serializedBytes = objectMapper.writeValueAsString(txTrigger).getBytes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serializedBytes;
	}

}
