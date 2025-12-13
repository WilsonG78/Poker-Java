package server;

import common.game.GameId;
import common.players.PlayerId;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.net.Socket;

@Data
@AllArgsConstructor
public class ClientData {
    Socket socket;
    GameId gameId;
    PlayerId playerId;
}
