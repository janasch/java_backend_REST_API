package io.falcon.assignment.controller;


import io.falcon.assignment.model.Message;
import io.falcon.assignment.persistence.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class MessageController {

    @Autowired
    MessageRepository repository;


    @MessageMapping("/messages")
    @SendTo("/topic/reply")
    public Message greeting(Message message) throws Exception {
        repository.save(message);
        return message;
    }

    @GetMapping("/messages")
    public List<Message> findAll() {
        List<Message> messages = repository.findAll();
        return messages;

    }


}