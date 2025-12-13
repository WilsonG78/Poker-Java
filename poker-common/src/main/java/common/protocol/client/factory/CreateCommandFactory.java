package common.protocol.client.factory;

import common.protocol.client.commands.ClientCommand;
import common.protocol.client.commands.CreateCommand;

public class CreateCommandFactory extends ClientComandFactory {
    @Override
    public ClientCommand createClientCommand() {
        return new CreateCommand();
    }
}
