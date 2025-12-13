package common.cards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeckTest {
    private Deck deck;

    @BeforeEach
    void newDeck(){
        this.deck = new Deck();
    }

    @Test
    void newDeckShouldHave52Cards(){
        assertEquals(52,deck.size());
    }

    @Test
    void checkSizeAfterDealing(){
        deck.dealCard();
        assertEquals(51,deck.size());
    }

    @Test
    void sizeAfterReset(){
        deck.dealCard();
        deck.dealCard();
        deck.resetDeck();
        assertEquals(52,deck.size());
    }
}
