package webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Server class
 * @author Kevin
 * @version 1.0
 */
public class Server
{

    private final int port;
    /* Break the while loop */
    private boolean active;

    /**
     * Class consctructor takes in
     * @param port socker portnumber
     */
    public Server(int port)
    {
        this.port = port;

    }

    /**
     * Connects the sockets and acitvates the Server
     */
    public void runServer()
    {
        active = true;
        try (ServerSocket serverSocket = new ServerSocket(this.port))
        {
            while (active)
            {
                Socket newClientSocket = serverSocket.accept();
                ConnectionHandler handlingClient = new ConnectionHandler();
                active = handlingClient.processRequest(newClientSocket);
            }
            serverSocket.close();
        }
        catch (IOException ex)
        {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
