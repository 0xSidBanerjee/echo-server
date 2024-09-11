package org.acdc;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class EchoServerApplication {
    @Parameter(names= {"--port", "-p"})
    int port = 1234;

    public static void main(String[] args) throws IOException {
        EchoServerApplication app = new EchoServerApplication();

        JCommander commander = JCommander
                .newBuilder() //This is a design pattern; blueprint for solving broader problems
                .addObject(app)
                .build();

        commander.parse(args);
        app.run();
    }

    private void run() throws IOException {
        log.info("Starting echo server on port {}", port);

        EchoServer server = new EchoServer(this.port);
        server.start();
    }
}

//debug => All message
//warn => error, info, warning
//info => error, info