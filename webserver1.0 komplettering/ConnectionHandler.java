package webserver;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Accepts requests and validates them for commands and files.
 * Response to validated requests with appropriate status.
 * Response file
 * @author Kevin
 * @version 1.0
 */
public class ConnectionHandler
{

    /**
     * Accepts and handles a request
     * Checks if the users want to stop the server
     * @param connectedClient
     * @return if messages /QUIT has been requested
     * @throws java.io.IOException
     */
    public boolean processRequest(Socket connectedClient) throws IOException
    {

        InputStream reader = connectedClient.getInputStream();
        DataOutputStream writer = new DataOutputStream(connectedClient.getOutputStream());
        Validate validate = new Validate();

        String clientRequest = validate.readRequest(reader, "\r\n\r\n");
        handling(clientRequest, writer, reader, validate);

        /* Breaks the while loop */
        if (clientRequest.startsWith("GET /QUIT "))
        {
            System.out.println("Server shut down");
            return false;
        }
        return true;

    }

    /**
     *
     * Method verifys if the request has a "GET" command or "HEAD" command.
     * Replys the status of the requested file
     * Sends the file
     * Closes streams
     * @param clientRequest String request from user
     * @param writer outputstream for writing and closing streams
     * @param reader passes through to the close method
     * @param validate object validate
     * @throws IOException for files missing, non existing filename, Not acceptable command, damaged files
     */
    private void handling(String clientRequest, DataOutputStream writer, InputStream reader, Validate validate) throws IOException
    {

        ClientResponse cr = new ClientResponse();

        String filename = validate.requestToFilename(clientRequest);
        boolean available = new File(filename).exists();

        if (clientRequest.startsWith("GET"))
        {
            if (available)
            {
                cr.statusMessage(200, "OK", filename, writer);
                cr.sendfile(filename, writer);
                close(writer, reader);
            }
            else
            {
                cr.statusMessage(404, "NOT FOUND", "error404.html", writer);
                cr.sendfile("error404.html", writer);
                close(writer, reader);
            }
        }
        else if (clientRequest.startsWith("HEAD"))
        {
            if (available)
            {

                cr.statusMessage(200, "OK", filename, writer);
                close(writer, reader);

            }
            else
            {
                cr.statusMessage(404, "NOT FOUND", "error400.html", writer);
                close(writer, reader);
            }
        }
        else
        {
            cr.statusMessage(400, "BAD REQUEST", "error400.html", writer);
            cr.sendfile("error404.html", writer);
            close(writer, reader);
        }

    }

    /**
     * closes input and output streams
     * @throws IOException for streams, missing, damaged,
     */
    private void close(DataOutputStream writer, InputStream reader) throws IOException
    {
        writer.close();
        reader.close();
    }

}
