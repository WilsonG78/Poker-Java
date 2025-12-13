package server;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PokerSocketServerTest {

    private static final String HOST = "localhost";
    private static final int PORT = 7777;

    @Test
    void testEchoFromServer() {
        try (Socket socket = new Socket(HOST, PORT);
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            // Wiadomość testowa
            String messageToSend = "Hello Server!";
            writer.println(messageToSend);

            // Odbiór odpowiedzi
            String response = reader.readLine();

            // Sprawdzenie czy odpowiedź nie jest null
            assertNotNull(response, "Server did not respond");

            // Sprawdzenie czy echo jest poprawne
            assertEquals("Echo: " + messageToSend, response, "Server echo does not match");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
