package za.co.wethinkcode.robotworlds.Server.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.javalin.Javalin;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import za.co.wethinkcode.robotworlds.Server.Domain.clientHandler.InputHandler;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.Robot;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.RobotApiHandler;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.RobotHandler;
import za.co.wethinkcode.robotworlds.Server.Domain.world.World;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.ServerAdminCommand.PurgeCommand;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.ServerAdminCommand.SaveCommand;
import za.co.wethinkcode.robotworlds.Server.Server;
import za.co.wethinkcode.robotworlds.Server.persistence.DbConnect;

import java.util.HashMap;

public class Api {
    private Javalin server;

    public Api() {
        this.server = Javalin.create();

        server.get("world", context -> {
            context.result(GetWorld());
        });

        server.get("world/restored", context -> {
            context.result(GetNewWorld());
        });

        server.post("world", context -> {
            ParseJSON(context.body());
        });

        server.post("robot", context -> {
            DataModelRobot.command c = ParseJSON(context.body());
           if (c.command.equalsIgnoreCase("launch")) context.result(PostRobot(c));
           else {
               JSONParser parser = new JSONParser();
               JSONObject incomingRequest = (JSONObject) parser.parse(context.body());
               HashMap<String, RobotHandler> robotMap = Server.currentWorld.getRobotHandlersMap();
               Robot r = robotMap.get(c.robot).getRobot();
               JSONObject inputHandler = new InputHandler(incomingRequest, r).getOutput();
               context.result(inputHandler.toString());
           }
        });

        server.get("admin/robots", context -> {
            context.result(GetRobots());
        });

        server.get("admin/obstacles", context -> {
            context.result(GetObstacles());
        });

        server.delete("admin/purgerobot", context -> {
            DataModelAdmin c = ParseJSONAdmin(context.body());
            context.result(PurgeRobots(c));
        });

        server.delete("admin/purgeobstacle", context -> {
            DataModelAdmin c = ParseJSONAdmin(context.body());
            context.result(PurgeRobots(c));
        });

        server.post("admin/save", context -> {
            DataModelAdmin c = ParseJSONAdmin(context.body());
            context.result(SaveWorld(c));
        });
    }

    public void start() {
        server.start(9000);
    }

    public DataModelRobot.command ParseJSON(String string) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(string);
        DataModelRobot.command c = mapper.readValue(string, DataModelRobot.command.class);
        return c;
    }

    public DataModelAdmin ParseJSONAdmin(String string) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(string);
        DataModelAdmin c = mapper.readValue(string, DataModelAdmin.class);
        return c;
    }

    public String serializeJSON(Object o) {
        Gson g = new Gson();
        return g.toJson(o);
    }

    public String GetWorld() {
        Server.currentWorld.SetRobots();
        Gson g = new Gson();
        String f = g.toJson(Server.currentWorld);
        return f;
    }

    public String GetRobots() {
        Server.currentWorld.SetRobots();
        Gson g = new Gson();
        String f = g.toJson(Server.currentWorld.robots);
        System.out.println(f);
        return f;
    }

    public String GetObstacles() {
        Gson g = new Gson();
        String f = g.toJson(Server.currentWorld.obstacles);
        System.out.println(f);
        return f;
    }

    public String PurgeRobots(@NotNull DataModelAdmin c) {
        DataModelRobot.response resp = new DataModelRobot.response();
        if (c.command.equalsIgnoreCase("purge")) {
            System.out.println(c.arguments);
            new PurgeCommand(c.arguments);
            resp.result = "OK";
            resp.data = "";
            resp.state = new DataModelRobot.state();
            return serializeJSON(resp);
        }
        resp.result = "ERROR";
        resp.data = "";
        resp.state = new DataModelRobot.state();
        return serializeJSON(resp);
    }

    public String SaveWorld(@NotNull DataModelAdmin c){
        DataModelRobot.response resp = new DataModelRobot.response();
        if (c.command.equalsIgnoreCase("save")){
            System.out.println("here");
            new SaveCommand(Server.currentWorld);
            resp.result = "OK";
            resp.data = "";
            resp.state = new DataModelRobot.state();
            return serializeJSON(resp);
        }
        resp.result = "ERROR";
        resp.data = "";
        resp.state = new DataModelRobot.state();
        return serializeJSON(resp);
    }

    public String GetNewWorld() {
        Server.currentWorld.SetRobots();
        Gson g = new Gson();
        return g.toJson(DbConnect.Restoredworld);
    }

    public String PostRobot(DataModelRobot.@NotNull command c) {
        DataModelRobot.response resp = new DataModelRobot.response();

            RobotApiHandler robot = new RobotApiHandler(new Robot(c.robot, Server.currentWorld));
            Server.currentWorld.addRobot(robot);


            Robot r = robot.getRobot();
            resp.result = "OK";
            resp.data = "";
            resp.state = new DataModelRobot.state();
            resp.state.position = r.position.toList();
            resp.state.direction = r.currentDirection.toString();
            resp.state.shields = r.getShields();
            resp.state.shots = r.getShots();
            resp.state.status = r.getStatus();
            return serializeJSON(resp);
    }
}

