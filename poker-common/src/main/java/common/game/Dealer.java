package common.game;

import common.cards.Card;
import common.cards.Deck;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Dealer {
    private Deck deck;


    public List<Card> deal(int numberOfCards){
        deck.shuffle();
        List<Card> list = new ArrayList<>();
        for (int i =0; i<numberOfCards;i++){
            list.add(deck.dealCard());
        }
        return list;
    }

    public List<Card> changeCard(List<Card> cards){
        deck.shuffle();
        List<Card> list = new ArrayList<>();
        for (int i =0; i<cards.size();i++){
            list.add(deck.dealCard());
        }
        for (Card c : cards){
            deck.addCardToDeck(c);
        }
        return list;
    }
}
