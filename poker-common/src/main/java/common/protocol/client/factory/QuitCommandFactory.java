package common.protocol.client.factory;

import common.protocol.client.commands.ClientCommand;
import common.protocol.client.commands.QuitCommand;

public class QuitCommandFactory extends ClientComandFactory {
    @Override
    public ClientCommand createClientCommand() {
        return new QuitCommand();
    }
}
