package za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.ServerAdminCommand;

import za.co.wethinkcode.robotworlds.Server.Server;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.RobotHandler;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.ShutdownCommand;

import java.io.IOException;
import java.util.HashMap;

/**
 * Method to handle the Server admin command to purge a robot
 * @author Issa
 */
public class PurgeCommand{

        public PurgeCommand(String robotName){
            HashMap<String, RobotHandler> r = Server.currentWorld.getRobotHandlersMap();
            if (r.containsKey(robotName)) Server.currentWorld.getRobotHandlersMap().remove(robotName);
        }

    /**
     * Get the robot to be purged
     * @return the robothandler object
     */
//    private RobotHandler getRobotToPurge(){
//            for (RobotHandler robotHandler: Server.currentWorld.getRobotHandlersAsList()){
//                if (robotHandler.getRobot()!=null){
//                    if (robotHandler.getRobot().getName().equalsIgnoreCase(this.robotName)){
//                        return robotHandler;
//                    }
//                }
//            }
//            return null;
//        }

    /**
     * purge the robot provided.
     * @param robotHandler
     * @return true if successful; false if not.
     */
//    public boolean purgeRobot(RobotHandler robotHandler){
//            if (robotHandler != null){
//                try {
//                    robotHandler.getSocket().close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                robotHandler.getRobot().handleCommand(new ShutdownCommand());
//                return true;
//            }
//            return false;
//        }
}
