package org.stephenflavin.config;

import java.io.IOException;
import java.net.URL;

import org.apache.avro.ipc.HttpTransceiver;
import org.apache.avro.ipc.specific.SpecificRequestor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.stephenflavin.Greetings;

@Configuration
public class AvroRpcConfig {

    @Bean
    public Greetings Greetings(@Value("${avro.rpc.greetings.uri:http://localhost:22222/greetings}") URL url) throws IOException {
        return SpecificRequestor.getClient(Greetings.class, new HttpTransceiver(url));
    }

}
