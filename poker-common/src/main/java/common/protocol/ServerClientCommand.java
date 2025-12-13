package common.protocol;

import common.game.GameId;
import common.players.PlayerId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServerClientCommand implements PokerCommandFactory{
    private GameId gameId;
    private PlayerId playerId;
    private ServerActions action;
    private Map<String,String> params;

    public String toReadableString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(gameId);
        stringBuilder.append(" ");
        stringBuilder.append(playerId);
        stringBuilder.append(" ");
        stringBuilder.append(action);
        stringBuilder.append(" [");
        for (String s : params.keySet()){
            stringBuilder.append(s);
            stringBuilder.append("=");
            stringBuilder.append(params.get(s));
            stringBuilder.append(" ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public ServerClientCommand parserFromString(String input){
        ServerClientCommand cmd = new ServerClientCommand();
        int bracketStart = input.indexOf('[');
        int bracketEnd = input.indexOf(']');

        if (bracketStart == -1 || bracketEnd == -1 || bracketEnd < bracketStart) {
            throw new IllegalArgumentException("Invalid protocol format: missing brackets");
        }

        String mainPart = input.substring(0, bracketStart).trim();
        String paramsPart = input.substring(bracketStart + 1, bracketEnd).trim();


        String[] mainTokens = mainPart.split("\\s+");
        if (mainTokens.length < 3) {
            throw new IllegalArgumentException("Invalid protocol format: missing main tokens");
        }
        GameId newGameId = GameId.fromString(mainTokens[0]);
        PlayerId newPlayerId = PlayerId.fromString(mainTokens[1]);
        ServerActions newAction = ServerActions.fromString(mainTokens[3]);
        cmd.setGameId(newGameId);
        cmd.setPlayerId(newPlayerId);
        cmd.setAction(newAction);


        if (!paramsPart.isEmpty()) {
            String[] paramTokens = paramsPart.split("\\s+");
            for (String token : paramTokens) {
                String[] keyValue = token.split("=", 2);
                if (keyValue.length == 2) {
                    cmd.getParams().put(keyValue[0], keyValue[1]);
                } else {
                    throw new IllegalArgumentException("Invalid parameter: " + token);
                }
            }
        }

        return cmd;
    }

}
