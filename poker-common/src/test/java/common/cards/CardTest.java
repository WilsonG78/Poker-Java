package common.cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CardTest {

    @Test
    void testCardCreationAndGetters() {
        Card card = new Card(Suit.HEARTS, Rank.ACE);
        assertEquals(Suit.HEARTS, card.getSuit());
        assertEquals(Rank.ACE, card.getRank());
    }

    @Test
    void testEqualsAndHashCode() {
        Card card1 = new Card(Suit.HEARTS, Rank.ACE);
        Card card2 = new Card(Suit.HEARTS, Rank.ACE);
        Card card3 = new Card(Suit.DIAMONDS, Rank.ACE);
        Card card4 = new Card(Suit.HEARTS, Rank.KING);

        assertEquals(card1, card2);
        assertEquals(card1.hashCode(), card2.hashCode());

        assertNotEquals(card1, card3);
        assertNotEquals(card1.hashCode(), card3.hashCode()); // Not strictly required, but good practice
        assertNotEquals(card1, card4);
        assertNotEquals(card1.hashCode(), card4.hashCode()); // Not strictly required, but good practice

        assertNotEquals(card1, null);
        assertNotEquals(card1, "not a card");
    }

    @Test
    void testToString() {
        Card card = new Card(Suit.SPADES, Rank.KING);
        // Records automatically generate a toString method
        assertEquals("Card[suit=S, rank=K]", card.toString());
    }
}
