package com.profounditllc.backendforwebsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.profounditllc.backendforwebsite.models.communication.ServerResponse;
import com.profounditllc.backendforwebsite.models.email.EmailRequest;
import com.profounditllc.backendforwebsite.services.EmailService;

@RestController
public class EmailController {

	EmailService emailService;

	@Autowired
	public EmailController(EmailService emailService) {
		this.emailService = emailService;
	}

//	send attachments - read
//	https://howtodoinjava.com/spring-boot2/send-email-with-attachment/

	@PostMapping("/sendSimpleMail")
	public ResponseEntity<ServerResponse> sendSimpleMail(@RequestBody EmailRequest emailRequest) {
		this.emailService.sendSimpleMail("ashish.25jl@gmail.com", "Test Spring Boot Mailer",
				"Hello from Profound IT LLC Careers.");
		return new ResponseEntity<>(new ServerResponse("Things look fine", "Object content"), HttpStatus.OK);
	}

	@PostMapping("/sendMailWithAttachments")
	public ResponseEntity<ServerResponse> sendMailWithAttachments(@RequestBody EmailRequest emailRequest) {
		this.emailService.sendSimpleMail("ashish.25jl@gmail.com", "Test Spring Boot Mailer",
				"Hello from Profound IT LLC Careers.");
		return new ResponseEntity<>(new ServerResponse("Things look fine", "Object content"), HttpStatus.OK);
	}
}
