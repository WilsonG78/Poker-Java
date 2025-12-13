package common.game;

import common.players.PlayerId;

import java.util.List;

public class TurnOrder {
    private final List<PlayerId> players;
    private int currentIndex;
    private int dealerIndex;

    public TurnOrder(List<PlayerId> activePlayers, int dealerIndex) {
        this.players = activePlayers;
        this.dealerIndex = dealerIndex;
        this.currentIndex = (dealerIndex + 1) % players.size();
    }

    public PlayerId getCurrentPlayer() {
        return players.get(currentIndex);
    }

    public void nextTurn() {
        currentIndex = (currentIndex + 1) % players.size();
        // Tutaj można dodać logikę pomijania graczy, którzy spasowali (fold)
        // while (players.get(currentIndex).hasFolded()) { ... }
    }

    public boolean isRoundComplete(PlayerId lastAggressor) {
        // Logika sprawdzająca, czy licytacja wróciła do agresora
        return false; // placeholder
    }
}
