package com.example.pr4;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MessageController {

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public Message greeting(InputMessage message) throws Exception {
        String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        return new Message(time + " - " + HtmlUtils.htmlEscape(message.getMessage()));
    }
}
