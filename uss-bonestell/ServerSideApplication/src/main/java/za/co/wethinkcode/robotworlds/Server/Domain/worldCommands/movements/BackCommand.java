package za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.movements;

import za.co.wethinkcode.robotworlds.Server.Domain.robot.Robot;
import za.co.wethinkcode.robotworlds.Server.Domain.world.obstacles.MovementStatus;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.Command;
import za.co.wethinkcode.robotworlds.Server.Server;

/**
 *Method to handle the Back command movements
 * @author  Tshepo
 * @author Issa
 */
public class BackCommand extends Command {

    public BackCommand(String argument) {
        super("back", argument);
    }

    @Override
    public boolean execute(Robot target){
        int nrSteps = Integer.parseInt(getArgument());
        MovementStatus state = Server.currentWorld.updatePosition(-nrSteps, target.getName());
        System.out.println(state);
        if (state == MovementStatus.successful){
            target.setRobotStatus("normal");
            target.setStatus("Moved backward by "+nrSteps+" steps.");
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
