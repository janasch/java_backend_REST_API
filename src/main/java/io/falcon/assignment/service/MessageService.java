package io.falcon.assignment.service;

import io.falcon.assignment.model.Message;
import io.falcon.assignment.persistence.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;


    public void saveMessage(Message message){
        messageRepository.save(message);
    }

    public List<Message> findAll(){
        return messageRepository.findAll();
    }


}

