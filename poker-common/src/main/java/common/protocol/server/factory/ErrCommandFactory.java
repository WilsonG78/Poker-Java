package common.protocol.server.factory;

import common.protocol.server.commands.ErrCommand;
import common.protocol.server.commands.ServerCommand;

public class ErrCommandFactory extends ServerCommandFactory {
    @Override
    public ServerCommand createServerCommand() {
        return new ErrCommand();
    }
}
