package com.wellsfargo.microservice.app.kafka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.wellsfargo.microservice.app.service.SmsService;

@Component
public class KafkaConsumerPaymentAlert {

	@Autowired
	private SmsService smsService;

	@KafkaListener(topics = "payment")
	public void sendSms(String data) {
		smsService.sendSms(data);

	}

}
