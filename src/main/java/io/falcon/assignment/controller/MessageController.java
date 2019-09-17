package io.falcon.assignment.controller;


import io.falcon.assignment.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {


    @MessageMapping("/hello")
    @SendTo("/topic/words")
    public Message greeting(Message message) throws Exception {
        //return new Message("So you wish to know the palindrome length of " + HtmlUtils.htmlEscape(message.getContent()) + "!");

        return message;
    }

}