package com.profounditllc.backendforwebsite.controllers;

import com.profounditllc.backendforwebsite.models.communication.ServerResponse;
import com.profounditllc.backendforwebsite.services.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

	EmailService emailService;
	
	@Autowired
	public EmailController(EmailService emailService) {
		this.emailService = emailService;
	}
	
    @GetMapping("/checksanity")
    public ResponseEntity<ServerResponse> checkSanity() {
    	this.emailService.sendSimpleMessage("ashish.25jl@gmail.com", "Test Spring Boot Mailer", "Hello from Profound IT LLC Careers.");
        return new ResponseEntity<>(new ServerResponse("Things look fine", "Object content"), HttpStatus.OK);
    }
}
