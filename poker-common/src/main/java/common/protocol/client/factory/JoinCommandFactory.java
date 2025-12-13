package common.protocol.client.factory;

import common.protocol.client.commands.ClientCommand;
import common.protocol.client.commands.JoinCommand;

public class JoinCommandFactory extends ClientComandFactory {
    @Override
    public ClientCommand createClientCommand() {
        return new JoinCommand();
    }
}
