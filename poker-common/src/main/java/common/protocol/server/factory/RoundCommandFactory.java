package common.protocol.server.factory;

import common.protocol.server.commands.RoundCommand;
import common.protocol.server.commands.ServerCommand;

public class RoundCommandFactory extends ServerCommandFactory {
    @Override
    public ServerCommand createServerCommand() {
        return new RoundCommand();
    }
}
