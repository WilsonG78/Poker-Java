package common.protocol.client.factory;

import common.protocol.client.commands.ClientCommand;
import common.protocol.client.commands.StartCommand;

public class StartCommandFactory extends ClientComandFactory {
    @Override
    public ClientCommand createClientCommand() {
        return new StartCommand();
    }
}
