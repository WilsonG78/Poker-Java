package common.game;

import common.players.Player;
import common.exceptions.IllegalExceptionLostPlayerIsPlaying;

public class Pot {
    int currentPlayerPot;
    int maxPot;

    public Pot(Player player){
        currentPlayerPot = 0;
        maxPot =player.getChips();
    }
    public int giveAnte(int ante){
        if (maxPot - currentPlayerPot >= ante){
            currentPlayerPot += ante;
        }
        else{
            throw new IllegalExceptionLostPlayerIsPlaying("Player who don't have money for ante is playing");
        }
        return ante;
    }
}
