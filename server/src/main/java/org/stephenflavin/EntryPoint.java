package org.stephenflavin;

import org.mortbay.jetty.Server;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class EntryPoint implements SmartLifecycle {

    private final Server server;

    public EntryPoint(Server server) {
        this.server = server;
    }

    @Override
    public void start() {
        try {
            server.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void stop() {
        if (isRunning()) {
            try {
                server.stop();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public boolean isRunning() {
        return server != null && server.isRunning();
    }

    @Override
    public int getPhase() {
        return 0;
    }
}
