package com.lax.springjwt.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lax.springjwt.models.Message;
import com.lax.springjwt.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageRepository messageRepo;

	@Override
	public void saveMessage(Message message) {
		messageRepo.save(message);
	}

}
