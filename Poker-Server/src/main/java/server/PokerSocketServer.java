package server;

import common.players.PlayerId;
import common.protocol.ServerActions;
import common.protocol.client.commands.HelloCommand;
import common.protocol.server.commands.OkCommand;
import lombok.extern.slf4j.Slf4j;
import model.GameContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class PokerSocketServer {

    private final int port;
    private final int version = 1;
    private final ExecutorService virtualThreadExecutor = Executors.newVirtualThreadPerTaskExecutor();
    private ServerSocket serverSocket;
    private int numberOfClients;
    private  Map<Socket,PlayerId> socketPlayerIdMap;
    private final GameContext gameContext = new GameContext();

    public PokerSocketServer(int port) {
        this.port = port;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            log.info("Poker server started on port " + port);
            while (!serverSocket.isClosed()) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    virtualThreadExecutor.submit(() -> handleClient(clientSocket));
                } catch (IOException e) {
                    if (serverSocket.isClosed()) {
                        log.info("Server socket closed, stopping.");
                    } else {
                        log.error("Error accepting client connection", e);
                    }
                }
            }
        } catch (IOException e) {
            log.error("Could not start server on port " + port, e);
        } finally {
            shutdown();
        }
    }

    private void handleClient(Socket clientSocket) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

            clientSocket.setSoTimeout(45000); // 45s timeout


            String message = reader.readLine();

            HelloCommand helloCommand = new HelloCommand();
            helloCommand.parseFromString(message);
            if(helloCommand.getVersion() == 1){
                createNewPlayer(clientSocket);
            }





        } catch (IOException e) {
            log.warn("Client disconnected or error: " + e.getMessage());
        } catch (SecurityException se) {
            log.warn("Security violation: " + se.getMessage());
        }
    }

    public void createNewPlayer(Socket clientSocket){
        OkCommand cmd = new OkCommand(ServerActions.OK,"ADDED TO SERVER");
        PlayerId newPlayerId = new PlayerId(numberOfClients);
        numberOfClients++;
        socketPlayerIdMap.put(clientSocket,newPlayerId);
    }

    public void shutdown() {
        log.info("Shutting down server.");
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (IOException e) {
            log.error("Error closing server socket", e);
        }
        virtualThreadExecutor.shutdown();
        try {
            if (!virtualThreadExecutor.awaitTermination(5, TimeUnit.SECONDS)) {
                virtualThreadExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            virtualThreadExecutor.shutdownNow();
        }
    }

    public static void main(String[] args) {
        PokerSocketServer server = new PokerSocketServer(7777);
        server.start();
    }
}
