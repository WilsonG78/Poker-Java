package common.game;

import common.cards.Card;
import java.util.List;

public interface HandEvaluator {
    public HandRank evaluate(List<Card> cards);
}
