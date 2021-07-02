package com.example.publisher.Controller;

import com.example.publisher.SendRequest.SendMessageToSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {
    @Autowired
    private SendMessageToSubscriber sendMessageToSubscriber;

    @GetMapping(value = "/start")
    public void startSendMessage() {
        sendMessageToSubscriber.job("start");
    }

    @GetMapping(value = "/stop")
    public void stopSendMessage() {
        sendMessageToSubscriber.job("stop");
    }
}
