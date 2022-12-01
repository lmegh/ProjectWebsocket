package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
	
	 @Autowired
	    private SimpMessagingTemplate simpMessagingTemplate;
	 
	 @MessageMapping("/hello")
	  @SendTo("/user/greeting")
	  public Greeting greetings(HelloMessage message) throws Exception {
	    Thread.sleep(1000); // simulated delay
	    return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	  }
	 
	  @MessageMapping("/private")
	  public String greeting(Message message) throws Exception {
	    Thread.sleep(1000); // simulated delay
        simpMessagingTemplate.convertAndSendToUser(message.getSenderName(),"/greeting", message.getSenderName());
	    return message.getMessage();
	  }
}
