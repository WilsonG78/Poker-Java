package common.protocol.client.commands;

import common.protocol.ClientActions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelloCommand implements ClientCommand {
    private final ClientActions action = ClientActions.HELLO;
    private int version;
    @Override
    public boolean parseFromString(String input) {
        try {
            input = input.trim();
            int open = input.indexOf('[');
            int close = input.lastIndexOf(']');
            String header = input.substring(0, open).trim();
            String paramsPart = input.substring(open + 1, close).trim();
            if (open == -1 || close == -1 || close < open) {
                throw new IllegalArgumentException("Invalid format: missing [ ]");
            }
            String[] headerTokens = header.split("\\s+");
            if (headerTokens.length != 1) {
                throw new IllegalArgumentException("Invalid header format");
            }

            ClientActions newAction =  ClientActions.fromString(headerTokens[0]);
            if(!newAction.equals(action)){
                return false;
            }

            String[] pairs = paramsPart.split("\\s+");
            String[] kv = pairs[0].split("=", 2);
            setVersion(Integer.parseInt(kv[1]));
            return true;
        }
        catch (Exception ignored){

        }
        return false;
    }

    @Override
    public String toReadableString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(action);
        stringBuilder.append(" [");
        stringBuilder.append("VERSION");
        stringBuilder.append("=");
        stringBuilder.append(version);
        stringBuilder.append("]");
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
