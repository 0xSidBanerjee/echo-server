package org.acdc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
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
            while (true) {
                Socket clientSocket = serverSocket.accept(); //This method is blocking
                log.info("Client connection established {}", clientSocket);
                // Read a line from client socket
                try (BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter outputWriter = new PrintWriter(clientSocket.getOutputStream(), true)) {
                    String request;
                    while ((request = input.readLine()) != null) {
                        log.info("Received: {}", request);
                        // Wrap the input line with RESP[<input-line>]
                        String response = String.format("RESP[%s]", request);
                        log.info("Sent: {}", response);
                        // Write the response to the client socket
                        outputWriter.println(response);
                    }
                }
            }
        } catch (IOException e){
            log.error(e.getMessage());
        }

    }
}
