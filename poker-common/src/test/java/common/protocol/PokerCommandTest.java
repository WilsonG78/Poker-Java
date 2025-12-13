package common.protocol;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class PokerCommandTest {


    @Test
    public void testToProtocolString(){
        Map testMap = new HashMap<>();
        testMap.put("test","test");
        PokerCommandFactory cmd = new PokerCommandFactory("0","12","32",testMap);

    }
}
