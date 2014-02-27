/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webserver.model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Kevin
 * @version 0.9
 */
public class Server
{

    private int port;

    /**
     *
     *
     */
    public Server()
    {

        confiqurePort();
    }

    /**
     * Simple method to let the user set portnumber
     *
     * @throws IOException
     */
    private void confiqurePort()
    {
        this.port = 8080;
        try
        {
            runServer();
        }
        catch (IOException ex)
        {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Change port?\nY : change\nN : user deafault : " + port);
        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine();
        if (userChoice.equals("y"))
        {
            System.out.println("Enter port number");
            String input = scanner.nextLine();
            try
            {
                int newPort = Integer.parseInt(input);
                port = newPort;
            }
            catch (NumberFormatException ex)
            {
                System.out.println("Not a valid number portnumber");
            }
            finally
            {
                System.out.println("Port set to : " + port);
                try
                {
                    runServer();
                }
                catch (IOException ex)
                {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        else
        {
            try
            {
                runServer();
            }
            catch (IOException ex)
            {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /**
     * Starts connects clientsSocket with serverSocket
     *
     * @throws IOException catches exception if socket is not found
     */
    private void runServer() throws IOException
    {

        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server started");
        while (true)
        {
            Socket newClientSocket = serverSocket.accept();
            System.out.println("Client Request");
            ConnectionHandler handlingClient = new ConnectionHandler(newClientSocket);

        }
    }

}
