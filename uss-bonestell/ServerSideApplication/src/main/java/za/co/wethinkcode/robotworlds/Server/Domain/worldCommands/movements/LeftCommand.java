/**
 * @author Tshepo
 */
package za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.movements;

import za.co.wethinkcode.robotworlds.Server.Domain.robot.Robot;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.Command;

/**
 * Method to handle the left movement by the robot
 * @author Issa
 * @author Tshepo
 */
public class LeftCommand extends Command {

    public LeftCommand() {super("left");}

    @Override
    public boolean execute(Robot target) {
        target.updateDirection(false);
        target.setStatus("Turned left.");
        return true;
    }
}
