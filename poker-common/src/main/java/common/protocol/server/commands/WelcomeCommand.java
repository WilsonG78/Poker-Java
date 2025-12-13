package common.protocol.server.commands;

import common.game.GameId;
import common.players.PlayerId;
import common.protocol.ServerActions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WelcomeCommand implements ServerCommand {
    private GameId gameId;
    private PlayerId playerId;
    private ServerActions action;
    private String message;


    @Override
    public void parseFromString(String input) {
        input = input.trim();
        int open = input.indexOf('[');
        int close = input.lastIndexOf(']');
        String header = input.substring(0, open).trim();
        String paramsPart = input.substring(open + 1, close).trim();
        String[] headerTokens = header.split("\\s+");
        setGameId(GameId.fromString(headerTokens[0]));
        setPlayerId(PlayerId.fromString(headerTokens[1]));
        setAction(ServerActions.fromString(headerTokens[2]));


        String[] pairs = paramsPart.split("\\s+");
        String[] kv = pairs[0].split("=", 2);
        setMessage(kv[1]);
    }

    @Override
    public String toReadableString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(gameId);
        stringBuilder.append(" ");
        stringBuilder.append(playerId);
        stringBuilder.append(" ");
        stringBuilder.append(action);
        stringBuilder.append(" [");
        stringBuilder.append("MESSAGE=");
        stringBuilder.append(message);
        stringBuilder.append("]");
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
