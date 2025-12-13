package model;

import common.protocol.client.commands.*;

import java.util.List;

public class ClientParser {
    private List<ClientCommand>  listOfCommands;
    void initList(){
        listOfCommands.add(new HelloCommand());
        listOfCommands.add(new CallCommand());
        listOfCommands.add(new StatusCommand());
        listOfCommands.add(new LeaveCommand());
        listOfCommands.add(new BetCommand());
    }

    public ClientCommand parse(){}
}
