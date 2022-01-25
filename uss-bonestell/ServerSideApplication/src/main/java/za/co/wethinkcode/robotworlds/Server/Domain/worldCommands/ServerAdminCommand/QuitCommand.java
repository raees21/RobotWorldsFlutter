package za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.ServerAdminCommand;

import za.co.wethinkcode.robotworlds.Server.Server;
import za.co.wethinkcode.robotworlds.Server.ServerMain;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.RobotHandler;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.ShutdownCommand;

import java.io.IOException;

/**
 * Class to purge all availalbe robots an shutdown the world
 * @author Issa
 */
public class QuitCommand {

    public QuitCommand() {
        purgeAll();
    }

    /**
     * Purges a single robot at a time. relies on the create command
     * to run the loop
     * @return true
     */
    public boolean purgeAll() {
        for (RobotHandler robotHandler : Server.currentWorld.getRobotHandlersAsList()) {
            if (robotHandler != null) {
                try {
                    robotHandler.getSocket().close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Server.currentWorld.RemoveRobot(robotHandler);
                robotHandler.getRobot().handleCommand(new ShutdownCommand());
            }
        }
        return true;
    }
}