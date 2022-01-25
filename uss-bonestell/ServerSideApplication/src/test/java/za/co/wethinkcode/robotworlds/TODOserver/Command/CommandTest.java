package za.co.wethinkcode.robotworlds.TODOserver.Command;
/**
 *
 * @authors Tshepo
 */

import org.junit.jupiter.api.Test;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.Robot;
import za.co.wethinkcode.robotworlds.Server.Domain.world.World;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.Command;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.HelpCommand;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.ShutdownCommand;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.StateCommand;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.movements.BackCommand;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.movements.ForwardCommand;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.movements.LeftCommand;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.movements.RightCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CommandTest {
    @Test
    void getHelpName() {
        HelpCommand test = new HelpCommand();
        assertEquals("help", test.getName());
    }


    @Test
    void executeHelp() {
        World world = new World(100,"10,5");
        Robot robot = new Robot("HAL", world);
        Command help = new HelpCommand();
        assertTrue(robot.handleCommand(help));
        assertEquals("I can understand these commands:\n" +
                "OFF  - Shut down robot\n" +
                "HELP - provide information about commands\n" +
                "FORWARD - move forward by specified number of steps, e.g. 'FORWARD 10'\n" +
                "BACK - move backward by specified number of steps, e.g. 'BACK 10'\n" +
                "TURN <LEFT/RIGHT> - turns the robot left/turns the robot right.\n" +
                "FIRE - fires a shot to the direction the robot is facing\n" +
                "MINE - sets a mine at the current position of the robot and moves the robot forward, " +
                "if the robot cannot move forward it will step into the mine and shield will be impacted"+
                "RELOAD - sets the robot shield back to default, a delay of 7 seconds is applied."+
                "REPAIR - repairs the robot shield to the default value, a delay of 7 seconds is applied."+
                "LAUNCH - to launch a robot into the World e.g launch robot <robotName>." ,robot.getStatus());
    }


    @Test
    void getShutdownName() {
        ShutdownCommand test = new ShutdownCommand();
        assertEquals("off", test.getName());
    }


    @Test
    void getForwardName() {
        ForwardCommand test = new ForwardCommand(toString());
        assertEquals("forward", test.getName());
    }


    @Test
    void executeforwardCommand() {
        World world = new World(100,"10,5");
        Robot robot = new Robot("HAL", world);
        ForwardCommand command = new ForwardCommand("10");
        assertTrue(robot.handleCommand(command));
        //Position expectedPosition = new Position(Robot.CENTRE.getX(), Robot.CENTRE.getY() + 10);
        //assertEquals(expectedPosition, robot.getPosition());
//        assertEquals("Moved forward by 10 steps.", robot.getStatus());
    }


    @Test
    void getBackName() {
        BackCommand test = new BackCommand(toString());
        assertEquals("back", test.getName());
    }


    @Test
    void executebackCommand() {
        World world = new World(100,"10,5");
        Robot robot = new Robot("HAL", world);
        BackCommand command = new BackCommand("1");
        assertTrue(robot.handleCommand(command));
//        Position expectedPosition = new Position(Robot.CENTRE.getX(), Robot.CENTRE.getY() - 10);
//        assertEquals(expectedPosition, robot.getPosition());
//        assertEquals("Moved backward by 1 steps.", robot.getStatus());
    }


    @Test
    void getRightName() {
        LeftCommand test = new LeftCommand();
        assertEquals("left", test.getName());
    }


    @Test
    void executeRightCommand(){
        World world = new World(100,"10,5");
        Robot robot = new Robot("HAL", world);
        RightCommand right = new RightCommand();
        assertTrue(robot.handleCommand(right));
//        Position expectedposition = new Position(Robot.CENTRE.getX(), Robot.CENTRE.getY());
//        assertEquals(expectedposition,robot.getPosition());
        assertEquals("Turned right.",robot.getStatus());
    }


    @Test
    void getLeftName() {
        RightCommand test = new RightCommand();
        assertEquals("right", test.getName());
    }


    @Test
    void executeLeftCommand(){
        World world = new World(100,"10,5");
        Robot robot = new Robot("HAL", world);
        LeftCommand left = new LeftCommand();
        assertTrue(robot.handleCommand(left));
//        Position expectedposition = new Position(Robot.CENTRE.getX(), Robot.CENTRE.getY());
//        assertEquals(expectedposition, robot.getPosition());
        assertEquals("Turned left.",robot.getStatus());
    }


    @Test
    void getName() {
        Command test = new Command("test", "test") {
            @Override
            public boolean execute(Robot target) {
                return false;
            }
        };
        assertEquals("test", test.getName());
    }


    @Test
    void createCommand() {
        Command forward = Command.create("forward 10");
        assertEquals("forward", forward.getName());
        assertEquals("10", forward.getArgument());

        Command shutdown = Command.create("shutdown");
        assertEquals("off", shutdown.getName());

        Command help = Command.create("help");
        assertEquals("help", help.getName());
    }


    @Test
    void getNameAndArgment() {
        Command test = new Command("test", "100") {
            @Override
            public boolean execute(Robot target) {
                return false;
            }
        };
        assertEquals("test", test.getName());
        assertEquals("100", test.getArgument());
    }


    @Test
    public void TestStateCommandExecute(){
        Robot robot = new Robot("HAL",new World(100,"10,5"));
        StateCommand stateCommand = new StateCommand();
        assertTrue(stateCommand.execute(robot));
    }


    @Test
    public void TestMineCommand(){
        Robot robot = new Robot("HAL",new World(100,"10,5"));
        Command state = Command.create("state");
        assertTrue(state.execute(robot));
    }
}


