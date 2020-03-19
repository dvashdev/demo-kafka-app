package commit.kafka.controller;

import commit.kafka.consumer.Receiver;
import commit.kafka.dto.ChattingMessage;
import commit.kafka.producer.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ChattingController {
    @Autowired
    Receiver receiver;
    @Autowired
    Sender sender;

    @MessageMapping("/message")
    public void sendMessage(ChattingMessage message) {
        sender.send("chatting", message.getMessage() + "|" + message.getUser());
    }
}
