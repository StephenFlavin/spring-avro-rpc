package org.stephenflavin.servlet;

import java.io.IOException;

import org.apache.avro.ipc.Responder;
import org.apache.avro.ipc.ResponderServlet;

public abstract class ConfiguredResponderServlet extends ResponderServlet {

    private final String path;

    public ConfiguredResponderServlet(Responder responder,
                                      String path) throws IOException {
        super(responder);
        this.path = path;
    }

    public final String getPath() {
        return path;
    }
}
