package common.protocol.client.commands;

import common.game.GameId;
import common.players.PlayerId;
import common.protocol.ClientActions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoldCommand implements ClientCommand {
    private GameId gameId;
    private PlayerId playerId;
    private ClientActions action;

    @Override
    public boolean parseFromString(String input) {
        input = input.trim();
        int open = input.indexOf('[');
        int close = input.lastIndexOf(']');
        String header = input.substring(0, open).trim();
        String paramsPart = input.substring(open + 1, close).trim();
        if (open == -1 || close == -1 || close < open) {
            throw new IllegalArgumentException("Invalid format: missing [ ]");
        }
        String[] headerTokens = header.split("\\s+");
        if (headerTokens.length != 3) {
            throw new IllegalArgumentException("Invalid header format");
        }

        setGameId(GameId.fromString(headerTokens[0]));
        setPlayerId(PlayerId.fromString(headerTokens[1]));
        setAction(ClientActions.fromString(headerTokens[2]));
        return true;
    }

    @Override
    public String toReadableString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(gameId);
        stringBuilder.append(" ");
        stringBuilder.append(playerId);
        stringBuilder.append(" ");
        stringBuilder.append(action);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
