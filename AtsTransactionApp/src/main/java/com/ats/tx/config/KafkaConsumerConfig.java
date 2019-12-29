package com.ats.tx.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.ats.tx.TagTransactionTriggers;
import com.ats.tx.until.KafkaConstants;

@Configuration
@EnableKafka
public class KafkaConsumerConfig { 
	
	@Bean
	public ConsumerFactory<String, TagTransactionTriggers> consumerFactory(){
		 Map<String,Object> props = new HashMap<String,Object>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.HOST);
		props.put(ConsumerConfig.GROUP_ID_CONFIG,KafkaConstants.GROUP_ID);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,com.ats.tx.TagTransactionTriggersDeSerialization.class);
		
		return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(TagTransactionTriggers.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, TagTransactionTriggers> kafkaListenerContainerFactory(){
		 ConcurrentKafkaListenerContainerFactory<String, TagTransactionTriggers> factory = new  ConcurrentKafkaListenerContainerFactory<String, TagTransactionTriggers>();
		 factory.setConsumerFactory(consumerFactory());
		
		return factory;
		
	}
}
