package com.ats.toll.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.ats.toll.model.TagTransactionTriggers;


@Configuration
public class KafkaProducerConfig {
	@Bean
	public ProducerFactory<String, com.ats.toll.model.TagTransactionTriggers> producerFactory(){
		Map<String,Object> props = new HashMap<String,Object>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, com.ats.toll.util.KafkaConstants.HOST);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,com.ats.toll.TagTxTriggersSerialization.class);
		
		return new DefaultKafkaProducerFactory(props);
	}

	@Bean(name ="kafkaTemplate")
	public KafkaTemplate<String,TagTransactionTriggers>  kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}
}
