/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webserver.model;

/**
 * This class handles the webbrowser client requests.
 *
 * @author Kevin
 * @version 0.9
 */
public class ServerRequest
{

    String filename;

    public ServerRequest()
    {

    }

    /**
     * Reformats the string. So that we can use it to serach for a file
     *
     * @param request clients request
     * @return returns String in a proper fileformat
     */
    public String stringFormat(String request)
    {
        filename = request;
        String lines[] = filename.split("\n"); //seperate requests

        //Splits the line with space and puts the second line in [1] which is filename
        lines = lines[0].split(" ");

        String clean = lines[1];
        //Substings out the /
        this.filename = clean.substring(1);
        return filename;
    }

}
