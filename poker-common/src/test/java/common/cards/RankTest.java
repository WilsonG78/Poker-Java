package common.cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankTest {

    @Test
    public void testGetValue(){
        Rank rank = Rank.TWO;
        assertEquals(2,rank.getValue());
    }
}
