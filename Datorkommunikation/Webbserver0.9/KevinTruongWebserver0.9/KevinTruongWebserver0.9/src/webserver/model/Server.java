/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webserver.model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Kevin
 * @version 0.9
 */
public class Server
{

    private int port;
    public static boolean ACTIVE = true;

    /**
     *
     *
     */
    public Server(int port)
    {
        this.port = port;

    }

    /**
     * Starts connects clientsSocket with serverSocket
     *
     * @throws IOException catches exception if socket is not found
     */
    public void runServer() throws IOException
    {

        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server started");
        while (ACTIVE)
        {
            Socket newClientSocket = serverSocket.accept();
            System.out.println("Client Request");
            ConnectionHandler handlingClient = new ConnectionHandler(newClientSocket);

        }
    }

}
