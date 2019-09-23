package io.falcon.assignment.controller;


import io.falcon.assignment.model.Message;
import io.falcon.assignment.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class MessageController {


    private MessageService messageService;

    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }



    @MessageMapping("/messages")
    @SendTo("/topic/reply")
    public Message messageWord(Message message) {
        messageService.saveMessage(message);
        return message;
    }

    @GetMapping("/messages")
    public List<Message> findAll() {
        List<Message> messages = messageService.findAll();
        return messages;

    }


}