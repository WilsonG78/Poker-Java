package common.game;

import common.cards.Card;

import java.util.List;

public class HandRank implements Comparable<HandRank>{
    private final PokerRank rank;
    private final List<Card> kickers;

    public HandRank(PokerRank rank, List<Card> kickers) {
        this.rank = rank;
        this.kickers = kickers;
    }

    @Override
    public int compareTo(HandRank other) {

        int rankComparison = Integer.compare(this.rank.getValue(), other.rank.getValue());
        if (rankComparison != 0) {
            return rankComparison;
        }

        // 2. Jeśli układy są te same, porównuj kickery po kolei
        for (int i = 0; i < Math.min(this.kickers.size(), other.kickers.size()); i++) {
            int thisCardVal = this.kickers.get(i).getRank().getValue();
            int otherCardVal = other.kickers.get(i).getRank().getValue();
            if (thisCardVal != otherCardVal) {
                return Integer.compare(thisCardVal, otherCardVal);
            }
        }
        return 0; // Idealny remis (split pot)
    }
}
