package org.stephenflavin.servlet;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.stephenflavin.service.GreetingService;
import org.apache.avro.ipc.specific.SpecificResponder;
import org.springframework.stereotype.Component;
import org.stephenflavin.Greetings;

@Component
public class GreetingsResponderServlet extends ConfiguredResponderServlet {

    public GreetingsResponderServlet(@Value("${avro.rpc.greetings.path:/greetings}") String path,
                                     GreetingService greetingService) throws IOException {
        super(new SpecificResponder(Greetings.class, greetingService), path);
    }
}
