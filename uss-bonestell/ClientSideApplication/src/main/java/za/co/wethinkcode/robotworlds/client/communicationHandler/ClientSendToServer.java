package za.co.wethinkcode.robotworlds.client.communicationHandler;

import org.json.simple.JSONObject;
import java.io.PrintStream;
import za.co.wethinkcode.robotworlds.client.StdFontColor;

import java.io.IOException;

/**
Responsible for sending the message to the server and returning true if the message was successfully sent
else return false
Action: Sarah & Issa
 */
public class ClientSendToServer {

    public boolean RequestSent(JSONObject message, ClientServerSender request) throws IOException {

        try {
//            request.getSender().writeObject(message);
            request.getSender().println(message);
            return true;
        } catch (Exception e) {
            new StdFontColor().printTextColor("Unable to send request", "error");
            return false;
        }
    }
}