package common.protocol.server.factory;

import common.protocol.server.commands.LobbyCommand;
import common.protocol.server.commands.ServerCommand;

public class LobbyCommandFactory extends ServerCommandFactory {
    @Override
    public ServerCommand createServerCommand() {
        return new LobbyCommand();
    }
}
