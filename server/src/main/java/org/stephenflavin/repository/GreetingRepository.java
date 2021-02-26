package org.stephenflavin.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

@Component
public class GreetingRepository {

    private static final List<String> GREETINGS = Stream.of("hello",
            "aloha",
            "fàilte",
            "salut",
            "As-salaam 'alykum",
            "Hallo",
            "Hola",
            "Γεια",
            "G'day mate")
            .collect(Collectors.toCollection(ArrayList::new));

    public String getRandomGreeting() {
        Collections.shuffle(GREETINGS);
        return GREETINGS.get(0);
    }

    public void addGreeting(String greeting) {
        GREETINGS.add(greeting);
    }

}
