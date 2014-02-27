/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webserver.model;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Kevin
 * @version 1.0
 */
public class Main
{

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
                System.out.println("Non valid port given, " + "Will use " + port + " instead");
            }
        }
        webserver.model.Server server = new webserver.model.Server(port);
        try
        {
            server.runServer();
        }
        catch (IOException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
