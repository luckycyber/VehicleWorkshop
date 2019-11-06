package com.chika.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class Email {
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail() {
		SimpleMailMessage msg = new SimpleMailMessage();		
		msg.setTo("phuccong44@gmail.com", "lekongfuc@yahoo.com");
		msg.setSubject("Testing from Spring Boot");
		msg.setText("welcome to Spring Boot Simple Email");
		javaMailSender.send(msg);		
	}
}
