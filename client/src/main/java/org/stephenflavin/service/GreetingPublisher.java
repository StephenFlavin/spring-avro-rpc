package org.stephenflavin.service;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.stephenflavin.Greeting;
import org.stephenflavin.Greetings;

@Component
public class GreetingPublisher {
    private static final Logger logger = LoggerFactory.getLogger(GreetingPublisher.class);

    private static final Queue<String> NEW_GREETINGS = Stream.of("Sawubona", "Merhaba", "talofa", "Olá", "Buna ziua", "你好", "こんにちは", "Привет")
            .collect(Collectors.toCollection(ConcurrentLinkedQueue::new));

    private final Greetings Greetings;

    public GreetingPublisher(Greetings Greetings) {
        this.Greetings = Greetings;
    }

    @Scheduled(fixedDelay = 1000)
    public void addGreeting() {
        if (NEW_GREETINGS.isEmpty()) {
            logger.debug("No new greetings to publish.");
            return;
        }
        Greetings.addGreeting(Greeting.newBuilder().setText(NEW_GREETINGS.remove()).build());
    }
}
