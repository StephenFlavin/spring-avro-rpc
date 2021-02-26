package org.stephenflavin.service;

import org.stephenflavin.repository.GreetingRepository;
import org.stephenflavin.Greeting;
import org.stephenflavin.Greetings;
import org.springframework.stereotype.Service;

@Service
public class GreetingService implements Greetings {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public Greeting getGreeting() {
        return Greeting.newBuilder()
                .setText(greetingRepository.getRandomGreeting())
                .build();
    }
}
