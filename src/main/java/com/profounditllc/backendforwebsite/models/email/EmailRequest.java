package com.profounditllc.backendforwebsite.models.email;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmailRequest {

	private String to;
	private String subject;
	private String messageText;
	private MultipartFile document;
	
}
