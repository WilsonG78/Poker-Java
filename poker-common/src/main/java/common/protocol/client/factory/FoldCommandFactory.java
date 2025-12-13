package common.protocol.client.factory;

import common.protocol.client.commands.ClientCommand;
import common.protocol.client.commands.FoldCommand;

public class FoldCommandFactory extends ClientComandFactory {
    @Override
    public ClientCommand createClientCommand() {
        return new FoldCommand();
    }
}
