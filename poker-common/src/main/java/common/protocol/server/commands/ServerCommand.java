package common.protocol.server.commands;

public interface ServerCommand {
    void parseFromString(String input);
    String toReadableString();
}