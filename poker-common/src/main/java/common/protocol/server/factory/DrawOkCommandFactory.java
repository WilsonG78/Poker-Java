package common.protocol.server.factory;

import common.protocol.server.commands.DrawOkCommand;
import common.protocol.server.commands.ServerCommand;

public class DrawOkCommandFactory extends ServerCommandFactory {
    @Override
    public ServerCommand createServerCommand() {
        return new DrawOkCommand();
    }
}
