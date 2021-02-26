package org.stephenflavin.configuration;

import java.util.List;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.stephenflavin.servlet.ConfiguredResponderServlet;
import org.stephenflavin.servlet.PingServlet;

@Configuration
public class ServerConfig {

    @Bean
    public Server server(@Value("${avro.rpc.server.port:22222}") int port) {
        return new Server(port);
    }

    @Bean
    public Context test(Server server,
                        PingServlet pingServlet,
                        List<ConfiguredResponderServlet> responderServlets) {
        Context context = new Context(server, "/", Context.SESSIONS);
        context.addServlet(new ServletHolder(pingServlet), "/ping");
        responderServlets
                .forEach(servlet -> context.addServlet(new ServletHolder(servlet), servlet.getPath()));
        return context;
    }

}
