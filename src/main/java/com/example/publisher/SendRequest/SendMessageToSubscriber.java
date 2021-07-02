package com.example.publisher.SendRequest;

import com.example.publisher.GeneratorMessage.Generator;
import com.example.publisher.Message.Message;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class SendMessageToSubscriber {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    ScheduledExecutorService threadPool;
    private static final String URL = "http://localhost:9090/api/subscriber";

    @SneakyThrows
    public void job(String status) {
        for (int i = 0; i < 5; i++) {
            thread(1L, 15L);
        }
        if(status.equals("stop")) {
            threadPool.shutdown();
            return;
        }
        Thread.sleep(Integer.MAX_VALUE);
    }

    private void thread(Long initialDelay, Long delay) {
        threadPool.scheduleAtFixedRate(() -> restTemplate.postForEntity(URL, Generator.generateMessage()
                , Message.class), initialDelay, delay, TimeUnit.SECONDS);
    }
}
