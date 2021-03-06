/**
 * @author Thonifho
 */
package za.co.wethinkcode.robotworlds.Server.Domain.clientHandler;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.Robot;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.Command;

/**
 * InputHandler manages the input from the user and initiates
 * the method call for commands to be processed.
 * JSONObject from client
 * Robot object
 * Action Thoni && Issa
 */
public class InputHandler {
    String input;
    Robot target;
    String argument;

    public InputHandler(JSONObject input, Robot target){
        this.input = (String) input.get("command");
        JSONArray argArray = (JSONArray) input.get("arguments");
        argArray.toArray();
        this.argument = argArray.size()>0 ? (String) argArray.get(0) : "";
        this.target = target;
    }

    /**
     * Create the command and obtain the outcome of the respective command.
     * @return JSONObject from the server protocol to be sent to the client.
     */
    public JSONObject getOutput(){
        ServerMessageProtocol protocol = new ServerMessageProtocol();
        Command command = Command.create(this.input+" "+this.argument);
        JSONObject value = new JSONObject();
        JSONObject data = new JSONObject();
        if (target.handleCommand(command)) {
            value = protocol.createJSON(this.input, "OK", this.target);
            return value;
        }
        data.put("message", "Unsupported command");
        value.put("result", "error");
        value.put("data", data);
        return value;
    }
}
