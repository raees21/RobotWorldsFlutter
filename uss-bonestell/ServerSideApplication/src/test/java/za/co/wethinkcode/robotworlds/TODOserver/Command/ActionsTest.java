package za.co.wethinkcode.robotworlds.TODOserver.Command;

import org.junit.Test;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.Robot;
import za.co.wethinkcode.robotworlds.Server.Domain.world.Direction;
import za.co.wethinkcode.robotworlds.Server.Domain.world.Position;
import za.co.wethinkcode.robotworlds.Server.Domain.world.World;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.Command;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.actions.FireCommand;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.actions.MineCommand;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.actions.ReloadCommand;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.actions.RepairCommand;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

///**TODO Sarah - Fire command, Repair
// * TODO Tshepo - Mine command and reload command*/

public class ActionsTest {

    @Test
    public void TestRepairCommandExecute(){
        Robot robot = new Robot("HAL",new World(100,"10,5"));
        RepairCommand repairCommand = new RepairCommand();
        assertTrue(repairCommand.execute(robot));
    }


    @Test
    public void TestFireCheckShotHitFalse() {
        FireCommand fireCommand = new FireCommand();
        Position position = new Position(1,0);
        Position position1 = new Position(0,14);
        assertFalse(fireCommand.checkShotHit(position, Direction.NORTH,position1));
    }


    @Test
    public void TestFireCheckShotHitTrue(){
        FireCommand fireCommand = new FireCommand();
        Position position = new Position(0,12);
        Position position1 = new Position(0,14);
        assertTrue(fireCommand.checkShotHit(position1,Direction.SOUTH,position));
    }

    @Test
    public void TestMineCommandExecute(){
        Robot robot = new Robot("HAL",new World(100,"10,5"));
        MineCommand mineCommand = new MineCommand();
        assertTrue(mineCommand.execute(robot));
    }


    @Test
    public void TestMineCommand(){
        Robot robot = new Robot("HAL",new World(100,"10,5"));
        Command mine = Command.create("mine");
        assertTrue(mine.execute(robot));
    }


    @Test
    public void TestReloadCommandExecute(){
        Robot robot = new Robot("HAL",new World(100,"10,5"));
        ReloadCommand reloadCommand = new ReloadCommand();
        assertTrue(reloadCommand.execute(robot));
    }


    @Test
    public void TestReloadCommand(){
        Robot robot = new Robot("HAL",new World(100,"10,5"));
        Command reload = Command.create("reload");
        assertTrue(reload.execute(robot));
    }
}