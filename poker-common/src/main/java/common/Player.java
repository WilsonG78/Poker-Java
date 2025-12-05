package common;


public class Player(){

    private final int playerId;
    private final int gameId;
    private int chips;
    private boolean onGame;
    private ArrayList<Card> deck;

    public Player(Game game,int playerId){
        this.playerId = playerId;

    }
}
