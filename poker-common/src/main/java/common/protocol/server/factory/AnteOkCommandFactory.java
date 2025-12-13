package common.protocol.server.factory;

import common.protocol.server.commands.AnteOkCommand;
import common.protocol.server.commands.ServerCommand;

public class AnteOkCommandFactory extends ServerCommandFactory {
    @Override
    public ServerCommand createServerCommand() {
        return new AnteOkCommand();
    }
}
