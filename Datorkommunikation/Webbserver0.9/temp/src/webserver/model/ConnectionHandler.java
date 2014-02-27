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
        System.out.println("client Request " + clientRequest);
        run(clientRequest);
    }

    /**
     * Method checks if "GET" is with the request if get is with the request It will handle the request, if not error hmtl will be displayed.
     *
     * @param clietnRequest request
     */
    private void run(String clientRequest) throws IOException
    {
        String request = clientRequest;

        if (request.substring(0, 3).equals("GET"))
        {
            ServerRequest requestedFile = new ServerRequest();
            String filename = requestedFile.stringFormat(request);

            try
            {
                openFile(filename);
            }
            catch (IOException | NullPointerException e)
            {
                openFile("error.html");
            }
            writer.close();
            reader.close();
            connectedClient.close();

        }
        else
        {
            openFile("error.html");
        }
    }

    /**
     * Looks for the file in the project root folder
     *
     * @param filename clicent request
     * @throws IOException no file
     */
    private void openFile(String filename) throws IOException
    {
        Path file = FileSystems.getDefault().getPath(filename);
        writer.write(Files.readAllBytes(file));
    }

}
