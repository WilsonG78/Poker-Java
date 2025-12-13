package common.protocol.server.factory;

import common.protocol.server.commands.ActionPlayerCommand;
import common.protocol.server.commands.ServerCommand;

public class ActionPlayerCommandFactory extends ServerCommandFactory {
    @Override
    public ServerCommand createServerCommand() {
        return new ActionPlayerCommand();
    }
}
