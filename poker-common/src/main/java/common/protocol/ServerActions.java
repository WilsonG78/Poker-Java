package common.protocol;

public enum ServerActions {
    OK("OK"),
    WELCOME("WELCOME"),
    ERR("ERR"),
    LOBBY("LOBBY"),
    STARTED("STARTED"),
    ANTE("ANTE"),
    ANTE_OK("ANTE_OK"),
    ACTION_PLAYER("ACTION_PLAYER"),
    DRAW_OK("DRAW_OK"),
    DEAL("DEAL"),
    PAYOUT_PLAYER("PAYOUT_PLAYER"),
    ROUND("ROUND"),
    SHOWDOWN("SHOWDOWN"),
    TURN_PLAYER("TURN_PLAYER"),
    WINNER_PLAYER("WINNER_PLAYER");

    private String value;
    ServerActions(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ServerActions fromString(String text) {
        for (ServerActions action : ServerActions.values()) {
            if (action.value.equalsIgnoreCase(text)) {
                return action;
            }
        }
        throw new IllegalArgumentException("Unknown action: " + text);
    }
}