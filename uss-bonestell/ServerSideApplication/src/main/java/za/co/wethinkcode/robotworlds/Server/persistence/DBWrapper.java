package za.co.wethinkcode.robotworlds.Server.persistence;

import org.jetbrains.annotations.NotNull;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.Robot;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.RobotHandler;
import za.co.wethinkcode.robotworlds.Server.Domain.world.World;
import za.co.wethinkcode.robotworlds.Server.Domain.world.obstacles.Obstacle;
import za.co.wethinkcode.robotworlds.Server.Domain.world.obstacles.SquareObstacle;

import java.util.List;

public interface DBWrapper {
    public void CreateOne(Obstacle o);
    public void CreateOne(World o);
    public void CreateOne(Robot o);
    public void AddRobots(@NotNull List<RobotHandler> obs);
    public void AddObstacles(@NotNull List<Obstacle> obs);
    public  void Save(World world);
    }
