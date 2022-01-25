package za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.ServerAdminCommand;

import za.co.wethinkcode.robotworlds.Server.Domain.robot.Robot;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.RobotHandler;
import za.co.wethinkcode.robotworlds.Server.Domain.world.World;
import za.co.wethinkcode.robotworlds.Server.Server;

import java.util.List;

/**
 * Class to handle to robots command; give a representation of all the robots in the world.
 * @author Issa
 */
public class RobotsCommand {

    public RobotsCommand(World world) {
        getRobots(world);
    }

    /**
     * Get all the robots available in the world
     * @return true
     */
    public boolean getRobots(World world) {
        Robot robot = null;
        int robotsNotLaunched = 0;
        List<RobotHandler> robotHandlerList = world.getRobotHandlersAsList();

        int i = 1;
        System.out.println("Robots present in the World: ");

        if (robotHandlerList.isEmpty()) {
            System.out.println("No robots in this world");
            return true;
        }

        for (RobotHandler rh: Server.currentWorld.getRobotHandlersAsList()) {
            Robot r = rh.getRobot();
            System.out.printf("%d: %s\nPosition: [%d,%d]\nDirection: %s\nShields: %d\nShots: %d\nStatus: %s%n",
                    i, r.getName(), r.getPosition().getX(), r.getPosition().getY(), r.getCurrentDirection().toString(), r.getShields(),
                    r.getShots(), r.getStatus());
            i++;
        }
        if(robotsNotLaunched>0){ System.out.printf("%nNote: Clients connected but not launched: %d%n", robotsNotLaunched); }
        return true;
    }
}
