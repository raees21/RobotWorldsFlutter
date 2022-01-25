package za.co.wethinkcode.robotworlds.Server.Domain.clientHandler;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.Robot;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.actions.LookCommand;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
Protocol handler to convert output to JSONObject to be returned to the client
 String command, String result Robot object required by the constructor.
Action: Issa
 */
public class ServerMessageProtocol {
        JSONObject returnJson = new JSONObject();
        JSONObject data = new JSONObject();
        JSONObject state = new JSONObject();
        JSONArray robotPosition = new JSONArray();
        JSONParser parser = new JSONParser();

        public JSONObject createJSON(String command, String result, Robot target) {

            int visibility = target.getVisibility();
            int reload = target.getReload();
            int repair = target.getRepair();
            int mine = target.getMine();
            int shields = target.getShields();
            int shots = target.getShots();

            state.clear();
            data.clear();
            returnJson.clear();

            returnJson.put("result", result);

            robotPosition.add(target.getPosition().getX());
            robotPosition.add(target.getPosition().getY());

            String direction = target.getCurrentDirection().toString();

            String status = target.getRobotStatus().toString();

            switch (command){
                case "help":
                    data.put("message", target.getStatus());
                case "launch":
                    data.put("position", robotPosition);
                    data.put("visibility", visibility);
                    data.put("reload", reload);
                    data.put("repair", repair);
                    data.put("mine", mine);
                    data.put("shields", shields);

                    state.put("position", robotPosition);
                    state.put("visibility", visibility);
                    state.put("reload", reload);
                    state.put("repair", repair);
                    state.put("mine", mine);
                    state.put("shields", shields);
                    break;
                case "forward":
                case "back":
                    data.put("message", "Done");
                case "turn":
                    data.put("message", "Done");
                case "repair":
                    data.put("message", "Done");
                case "reload":
                    data.put("message", "Done");
                case "mine":
                    data.put("message", "Done");
                    break;
                case "fire":
                    File file = new File("").getAbsoluteFile();
                    String jsonFilePath = "/ServerSideApplication/src/main/java/za/co/wethinkcode/robotworlds/" +
                            "Server/worldCommands/actions/FireHitOrMiss.json";
                    try {
                        JSONObject dataJSON = (JSONObject) parser.parse(new FileReader(file + jsonFilePath));
                        data.put("data", dataJSON);
                    }catch (ParseException e){ System.out.println("Could not parse: " +e);}
                    catch (IOException e){System.out.println("Could not parse: " +e);}
                    break;
                case "look":
                    List<JSONObject> obstacles = LookCommand.getObstacleInVision();
                    data.put("objects", obstacles);
                    break;
                case "state":
            }

            if (result.equalsIgnoreCase("ok")){
                //adding the state params to the state JSONObject
                state.put("position", robotPosition);
                state.put("direction", direction);
                state.put("shields", shields);
                state.put("shots", shots);
                state.put("status", status);

                returnJson.put("state", state);
            }

            if (data.size()>0){ returnJson.put("data", data); }

            return returnJson;
        }
}

/**
Protocol format:

---launch request

{
  "result": "OK",
  "data": {
    position: [x,y],
    "visibility": steps
    "reload": seconds,
    "repair": seconds,
    "mine": seconds,
    "shields": hits
  },
  "state": {
    "position": [x,y],
    "direction: "NORTH",
    "shields": hits,
    "shots": shots,
    "status": "NORMAL"
   }
}

 */


