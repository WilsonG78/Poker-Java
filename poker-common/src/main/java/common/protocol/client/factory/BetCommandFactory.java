package common.protocol.client.factory;

import common.protocol.client.commands.BetCommand;
import common.protocol.client.commands.ClientCommand;

public class BetCommandFactory extends ClientComandFactory{



    @Override
    public ClientCommand createClientCommand() {
        return new BetCommand();
    }


}
