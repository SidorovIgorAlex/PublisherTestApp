package com.example.publisher.GeneratorMessage;

import java.util.Random;

public enum Action {
    PURCHASE,
    SUBSCRIPTION;

    public static Action getRandomAction() {
        return values()[new Random().nextInt(values().length)];
    }
}
