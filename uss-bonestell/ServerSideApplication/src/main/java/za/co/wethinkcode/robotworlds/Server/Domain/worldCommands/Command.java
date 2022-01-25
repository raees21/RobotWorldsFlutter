/**
 * @author Thonifho, Tshepo
 */
package za.co.wethinkcode.robotworlds.Server.Domain.worldCommands;

import za.co.wethinkcode.robotworlds.Server.Domain.robot.Robot;
import za.co.wethinkcode.robotworlds.Server.Domain.world.World;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.actions.*;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.movements.BackCommand;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.movements.ForwardCommand;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.movements.LeftCommand;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.movements.RightCommand;

/**
 * Abstract class to handle all the robot commands
 * @author Thoni
 * @author Issa
 * @author Tshepo
 */
public abstract class Command {
    private final String name;
    private final String arguments;
    protected World world;

    public Command(String name, String arguments) {
        this.name = name.toLowerCase().trim();
        this.arguments = arguments.trim();
    }

    public Command(String name){
        this.name = name.toLowerCase().trim();
        this.arguments = "";
        this.world = world;
    }

    public String getName() {
        return this.name;
    }

    public String getArgument() {
        return this.arguments;
    }

    public abstract boolean execute(Robot target);

    public static Command create(String instruction) {
        String[] args = instruction.toLowerCase().trim().split(" ");
        switch (args[0]){
            case "shutdown":
                return new ShutdownCommand();
            case "help":
                return new HelpCommand();
            case "forward":
                return new ForwardCommand(args[1]);
            case "back":
                return new BackCommand(args[1]);
            case "turn":
                switch (args[1]){
                    case "left":
                        return new LeftCommand();
                    case "right":
                        return new RightCommand();
                }
            case "fire":
                return new FireCommand();
            case "look":
                return new LookCommand();
            case "state":
                return new StateCommand();
            case "mine":
                return new MineCommand();
            case "reload":
                return new ReloadCommand();
            case "repair":
                return new RepairCommand();
            default:
                throw new IllegalArgumentException("Unsupported command: " + instruction);
        }
    }
}