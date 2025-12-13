package common.protocol.server.factory;

import common.protocol.server.commands.ServerCommand;
import common.protocol.server.commands.WinnerPlayerCommand;

public class WinnerPlayerCommandFactory extends ServerCommandFactory {
    @Override
    public ServerCommand createServerCommand() {
        return new WinnerPlayerCommand();
    }
}
