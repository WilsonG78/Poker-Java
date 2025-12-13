package common.protocol.server.factory;

import common.protocol.server.commands.ServerCommand;
import common.protocol.server.commands.TurnPlayerCommand;

public class TurnPlayerCommandFactory extends ServerCommandFactory {
    @Override
    public ServerCommand createServerCommand() {
        return new TurnPlayerCommand();
    }
}
