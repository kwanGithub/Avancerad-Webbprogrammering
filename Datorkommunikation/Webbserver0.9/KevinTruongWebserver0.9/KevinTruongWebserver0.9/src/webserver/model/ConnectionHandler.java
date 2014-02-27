/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webserver.model;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is where we respond to client requests.
 *
 * @author Kevin
 * @version 0.9
 */
public class ConnectionHandler
{

    private final String clientRequest;
    private final Socket connectedClient;
    private final DataOutputStream writer;
    private final BufferedReader reader;

    /**
     *
     * @param newClient new client connection
     * @throws IOException Excetpion if socket doesnt exitst
     */
    public ConnectionHandler(Socket newClient) throws IOException
    {
        this.connectedClient = newClient;

        reader = new BufferedReader(new InputStreamReader(connectedClient.getInputStream()));
        writer = new DataOutputStream(connectedClient.getOutputStream());

        clientRequest = reader.readLine();
        System.out.println(clientRequest);
        run(clientRequest);
    }

    /**
     * Method checks if the client sent out a "GET" request for a file.
     * Will then verify that the GET request is not empty. After everything is
     * verfied requested file will be loaded
     * @param clietnRequest request
     */
    private void run(String clientRequest)
    {
        String request = clientRequest;
        /* if the user types QUIT in teh browser, the server will s shutdown */
        if (request.startsWith("GET /QUIT "))
        {
            Server.ACTIVE = false;
        }
        else if (request.substring(0, 3).equals("GET") && request.length() > 3)
        {
            ServerRequest requestedFile = new ServerRequest();
            String filename = requestedFile.stringFormat(request);

            try
            {
                openFile(filename);
                writer.close();
                reader.close();
                connectedClient.close();
            }
            catch (IOException | NullPointerException e)
            {
                try
                {
                    openFile("error404.html");
                }
                catch (IOException ex)
                {
                    Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        else
        {
            try
            {
                openFile("error.html");
            }
            catch (IOException ex)
            {
                Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Opens requested file
     * @param filename file request
     * @throws IOException no file, damaged file
     */
    private void openFile(String filename) throws IOException
    {
        Path file = FileSystems.getDefault().getPath(filename);
        writer.write(Files.readAllBytes(file));
    }

}
