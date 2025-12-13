package common.game;

import common.cards.Card;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class Hand {
    private List<Card> cards;
}
