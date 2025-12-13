package common.protocol.server.factory;

import common.protocol.server.commands.OkCommand;
import common.protocol.server.commands.ServerCommand;

public class OkCommandFactory  extends ServerCommandFactory{

    @Override
    public ServerCommand createServerCommand() {
        return new OkCommand();
    }
}
