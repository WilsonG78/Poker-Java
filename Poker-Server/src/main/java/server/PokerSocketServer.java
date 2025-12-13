package server;

import common.protocol.PokerClient;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;

public class PokerSocketServer{

    private ServerSocketChannel serverSocket;
    private Selector selector;
    private int numberOfGames = 0;
    private int numberOfClients = 0;
    private HashMap<Integer,PokerClient> clientIdToChannel;


    public PokerSocketServer(int port) throws Exception{
        selector = Selector.open();
        serverSocket = ServerSocketChannel.open();
        serverSocket.configureBlocking(false);
        serverSocket.socket().bind(new InetSocketAddress(port));
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);
    }
    /**
     * This method starts Socket Server
     * */
    public void start() throws Exception{

        while (true){
            this.selector.select();

            Iterator<SelectionKey> keys = this.selector.selectedKeys().iterator();

            while (keys.hasNext()) {
                SelectionKey key = keys.next();
                keys.remove();

                if (!key.isValid()) {
                    continue;
                }

                if (key.isAcceptable()) {
                    this.handleAccept(key);
                } else if (key.isReadable()) {

                    this.handleRead(key);
                }

            }
        }
    }

    /**
     *
     * */
    private void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
        SocketChannel clientChannel = serverChannel.accept();

        if (clientChannel == null) return;

        clientChannel.configureBlocking(false);

        clientChannel.register(this.selector, SelectionKey.OP_READ);

        createNewClient(clientChannel);
    }

    private void createNewClient(SocketChannel channel){
        PokerClient pokerClient = new PokerClient(numberOfClients,channel);
        clientIdToChannel.put(numberOfClients,pokerClient);
        numberOfClients++;
    }

    private void handleRead(SelectionKey key){

    }

    public void close() throws Exception{
        serverSocket.close();
    }
}
