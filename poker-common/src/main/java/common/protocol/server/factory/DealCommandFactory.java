package common.protocol.server.factory;

import common.protocol.server.commands.DealCommand;
import common.protocol.server.commands.ServerCommand;

public class DealCommandFactory extends ServerCommandFactory {
    @Override
    public ServerCommand createServerCommand() {
        return new DealCommand();
    }
}
