package com.wellsfargo.payment.app.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerPaymentAlert {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Value("${payment.alert.topic}")
	private String kafkaTopic;

	public void send(String message) {

		kafkaTemplate.send(kafkaTopic, message);
	}

}
