package webserver;

import java.io.Closeable;
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
        ClientResponse clientresponse = new ClientResponse();
        String clientRequest = readRequest(reader, "\r\n\r\n");
        if (validate.passLenght(clientRequest))
        {

            handling(clientRequest, writer, reader, validate, clientresponse);
            close(reader, writer);
        }
        else
        {
            clientresponse.statusMessage(400, "BAD REQUEST", "error400.html", writer);
            close(reader, writer);
        }
        /* Breaks the while loop */
        if (validate.clientQuit(clientRequest))
        {
            System.out.println("Server shut down");
            return false;
        }
        return true;

    }

    /**
     * Sends the request to validation
     * translates request to filename
     * responses status of file
     * Sends the file
     * @param clientRequest String request from user
     * @param writer outputstream for writing and closing streams
     * @param reader passes through to the close method
     * @param validate object validate
     * @throws IOException for files missing, non existing filename, Not acceptable command, damaged files
     */
    private void handling(String clientRequest, DataOutputStream writer, InputStream reader, Validate validate,
            ClientResponse clientresponse) throws IOException
    {

        //ClientResponse clientresponse = new ClientResponse();
        String filename = validate.requestToFilename(clientRequest);
        boolean available = new File(filename).exists();
        boolean get = validate.getCommand(clientRequest);
        boolean head = validate.headCommand(clientRequest);

        if (head || get)
        {
            if (available)
            {
                clientresponse.statusMessage(200, "OK", filename, writer);

                if (get)
                {
                    clientresponse.sendfile(filename, writer);
                }

            }
            else
            {
                clientresponse.statusMessage(404, "NOT FOUND", "error400.html", writer);
            }
        }

        else
        {
            clientresponse.statusMessage(400, "BAD REQUEST", "error400.html", writer);

        }

    }

    /**
     * Reads the client requst
     * @param requestStream client request
     * @param stopSign when the loop should stop looking
     * @return returns the request as soon the buffer has data
     * @throws IOException if requestream file is damaged or are missing
     */
    public String readRequest(InputStream requestStream, String stopSign) throws IOException
    {

        int available;
        String request = "";

        while (!request.endsWith(stopSign))
        {
            available = requestStream.available();
            byte[] buffer = new byte[available];
            requestStream.read(buffer);

            request += new String(buffer);

        }

        return request.trim();
    }

    /**
     * closes all streams
     * @throws IOException for streams, missing, damaged,
     */
    private void close(Closeable stream1, Closeable stream2) throws IOException
    {
        stream1.close();
        stream2.close();
    }

}
