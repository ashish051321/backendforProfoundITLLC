package com.profounditllc.backendforwebsite.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.profounditllc.backendforwebsite.models.communication.ServerResponse;
import com.profounditllc.backendforwebsite.models.email.EmailRequest;
import com.profounditllc.backendforwebsite.services.EmailService;

@RestController
public class EmailController {

	private EmailService emailService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

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

	@PostMapping(value = "/sendMailWithAttachments", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<ServerResponse> sendMailWithAttachments(@RequestPart("mailRequest") String emailRequestText,
			@RequestPart("file") List<MultipartFile> files) throws JsonMappingException, JsonProcessingException {

		// Converting jsonString to object EmailRequest
		// Had to use String as @RequestPart usage for accepting both a json and
		// multipartfile requires this.
		ObjectMapper objectMapper = new ObjectMapper();
		EmailRequest emailRequest = objectMapper.readValue(emailRequestText, EmailRequest.class);

		int fileCount = files.size();
		logger.info("number of files received: {}", files.size());
		logger.info("Mail request received: {}", emailRequest);
		this.emailService.sendMailWithAttachment(emailRequest.getTo(), emailRequest.getSubject(),
				emailRequest.getMessageText(), files.get(0));
		return new ResponseEntity<>(new ServerResponse("Method call successful", null), HttpStatus.OK);

	}
}
