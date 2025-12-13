package common.protocol.server.factory;

import common.protocol.server.commands.ServerCommand;

public abstract class ServerCommandFactory {
    public abstract ServerCommand createServerCommand();
    public void setFromString(String string){
        ServerCommand cmd = createServerCommand();
        cmd.parseFromString(string);
    }
}