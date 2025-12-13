package common.cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SuitTest {


    @Test
    void testGetSymbol() {
        assertEquals("C", Suit.CLUBS.getSymbol());
        assertEquals("D", Suit.DIAMONDS.getSymbol());
        assertEquals("H", Suit.HEARTS.getSymbol());
        assertEquals("S", Suit.SPADES.getSymbol());
    }

    @Test
    void testFromString() {
        assertEquals(Suit.CLUBS, Suit.fromString("C"));
        assertEquals(Suit.DIAMONDS, Suit.fromString("D"));
        assertEquals(Suit.HEARTS, Suit.fromString("H"));
        assertEquals(Suit.SPADES, Suit.fromString("S"));
    }


    @Test
    void testFromStringInvalid() {
        assertThrows(IllegalArgumentException.class, () -> Suit.fromString("X"));
        assertThrows(IllegalArgumentException.class, () -> Suit.fromString("CLUBS"));
    }
}
