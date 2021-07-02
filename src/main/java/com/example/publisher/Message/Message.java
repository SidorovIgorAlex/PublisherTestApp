package com.example.publisher.Message;

import com.example.publisher.GeneratorMessage.Action;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private Integer id;
    private Integer msisdn;
    private Action action;
    private Long timestamp;
}
