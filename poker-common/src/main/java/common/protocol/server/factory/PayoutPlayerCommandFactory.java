package common.protocol.server.factory;

import common.protocol.server.commands.PayoutPlayerCommand;
import common.protocol.server.commands.ServerCommand;

public class PayoutPlayerCommandFactory extends ServerCommandFactory {
    @Override
    public ServerCommand createServerCommand() {
        return new PayoutPlayerCommand();
    }
}
