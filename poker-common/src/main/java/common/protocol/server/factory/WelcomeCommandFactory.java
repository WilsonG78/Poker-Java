package common.protocol.server.factory;

import common.protocol.server.commands.ServerCommand;
import common.protocol.server.commands.WelcomeCommand;

public class WelcomeCommandFactory extends ServerCommandFactory {
    @Override
    public ServerCommand createServerCommand() {
        return new WelcomeCommand();
    }
}
