package common.protocol.client.commands;

import common.protocol.ClientActions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommand implements ClientCommand {
    private ClientActions action;
    private int ante;
    private int bet;
    private boolean fixed;
    /**
     * Create looks like this CREATE [ANTE=<n> BET=<n> LIMIT=FIXED/NONFIXED
     * */
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
        setAction(ClientActions.fromString(headerTokens[0]));
        String[] pairs = paramsPart.split("\\s+");
        ante = Integer.parseInt(pairs[0].split("=", 2)[1]);
        bet = Integer.parseInt(pairs[1].split("=", 2)[1]);
        if ("FIXED".equals(pairs[2].split("=", 2)[1])){
            fixed=true;
        }
        else{
            fixed=false;
        }
        return true;
    }

    @Override
    public String toReadableString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(action);
        stringBuilder.append(" [");
        stringBuilder.append("ANTE=");
        stringBuilder.append(ante);
        stringBuilder.append(" ");
        stringBuilder.append("BET=");
        stringBuilder.append(bet);
        stringBuilder.append(" ");
        stringBuilder.append("LIMIT=");
        if (fixed){
            stringBuilder.append("FIXED");
        }
        else{
            stringBuilder.append("NONFIXED");
        }
        stringBuilder.append("]");
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
