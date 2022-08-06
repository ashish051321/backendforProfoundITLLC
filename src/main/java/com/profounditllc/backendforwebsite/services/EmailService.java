package com.profounditllc.backendforwebsite.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

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

	public void sendMailWithAttachment(String to, String subject, String text, MultipartFile file) {
		MimeMessage message = emailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom("careers@profounditllc.com");
			helper.setTo(to.split(","));
			helper.setSubject(subject);
			helper.setText(text);
			helper.addAttachment(file.getOriginalFilename(), file);

		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		emailSender.send(message);
	}

}
