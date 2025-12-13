package common.protocol.client.commands;

/**
 * A sealed interface representing all possible commands that a client can send to the server.
 * Each command is a record that holds the specific parameters for that action.
 * Using a sealed interface allows for exhaustive, type-safe pattern matching.
 */
public interface ClientCommand  {


    String toReadableString();
    boolean parseFromString(String input);

}
