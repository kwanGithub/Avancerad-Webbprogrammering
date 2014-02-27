package webserver;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

/**
 * File and status handling
 * Genreates files and status to repsonse to requests
 * @author Kevin
 * @version 1.0
 */
public class ClientResponse
{

    /**
     * Sends requested file
     * Buffers the data before writing
     * @param filename of wich file to put in the inputstream
     * @param writer responese file
     * @throws java.io.IOException
     */
    public void sendfile(String filename, DataOutputStream writer) throws java.io.IOException
    {
        InputStream file = new FileInputStream(filename);
        byte[] buffer = new byte[1024];
        while (file.available() > 0)
        {
            writer.write(buffer, 0, file.read(buffer));
        }
    }

    /**
     * Creates status messages for output
     * @param statusCode status code of the request
     * @param title response title
     * @param filename what was requested
     * @param writer for writing out status
     * @return responese filename
     * @throws IOException DataOutputStream error occurs
     */
    public String statusMessage(int statusCode, String title, String filename, DataOutputStream writer) throws IOException
    {
        Path file = FileSystems.getDefault().getPath(filename);
        long fileLength = new File(filename).length();
        String contentType = Files.probeContentType(file);
        writer.writeBytes("HTTP/1.0 " + statusCode + " " + title + "\r\n"
                + "Server: Kevin Webserver 1.0" + "\r\n"
                + "Date: " + new Date() + "\r\n"
                + "Content-Length: " + fileLength + "\r\n"
                + "Content-Type: " + contentType + "\r\n"
                + "</BODY></HTML>"
                + "\r\n\r\n");
        writer.flush();

        return filename;

    }

}
