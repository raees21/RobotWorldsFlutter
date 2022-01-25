package za.co.wethinkcode.robotworlds.client.protocolHandler;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import za.co.wethinkcode.robotworlds.client.robotTypes.RobotMake;

/**
This class should handle the conversion of the command inserted by the user to a formatted
JSON object to be sent to the server.
Action: Issa
 */
public class ClientMessageProtocol {

    /**Should contain the protocols as per curriculum as a template. Receives the command as an arg and return the
    formatted JSON object.
    */
    public static JSONObject launchRequest(String[] arguments) {
        String[] trait = RobotMake.getMake(arguments[1]); //Launch request requires the make of the robot
        JSONObject requestToSend = new JSONObject();
        JSONArray argumentArray = new JSONArray();
        //First add arguments to a JSON Array
        argumentArray.add(arguments[1]);
        argumentArray.add(trait[0]);
        argumentArray.add(trait[1]);
        //Add the required info to the JSON Object and return it.
        requestToSend.put("robot", arguments[2]);
        requestToSend.put("command", arguments[0]);
        requestToSend.put("arguments", argumentArray);

//        System.out.println("LOGGING: "+requestToSend);

        return requestToSend;
    }

    public static JSONObject movementRequest(String name, String[] arguments) {
        JSONObject requestToSend = new JSONObject();
        JSONArray argumentArray = new JSONArray();
        argumentArray.add(arguments[1]);

        requestToSend.put("robot", name);
        requestToSend.put("command", arguments[0]);
        requestToSend.put("arguments", argumentArray); //adding the steps to the JSONArray the passing it to the JSONObject

//        System.out.println("LOGGING: "+requestToSend);
        return requestToSend;
    }

    public static JSONObject turnRequest(String name, String[] arguments){
        JSONObject requestToSend = new JSONObject();
        JSONArray argumentArray = new JSONArray();
        argumentArray.add(arguments[1]);

        requestToSend.put("robot", name);
        requestToSend.put("command", "turn");
        requestToSend.put("arguments", argumentArray);

//        System.out.println("LOGGING: "+requestToSend);
        return requestToSend;
    }

    public static JSONObject allOtherRequests(String name, String[] command){
        //This method create the JSONObject for all requests that do not require additional arguments (state, look, reload,
        // fire, repair, mine)
        JSONObject requestToSend = new JSONObject();
        JSONArray argumentArray = new JSONArray();

        requestToSend.put("robot", name);
        requestToSend.put("command", command[0]);
        requestToSend.put("arguments", argumentArray); //Passing empty JSONArray as note in the curriculum

//        System.out.println("LOGGING: "+requestToSend);
        return requestToSend;
    }





}

/**
SEE FORMAT OF REQUESTS:

---Launch Request
{
  "robot": ...,
  "command": "launch",
  "arguments": [ kind,
                 maximum shield strength,
                 maximum shots
               ]
}

---State Request
{
  "robot": ...,
  "command": "state",
  "arguments": []
}

---Look Request
{
  "robot": ...,
  "command": "look",
  "arguments": []
}

---Movement Request
{
  "robot": ...,
  "command": "forward" or "back"
  "arguments": [steps]
}

---Turn Request
{
  "robot": ...,
  "command": "turn",
  "arguments": ["left" or "right"]
}

---Repair Request
{
  "robot": ...,
  "command": "repair",
  "arguments": []
}

---Reload Request
{
  "robot": ...,
  "command": "reload",
  "arguments": []
}

---Mine Request
{
  "robot": ...,
  "command": "mine",
  "arguments": []
}

---Fire Request

{
  "robot": ...,
  "command": "fire",
  "arguments": []
}
 */