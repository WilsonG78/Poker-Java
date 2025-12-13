package common.game;

import common.players.Player;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Round {
    private PotManager potManager;
    private Player playerOnMove;
    private int raisesCounter;
    private int ante;
    private List<Player> players;

    public void startRound(List<Player> players){
        for(Player p : players){
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
