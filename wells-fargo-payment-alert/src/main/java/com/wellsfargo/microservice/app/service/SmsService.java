package com.wellsfargo.microservice.app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

	@Value("${twilio.trial.number}")
	private String trialNumber;

	public void sendSms(String data) {
		Message.creator(new PhoneNumber("+918109358283"), new PhoneNumber(trialNumber), data).create();
	}

}
