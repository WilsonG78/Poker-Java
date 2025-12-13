package common.protocol.client.factory;

import common.protocol.client.commands.ClientCommand;

public abstract class ClientComandFactory {
    public abstract ClientCommand createClientCommand();
    public void setFromString(String string){
        ClientCommand cmd = createClientCommand();
        cmd.parseFromString(string);
    }
}
