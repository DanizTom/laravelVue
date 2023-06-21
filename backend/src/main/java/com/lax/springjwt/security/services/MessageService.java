package com.lax.springjwt.security.services;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.lax.springjwt.models.Message;

@Service("messageService")
public interface MessageService {
	
	public void saveMessage(Message message);
	

}
