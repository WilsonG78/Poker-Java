package common.protocol.client.factory;

import common.protocol.client.commands.ClientCommand;
import common.protocol.client.commands.DrawCommand;

public class DrawCommandFactory extends ClientComandFactory {
    @Override
    public ClientCommand createClientCommand() {
        return new DrawCommand();
    }
}
