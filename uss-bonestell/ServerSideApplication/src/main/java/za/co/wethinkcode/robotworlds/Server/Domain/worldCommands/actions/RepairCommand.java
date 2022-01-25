package za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.actions;

import za.co.wethinkcode.robotworlds.Server.Domain.robot.Robot;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.Command;


/**
 * Repair command configures the robots shield back to maximum.
 * Action: Issa
 */
public class RepairCommand extends Command {
    public RepairCommand(){super("repair");}

    @Override
    public boolean execute(Robot target) {
        target.setRobotStatus("repair");
        target.setShields("repair");
        try {
            Thread.sleep(1000*target.getRepair());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
