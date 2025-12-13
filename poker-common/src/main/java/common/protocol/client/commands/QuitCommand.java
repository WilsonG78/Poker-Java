package common.protocol.client.commands;

import common.players.PlayerId;
import common.protocol.ClientActions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuitCommand implements ClientCommand {
    private PlayerId playerId;
    private ClientActions action;

    @Override
    public boolean parseFromString(String input) {
        List<String> tokens = Arrays.asList(input.split(" "));
        if (tokens.size() != 2) {
            throw new IllegalArgumentException("Invalid QUIT command format. Expected: <playerId> QUIT");
        }
        PlayerId newPlayerId = PlayerId.fromString(tokens.get(0));
        ClientActions newAction = ClientActions.fromString(tokens.get(1));
        setPlayerId(newPlayerId);
        setAction(newAction);
        return true;
    }

    @Override
    public String toReadableString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(playerId);
        stringBuilder.append(" ");
        stringBuilder.append(action);
        stringBuilder.append(" [");
        stringBuilder.append("QUIT");
        stringBuilder.append(" ");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
