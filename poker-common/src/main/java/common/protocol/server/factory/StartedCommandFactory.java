package common.protocol.server.factory;

import common.protocol.server.commands.ServerCommand;
import common.protocol.server.commands.StartedCommand;

public class StartedCommandFactory extends ServerCommandFactory {
    @Override
    public ServerCommand createServerCommand() {
        return new StartedCommand();
    }
}
