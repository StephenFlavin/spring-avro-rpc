package org.stephenflavin.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stephenflavin.repository.GreetingRepository;
import org.stephenflavin.Greeting;
import org.stephenflavin.Greetings;
import org.springframework.stereotype.Service;

@Service
public class GreetingService implements Greetings {
    private static final Logger logger = LoggerFactory.getLogger(GreetingService.class);

    private static final AtomicInteger GETS_COUNTER = new AtomicInteger();
    private static final AtomicInteger ADDS_COUNTER = new AtomicInteger();

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public Greeting getGreeting() {
        logger.info("Getting greeting: {}", GETS_COUNTER.incrementAndGet());
        return Greeting.newBuilder()
                .setText(greetingRepository.getRandomGreeting())
                .build();
    }

    @Override
    public void addGreeting(Greeting greeting) {
        logger.info("Adding greeting: {}, {}", ADDS_COUNTER.incrementAndGet(), greeting);
        greetingRepository.addGreeting(greeting.getText());
    }
}
