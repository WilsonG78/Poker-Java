package common.protocol.client.factory;

import common.protocol.client.commands.ClientCommand;
import common.protocol.client.commands.LeaveCommand;

public class LeaveCommandFactory extends ClientComandFactory {
    @Override
    public ClientCommand createClientCommand() {
        return new LeaveCommand();
    }
}
