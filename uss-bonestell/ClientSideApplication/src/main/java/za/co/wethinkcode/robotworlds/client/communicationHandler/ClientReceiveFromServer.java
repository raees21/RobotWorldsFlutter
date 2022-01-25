package za.co.wethinkcode.robotworlds.client.communicationHandler;

import java.io.EOFException;
import java.io.IOException;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import za.co.wethinkcode.robotworlds.client.StdFontColor;

/**
Receive the listener object as an argument and return server response the json object
returned by the server.
Action: Issa
 */
public class ClientReceiveFromServer {

    public static JSONObject getResponse(ClientServerListener response) throws IOException {

        JSONParser parser = new JSONParser();
        JSONObject stringResponse = new JSONObject();
        stringResponse.put("result", "error");
        new StdFontColor()
                .printTextColor("Waiting for response", "status");
        try {
            stringResponse = (JSONObject) parser.parse(response.getListener().readLine());
            return stringResponse;
        }catch (EOFException | ParseException e){
//            System.out.println(e);
            e.printStackTrace();
            return stringResponse;
        }
    }
}
