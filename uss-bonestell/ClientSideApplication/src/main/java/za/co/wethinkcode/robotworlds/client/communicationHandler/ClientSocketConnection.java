package za.co.wethinkcode.robotworlds.client.communicationHandler;

/**
 * gets the port and hostname as args from the
commandline makes a connection to the said server
action: Sarah.
 */
import za.co.wethinkcode.robotworlds.client.StdFontColor;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocketConnection {

    public Socket makeConnection(String[] args) throws IOException {
        StdFontColor stdFontColor = new StdFontColor();
        // int portNum = 5000;
        try {
            // String hostname = args[0];
            String hostname = "localhost";
            // int portNum = Integer.parseInt(args[1]);
            int portNum = args[1] == null ? 8000  : Integer.parseInt(args[1]);
            if(args.length > 1){
                portNum = Integer.parseInt(args[1]);
            }
            Socket clientSocket = new Socket(hostname, portNum); //Client socket connection
            new StdFontColor().printTextColor("Server connection success", "status");
            return clientSocket;
        } catch (IndexOutOfBoundsException e) {
            stdFontColor
                    .printTextColor("default ip and port used"
                            , "error");
            return new Socket("localhost", 8000);
        }
        catch (UnknownHostException e) {
            stdFontColor
                    .printTextColor("Host : "+args[0]+" - not found! \nPlease ask server admin for correct Port and IP Address. "
                            , "error");
        }
        catch (NumberFormatException e) {
            stdFontColor
                    .printTextColor("Port : "+args[args.length-1]+" - not found! \nPlease ask server admin for correct Port and IP Address."
                            , "error");
        }

        return null;
    }
}
