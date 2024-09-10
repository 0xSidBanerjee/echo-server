package org.acdc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Getter
@Setter
@AllArgsConstructor
@Slf4j
public class EchoServer {
    private int port;
    public void start() throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(port)){
            log.info("Starting echo server on port {}", port);
            Socket clientSocket = serverSocket.accept();
            log.info("Client connection established");
        } catch (IOException e){
            log.error(e.getMessage());
        }

    }
}
