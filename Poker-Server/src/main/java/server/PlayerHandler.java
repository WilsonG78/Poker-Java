package server;

import common.protocol.ClientActions;
import common.protocol.ClientStatus;
import common.protocol.ServerActions;
import lombok.extern.slf4j.Slf4j;
import model.GameContext;
import server.CommandParser.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@Slf4j
public class PlayerHandler implements Runnable {

    private final PlayerContext playerContext;
    private final GameContext gameContext;

    public PlayerHandler(PlayerContext playerContext, GameContext gameContext) {
        this.playerContext = playerContext;
        this.gameContext = gameContext;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(playerContext.getSocket().getInputStream()));
             PrintWriter writer = new PrintWriter(playerContext.getSocket().getOutputStream(), true)) {

            String line;
            while (playerContext.isConnected() && (line = reader.readLine()) != null) {
                try {
                    Command command = CommandParser.parse(line);
                    playerContext.setLastMessageTime(System.currentTimeMillis());

                    switch (command.getAction()) {
                        case PING:
                            writer.println(ServerActions.PONG.getValue() + " " + ClientStatus.ACTIVE.name());
                            break;
                        // Add other command handling logic here
                        default:
                            writer.println(ServerActions.ERR.getValue() + " Unknown or unsupported command: " + command.getAction());
                            break;
                    }
                } catch (IllegalArgumentException e) {
                    writer.println(ServerActions.ERR.getValue() + " " + e.getMessage());
                }
            }
        } catch (IOException e) {
            log.warn("Player " + playerContext.getPlayerId() + " disconnected: " + e.getMessage());
        } finally {
            playerContext.setConnected(false);
            // Any other cleanup for the player
        }
    }
}