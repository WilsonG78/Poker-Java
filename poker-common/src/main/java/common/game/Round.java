package common.game;

import common.players.Player;

import java.util.List;



public class Round {
    private PotManager potManager;
    private Player playerOnMove;
    private int raisesCounter;
    private int ante;
    private List<Player> players;

    public void startRound(List<Player> playersInRound){
        for(Player p : playersInRound){
            p.setPot(new Pot(p));
        }

    }

    public void getAnte(){
        int currentBet = potManager.getCurrentBet();
        for (Player p : players){
            currentBet += p.getPot().giveAnte(ante);
        }
        potManager.setCurrentBet(currentBet);
    }
}
