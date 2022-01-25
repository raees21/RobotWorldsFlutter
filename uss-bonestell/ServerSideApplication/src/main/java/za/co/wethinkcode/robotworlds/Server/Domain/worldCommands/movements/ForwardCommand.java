/**
 * @author Thonifho & Tshepo
 */
package za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.movements;

import za.co.wethinkcode.robotworlds.Server.Domain.robot.Robot;
import za.co.wethinkcode.robotworlds.Server.Domain.world.obstacles.MovementStatus;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.Command;
import za.co.wethinkcode.robotworlds.Server.Server;

/**
 * Method to handle the forward command
 * @author Issa
 * @author Tshepo
 */

public class ForwardCommand extends Command {

    public ForwardCommand(String argument) {
        super("forward", argument);
    }

    @Override
    public boolean execute(Robot target){
        int nrSteps = Integer.parseInt(getArgument());
        System.out.println("aa" + target.getName());
        MovementStatus state = Server.currentWorld.updatePosition(nrSteps, target.getName());
        if (state == MovementStatus.successful){
            target.setRobotStatus("normal");
            target.setStatus("Moved forward by "+nrSteps+" steps.");
        } else if( state == MovementStatus.fell){
            target.setRobotStatus("dead");
            target.setStatus("Robot is dead");
        } else if( state == MovementStatus.obstructed){
            target.setRobotStatus("obstructed");
            target.setStatus("Robot is obstructed");
        } else if( state == MovementStatus.mine){
            target.setShields("mine");
            if (target.getShields() > 0) {
                target.setRobotStatus("hitmine");
            } else {
                target.setRobotStatus("dead");
            }
            target.setStatus("Robot has stepped on a mine");
        }
        return true;
    }
}
