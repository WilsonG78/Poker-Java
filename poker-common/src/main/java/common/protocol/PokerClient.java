package common.protocol;

import java.nio.channels.SocketChannel;


public class PokerClient extends Thread {
    private SocketChannel socketChannel;
    private Integer clientId;
    public PokerClient(int clientId,SocketChannel socketChannel){
        this.clientId = clientId;
        this.socketChannel = socketChannel;
    }
}
