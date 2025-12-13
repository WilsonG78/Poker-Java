package common.cards;

import common.exceptions.IllegalCardInDeckException;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Deck {
    private final List<Card> cards = new ArrayList<>();
    private SecureRandom secureRandom;
    private int seed;

    public Deck(int seed) {
        addCardsToDeck(cards);
        this.seed = seed;
        byte[] seedByte = SecureRandom.getSeed(seed);
        secureRandom = new SecureRandom(seedByte);
    }

    private void addCardsToDeck(List<Card> list){
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                list.add(new Card(suit, rank));
            }
        }
        shuffle();
    }

    //ADD SEED TO SECURE RANDOM
    public void shuffle() {
        Collections.shuffle(this.cards, new SecureRandom());
    }


    public Card dealCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Talia jest pusta!");
        }
        return cards.remove(cards.size()-1);
    }

    public void addCardToDeck(Card card){
        if (cards.contains(card)){
            throw new IllegalCardInDeckException("Card which shouldn't be in deck is in the deck");
        }
        cards.add(card);
    }

    protected int size() {
        return cards.size();
    }

    protected void resetDeck(){
        cards.clear();
        addCardsToDeck(cards);
    }
}

