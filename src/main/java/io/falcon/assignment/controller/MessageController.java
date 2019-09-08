package io.falcon.assignment.controller;

import io.falcon.assignment.model.Message;
import io.falcon.assignment.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MessageController {


    @Autowired
    private MessageService messageService;


    @PostMapping("/message")
    public ResponseEntity postMessage (@Valid @RequestBody Message message) {
        System.out.println(message.getContent());
        return new ResponseEntity<>(message, HttpStatus.OK);
    }


}

