package common.protocol.client.factory;

import common.protocol.client.commands.CheckCommand;
import common.protocol.client.commands.ClientCommand;

public class CheckCommandFactory extends ClientComandFactory {
    @Override
    public ClientCommand createClientCommand() {
        return new CheckCommand();
    }
}
