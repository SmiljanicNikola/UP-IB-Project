package com.example.UPIBProjekat.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.UPIBProjekat.model.User;
import com.example.UPIBProjekat.model.VerificationToken;

@Service
public class EmailService {

	private final VerificationTokenService verificationTokenService;
	private final JavaMailSender javaMailSender;
	
	@Autowired
	public EmailService(VerificationTokenService verificationTokenService, JavaMailSender javaMailSender) {
		super();
		this.verificationTokenService = verificationTokenService;
		this.javaMailSender = javaMailSender;
	}
	
	
	public void sendHtmlMail(User user) throws MessagingException{
		VerificationToken verificationToken = verificationTokenService.findByUser(user);
		if(verificationToken == null) {
			String token = verificationToken.getToken();
			String body = "http://localhost:8080/activation?token="+token;
			
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(user.getUsername());
			helper.setSubject("Email adress verification");
			helper.setText(body, true);
			javaMailSender.send(message);
			
		}
	}
	
	
}
