package common.protocol;

public enum ClientActions {
    HELLO("HELLO"),CREATE("CREATE"),JOIN("JOIN"),LEAVE("LEAVE"),START("START"),BET("BET"),CALL("CALL"),CHECK("CHECK"),FOLD("FOLD"),DRAW("DRAW"),STATUS("STATUS"),QUIT("QUIT"),
    PING("PING"), PONG("PONG"), REGISTER("REGISTER");

    private String value;
    ClientActions(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ClientActions fromString(String text) {
        for (ClientActions action : ClientActions.values()) {
            if (action.value.equalsIgnoreCase(text)) {
                return action;
            }
        }
        throw new IllegalArgumentException("Unknown action: " + text);
    }
}
