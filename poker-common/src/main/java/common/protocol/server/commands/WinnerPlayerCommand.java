package common.protocol.server.commands;

import common.game.GameId;
import common.players.PlayerId;
import common.protocol.ServerActions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WinnerPlayerCommand implements ServerCommand {
    private GameId gameId;
    private PlayerId playerId;
    private ServerActions action;
    private PlayerId winnerPlayerId;
    private int amount;

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

        Map<String, String> params = new HashMap<>();
        String[] pairs = paramsPart.split("\\s+");
        for (String pair : pairs) {
            String[] kv = pair.split("=", 2);
            params.put(kv[0], kv[1]);
        }

        if (params.containsKey("PLAYER")) {
            setWinnerPlayerId(PlayerId.fromString(params.get("PLAYER")));
        }
        if (params.containsKey("AMOUNT")) {
            setAmount(Integer.parseInt(params.get("AMOUNT")));
        }
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
        stringBuilder.append("PLAYER=");
        stringBuilder.append(winnerPlayerId);
        stringBuilder.append(" AMOUNT=");
        stringBuilder.append(amount);
        stringBuilder.append("]");
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
