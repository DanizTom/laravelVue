package com.lax.springjwt.security.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("emailService")
public interface EmailService {
	public void sendEmail(SimpleMailMessage email);
}
