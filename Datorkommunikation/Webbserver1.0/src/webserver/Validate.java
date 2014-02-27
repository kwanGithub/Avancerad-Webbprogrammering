package webserver;

/**
 * Checks the command for GET or HEAD command
 * Check the lenght of the request
 * Converts request to filename
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

        //String filename = request;
        String lines[] = request.split("\n"); //seperate requests

        /* Splits the line with space and puts the second line in [1] which is filename */
        lines = lines[0].split(" ");
        String clean = lines[1].trim();

        /* Substings out the / */
        filename = clean.substring(1);

        return filename;
    }

    public boolean passLenght(String clientRequest)
    {
        return clientRequest.length() > 1;
    }

    public boolean getCommand(String request)
    {
        return request.startsWith("GET");
    }

    public boolean headCommand(String request)
    {
        return request.startsWith("HEAD");

    }

    public boolean clientQuit(String request)
    {
        return request.startsWith("GET /QUIT ");
    }
}
