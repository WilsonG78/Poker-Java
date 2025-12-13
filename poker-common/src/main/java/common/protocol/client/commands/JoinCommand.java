package common.protocol.client.commands;

import common.game.GameId;
import common.protocol.ClientActions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * JOIN [GAMEID=<gameId> NAME=<nick>]
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoinCommand implements ClientCommand {
    private ClientActions action;
    private GameId gameId;
    private String name;


    @Override
    public boolean parseFromString(String input) {
        input = input.trim();
        int open = input.indexOf('[');
        int close = input.lastIndexOf(']');
        String header = input.substring(0, open).trim();
        String paramsPart = input.substring(open + 1, close).trim();

        String[] headerTokens = header.split("\\s+");

        setAction(ClientActions.fromString(headerTokens[0]));

        String[] pairs = paramsPart.split("\\s+");
        setGameId(GameId.fromString(pairs[0].split("=", 2)[1]));
        name = pairs[1].split("=", 2)[1];
        return true;
    }

    @Override
    public String toReadableString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(action);
        stringBuilder.append(" ");
        stringBuilder.append(" [");
        stringBuilder.append("GAMEID=");
        stringBuilder.append(gameId);
        stringBuilder.append(" ");
        stringBuilder.append("name=");
        stringBuilder.append(name);
        stringBuilder.append("]");
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
