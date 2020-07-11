package org.anonymous.buddychatter.controller;

import org.anonymous.buddychatter.domain.Message;
import org.anonymous.buddychatter.dto.AuthenticationDto;
import org.anonymous.buddychatter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/***
 *  @author developer
 *  @since December 31, 2019
 */

@RestController
public class PublicController {

    @RequestMapping("/api/v1/register")
    public String register() {
        return "index";
    }

    @Autowired
    private UserService userService;

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;


    @MessageMapping("/send")
    public void sendMsg(Message message) {
        System.out.println(message);
        simpMessagingTemplate.convertAndSend("/buddy-chatter/receive/" + message.getId(), message.getMsg());
    }

    //@Scheduled(fixedRate = 1000)
    public void hello() {
        simpMessagingTemplate.convertAndSend("/buddy-chatter/receive/" + 1, UUID.randomUUID().toString());
    }


    @PostMapping("/api/v1/login")
    public ResponseEntity<Object> authentication(@RequestBody AuthenticationDto authenticationDto) {
        return userService.authentication(authenticationDto);
    }

}

