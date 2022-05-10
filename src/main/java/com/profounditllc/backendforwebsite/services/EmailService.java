package com.profounditllc.backendforwebsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;

	public void sendSimpleMail(String to, String subject, String messageText) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("careers@profounditllc.com");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(messageText);
		emailSender.send(message);
	}

	public void sendMailWithAttachment(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("careers@profounditllc.com");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}

}
