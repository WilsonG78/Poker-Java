package common.protocol.client.factory;

import common.protocol.client.commands.CallCommand;
import common.protocol.client.commands.ClientCommand;

public class CallCommandFactory extends ClientComandFactory {
    @Override
    public ClientCommand createClientCommand() {
        return new CallCommand();
    }
}