package server;

import java.net.Socket;
import lombok.Data;

@Data
public class PlayerContext {
    private final String playerId;
    private final Socket socket;
    private boolean isConnected;
    private long lastMessageTime;

    public PlayerContext(String playerId, Socket socket) {
        this.playerId = playerId;
        this.socket = socket;
    }
}