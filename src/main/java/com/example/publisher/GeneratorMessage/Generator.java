package com.example.publisher.GeneratorMessage;

import com.example.publisher.Message.Message;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Generator {
    private static AtomicInteger id = new AtomicInteger(0);

    public synchronized static Message generateMessage() {
        return new Message(id.incrementAndGet(), getMsisdn(), Action.getRandomAction(), getTimestamp());
    }

    private static Integer getMsisdn() {
        return 100000000 + new Random().nextInt(900000000);
    }

    private static Long getTimestamp() {
        return new Timestamp(new Date().getTime()).getTime();
    }
}
