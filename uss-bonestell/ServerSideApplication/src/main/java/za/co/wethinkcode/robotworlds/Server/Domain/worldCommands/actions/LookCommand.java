package za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.actions;

import org.json.simple.JSONObject;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.Robot;
import za.co.wethinkcode.robotworlds.Server.Domain.world.Position;
import za.co.wethinkcode.robotworlds.Server.Domain.world.obstacles.*;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.Command;
import za.co.wethinkcode.robotworlds.Server.Server;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to return the obstacles in the robots view limited to configured visibility.
 * Action: Issa
 */
public class LookCommand extends Command {

    public static List<JSONObject> obstacleInVision = new ArrayList<>();

    public LookCommand(){ super("look");}

    @Override
    public boolean execute(Robot target) {

        ArrayList<Obstacle> obstaclesHistory = HistoricalObstacleVisibility.getObstacleHistory();


        Position currentPosition = target.getPosition();
        Position northPosition = new Position(currentPosition.getX(), currentPosition.getY()+ target.getVisibility());
        Position southPosition = new Position(currentPosition.getX(), currentPosition.getY() - target.getVisibility());
        Position westPosition = new Position(currentPosition.getX()- target.getVisibility(), currentPosition.getY() );
        Position eastPosition = new Position(currentPosition.getX()+ target.getVisibility(), currentPosition.getY() );

        for (Obstacle obstacle: Server.currentWorld.getObstacles()) {
            JSONObject obstaclePosition = new JSONObject();
            if (obstacle.blocksPath(currentPosition, northPosition)){
                obstaclesHistory.add(obstacle);
                System.out.println("Northblocked");
                obstaclePosition.put("direction", "North");
                String type = obstacle.getIsPit() == true ? "Pit" : "Obstacle";
                obstaclePosition.put("type", type);
                int distance = obstacle.getBottomLeftY() - currentPosition.getY();
                obstaclePosition.put("distance", distance);

                obstacleInVision.add(obstaclePosition);
            }
            else if (obstacle.blocksPath(currentPosition,southPosition)){
                obstaclesHistory.add(obstacle);
                System.out.println("SouthBlocked");
                obstaclePosition.put("direction", "South");
                String type = obstacle.getIsPit() == true ? "Pit" : "Obstacle";
                obstaclePosition.put("type", type);
                int distance = currentPosition.getY()- obstacle.getBottomLeftY();
                obstaclePosition.put("distance", distance);

                obstacleInVision.add(obstaclePosition);
            }

            else if (obstacle.blocksPath(currentPosition, westPosition)){
                obstaclesHistory.add(obstacle);
                System.out.println("westblocked");
                obstaclePosition.put("direction", "West");
                String type = obstacle.getIsPit() == true ? "Pit" : "Obstacle";
                obstaclePosition.put("type", type);
                int distance = currentPosition.getX()- obstacle.getBottomLeftX();
                obstaclePosition.put("distance", distance);

                obstacleInVision.add(obstaclePosition);

            }else if (obstacle.blocksPath(currentPosition,eastPosition)){
                obstaclesHistory.add(obstacle);
                System.out.println("eastblocked");
                obstaclePosition.put("direction", "East");
                String type = obstacle.getIsPit() == true ? "Pit" : "Obstacle";
                obstaclePosition.put("type", type);
                int distance = obstacle.getBottomLeftX() - currentPosition.getX();
                obstaclePosition.put("distance", distance);

                obstacleInVision.add(obstaclePosition);
            }
        }

        for (Obstacle obstacle: Server.currentWorld.getMines()) {
            JSONObject obstaclePosition = new JSONObject();
            if (obstacle.blocksPath(currentPosition, northPosition)){
                obstaclesHistory.add(obstacle);
                obstaclePosition.put("direction", "North");
                obstaclePosition.put("type", "Mine");
                int distance = northPosition.getY() - currentPosition.getY();
                obstaclePosition.put("distance", distance);

                obstacleInVision.add(obstaclePosition);
            }
            else if (obstacle.blocksPath(currentPosition,southPosition)){
                obstaclesHistory.add(obstacle);
                obstaclePosition.put("direction", "South");
                obstaclePosition.put("type", "Mine");
                int distance = currentPosition.getY()-southPosition.getY();
                obstaclePosition.put("distance", distance);

                obstacleInVision.add(obstaclePosition);
            }

            else if (obstacle.blocksPath(currentPosition, westPosition)){
                obstaclesHistory.add(obstacle);
                obstaclePosition.put("direction", "West");
                obstaclePosition.put("type", "Mine");
                int distance = currentPosition.getX()-westPosition.getX();
                obstaclePosition.put("distance", distance);

                obstacleInVision.add(obstaclePosition);

            }else if (obstacle.blocksPath(currentPosition,eastPosition)){
                obstaclesHistory.add(obstacle);
                obstaclePosition.put("direction", "East");
                obstaclePosition.put("type", "Mine");
                int distance = eastPosition.getX() - currentPosition.getX();
                obstaclePosition.put("distance", distance);

                obstacleInVision.add(obstaclePosition);
            }
        }
        System.out.println(obstacleInVision.size()+ " Size of obstacle vision");
        return true;
    }

    public static List<JSONObject> getObstacleInVision(){return obstacleInVision;}

}
