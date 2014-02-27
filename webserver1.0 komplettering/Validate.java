package webserver;

import java.io.IOException;
import java.io.InputStream;

/**
 * Validates requests for filename, commands
 *
 * @author Kevin
 */
public class Validate
{

    /**
     * Takes a client request and converts it to a filename our server can read
     * @param request clients request
     * @return returns the filename
     */
    public String requestToFilename(String request)
    {
        String filename;
        try
        {
            //String filename = request;
            String lines[] = request.split("\n"); //seperate requests

            /* Splits the line with space and puts the second line in [1] which is filename */
            lines = lines[0].split(" ");
            String clean = lines[1].trim();

            /* Substings out the / */
            filename = clean.substring(1);

        }
        /* Hittade roten till mitt problem, jag misttänker att det var för att ja splittar på strängen i
         * i metoden ovanför och när vi skriver in endast en bokstav i putty och söker så blir det ett tomt element
         * i arrayen. Detta medför ArrayOutOfBoundsException
         * Catchar nu detta exception och formaterar om strängen till A B C för att gör den giltig
         */
        catch (IndexOutOfBoundsException e)
        {
            filename = "A B C";

        }
        return filename;
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
}
