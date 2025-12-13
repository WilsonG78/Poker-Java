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
public class BetCommand implements ClientCommand {
    private GameId gameId;
    private PlayerId playerId;
    private final ClientActions action = ClientActions.BET;
    private int amount;

    public boolean parseFromString(String input) {
        try {
            input = input.trim();
            int open = input.indexOf('[');
            int close = input.lastIndexOf(']');
            String header = input.substring(0, open).trim();
            String paramsPart = input.substring(open + 1, close).trim();
            String[] headerTokens = header.split("\\s+");
            ClientActions newAction =ClientActions.fromString(headerTokens[2]);
            if(!newAction.equals(action)){
                throw new IllegalArgumentException();
            }
            setGameId(GameId.fromString(headerTokens[0]));
            setPlayerId(PlayerId.fromString(headerTokens[1]));



            String[] pairs = paramsPart.split("\\s+");
            String[] kv = pairs[0].split("=", 2);
            setAmount(Integer.parseInt(kv[1]));
            return true;
        }catch (Exception e){}
        return false;
    }

    public String toReadableString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(gameId);
        stringBuilder.append(" ");
        stringBuilder.append(playerId);
        stringBuilder.append(" ");
        stringBuilder.append(action);
        stringBuilder.append(" [");
        stringBuilder.append("BET");
        stringBuilder.append("=");
        stringBuilder.append(amount);
        stringBuilder.append("]");
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

}