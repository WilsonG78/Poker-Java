package common.protocol.server.factory;

import common.protocol.server.commands.ServerCommand;
import common.protocol.server.commands.ShowDownCommand;

public class ShowDownCommandFactory extends ServerCommandFactory {
    @Override
    public ServerCommand createServerCommand() {
        return new ShowDownCommand();
    }
}
