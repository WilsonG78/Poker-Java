package common.protocol.client.factory;

import common.protocol.client.commands.ClientCommand;
import common.protocol.client.commands.StatusCommand;

public class StatusCommandFactory extends ClientComandFactory {
    @Override
    public ClientCommand createClientCommand() {
        return new StatusCommand();
    }
}
