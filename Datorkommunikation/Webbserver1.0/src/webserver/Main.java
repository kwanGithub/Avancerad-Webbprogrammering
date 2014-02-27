package webserver;

/**
 * This is a simple webbserver 1.0 that supports headers "GET" and "HEAD"
 * Supported files .html, txt
 * Image files that har supported gif,jpg
 * @author Kevin
 * @version 1.0
 */
public class Main
{

    /**
     * @param args for setting new prot number
     */
    public static void main(String[] args)
    {
        int port = 8080;
        if (args.length > 1)
        {
            try
            {
                port = Integer.parseInt(args[0]);
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("Non valid port given, " + "Will use "
                        + port + " instead");
            }
        }
        Server server = new Server(port);
        server.runServer();

    }
}
