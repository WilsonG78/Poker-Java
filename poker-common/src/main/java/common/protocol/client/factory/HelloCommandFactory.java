package common.protocol.client.factory;

import common.protocol.client.commands.ClientCommand;
import common.protocol.client.commands.HelloCommand;

public class HelloCommandFactory extends ClientComandFactory {
    @Override
    public ClientCommand createClientCommand() {
        return new HelloCommand();
    }
}
