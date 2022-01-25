package za.co.wethinkcode.robotworlds.TODOserver.maze;

import org.junit.jupiter.api.Test;
import za.co.wethinkcode.robotworlds.Server.Domain.world.World;
import za.co.wethinkcode.robotworlds.Server.Domain.world.obstacles.Obstacle;

import static org.junit.jupiter.api.Assertions.*;

class RandomMazeTest {

    @Test
    void createdObstacles() {
        World world = new World(100,"10,5");
        assertTrue(world.getObstacles().size()>0);
    }

    @Test
    void createdPits() {
        World randomMaze = new World(100,"10,5");
        for (Obstacle obstacle: randomMaze.getObstacles())
            if (obstacle.getIsPit()) {
                assertTrue(obstacle.getIsPit());
                return;
            }
        assertTrue(false);
    }

    @Test
    void getName() {
        World randomMaze = new World(100,"10,5");
        assertTrue(!randomMaze.getName().isBlank());
    }
}