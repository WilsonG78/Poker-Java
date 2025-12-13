package common.protocol;

public enum ServerActions {
    OK("OK"),WELCOME("WELCOME"),ERR("ERR"),LOBBY("LOBBY"),STARTED("STARTED"),ANTE("ANTE");
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
