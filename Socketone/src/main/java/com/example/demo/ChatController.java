package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private MessageRepository messageRepository;
    
    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public Message receiveMessage(@Payload Message message){
    	messageRepository.save(message);
    	System.out.println(message);
        return message;
    }

    @MessageMapping("/private-message")
    public Message recMessage(@Payload Message message){
    	messageRepository.save(message);
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/private","You have a new message" + messageRepository.getunreadcount(message.getSenderName(),message.getReceiverName()));
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/private",message);
    	
        return message;
    }
    
    @MessageMapping("/update")
    public Message updateMessage(@Payload Message message){
    	System.out.println("receiver "+message.getReceiverName()+" sender "+message.getSenderName());
    	messageRepository.updateseend(message.getSenderName(),message.getReceiverName());
        return message;
    }
}