package common.game;

import lombok.Data;

@Data
public class GameConfig {
    /**
     * ante is obligatory money each player has to bet at the begining of the new round
     * fixedBet*/
    private int ante;
    private int fixedBet;
    private int MaxDraw ;
    private int deckSeed;
}
