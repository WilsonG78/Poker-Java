package common.protocol.server.commands;

import common.cards.Card;
import common.cards.Rank;
import common.cards.Suit;
import common.game.GameId;
import common.players.PlayerId;
import common.protocol.ServerActions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowDownCommand implements ServerCommand {
    private GameId gameId;
    private PlayerId playerId;
    private ServerActions action;
    private Map<PlayerId, List<Card>> hands;

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

        Map<PlayerId, List<Card>> handsMap = new HashMap<>();
        String[] pairs = paramsPart.split("\\s+");
        for (String pair : pairs) {
            String[] kv = pair.split("=", 2);
            PlayerId handPlayerId = PlayerId.fromString(kv[0]);
            List<Card> cardList = Arrays.stream(kv[1].split(","))
                    .map(cardString -> {
                        Rank rank = Rank.fromString(String.valueOf(cardString.charAt(0)));
                        Suit suit = Suit.fromString(String.valueOf(cardString.charAt(1)));
                        return new Card(suit, rank);
                    })
                    .collect(Collectors.toList());
            handsMap.put(handPlayerId, cardList);
        }
        setHands(handsMap);
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
        stringBuilder.append(hands.entrySet().stream()
                .map(entry -> entry.getKey().toString() + "=" + entry.getValue().stream()
                        .map(card -> "" + card.getRank().toString() + card.getSuit().getSymbol())
                        .collect(Collectors.joining(",")))
                .collect(Collectors.joining(" ")));
        stringBuilder.append("]");
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
