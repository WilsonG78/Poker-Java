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
public class CallCommand implements ClientCommand {
    private GameId gameId;
    private PlayerId playerId;
    private ClientActions action = ClientActions.CALL;

    @Override
    public boolean parseFromString(String input) {
        try {
            input = input.trim();
            int open = input.indexOf('[');
            int close = input.lastIndexOf(']');
            String header = input.trim();
            String[] headerTokens = header.split("\\s+");
            ClientActions newAction =  ClientActions.fromString(headerTokens[2]);
            if(!newAction.equals(action))
            setGameId(GameId.fromString(headerTokens[0]));
            setPlayerId(PlayerId.fromString(headerTokens[1]));

            return true;
        } catch (Exception e) {

        }
        return false;
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
