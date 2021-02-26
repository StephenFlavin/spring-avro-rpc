package org.stephenflavin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.stephenflavin.Greetings;

@Component
public class GreetingProcessor {
    private static final Logger logger = LoggerFactory.getLogger(GreetingProcessor.class);

    private final Greetings Greetings;

    public GreetingProcessor(Greetings Greetings) {
        this.Greetings = Greetings;
    }

    @Scheduled(fixedDelay = 1000)
    public void getGreeting() {
        logger.info("Got Greeting: {}", Greetings.getGreeting().getText());
    }
}
