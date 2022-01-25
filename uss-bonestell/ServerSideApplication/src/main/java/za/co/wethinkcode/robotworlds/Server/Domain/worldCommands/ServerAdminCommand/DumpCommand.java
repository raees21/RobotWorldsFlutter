package za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.ServerAdminCommand;


import za.co.wethinkcode.robotworlds.Server.Domain.world.World;
import za.co.wethinkcode.robotworlds.Server.Domain.world.obstacles.Obstacle;
import za.co.wethinkcode.robotworlds.Server.Domain.world.obstacles.SquareObstacle;
import za.co.wethinkcode.robotworlds.Server.Server;

import java.util.List;

/**
 * Class to provide the representation of all world artifacts
 * @author Issa
 */
public class DumpCommand {
    World world;

    public DumpCommand(World world) {
        System.out.println("WORLD STATE:");
        this.world = world;
        showWorldObstacles();
        new RobotsCommand(world);
    }

    /**
     * Display all obstacles
     */

    private void showWorldObstacles() {
        List<Obstacle> obstacleList = this.world.getObstacles();
        List<Obstacle> mineList = this.world.getMines();

        System.out.println("<<<<<<<<<<<<<<OBSTACLES>>>>>>>>>>>>>>");
        int i = 0;
        for (Obstacle obstacle : obstacleList) {
            if (obstacle.getIsPit() == false) {
                System.out.printf("[%d,%d] to [%d,%d]  ", obstacle.getBottomLeftX(),
                        obstacle.getBottomLeftY(), obstacle.getBottomLeftX() + 4, obstacle.getBottomLeftY() + 4);
                i++;
            }
        }
        System.out.println("\nNumber of obstacles: " + i);
        System.out.println("<<<<<<<<<<<<<<PITS>>>>>>>>>>>>>>");
        int n = 0;
        for (Obstacle obstacle : obstacleList) {
            if (obstacle.getIsPit() == true) {
                System.out.printf("[%d,%d] to [%d,%d]  ", obstacle.getBottomLeftX(),
                        obstacle.getBottomLeftY(), obstacle.getBottomLeftX() + 4, obstacle.getBottomLeftY() + 4);
                n++;
            }
        }System.out.println("\nNumber of pits: " + n);
        System.out.println("<<<<<<<<<<<<<<MINES>>>>>>>>>>>>>>");
        int p = 0;
        for (Obstacle obstacle : mineList) {
            System.out.printf("[%d,%d] to [%d,%d]  ", obstacle.getBottomLeftX(),
                    obstacle.getBottomLeftY(), obstacle.getBottomLeftX() + 4, obstacle.getBottomLeftY() + 4);
            p++;
        }System.out.println("\nNumber of mines: " + p);
    }
}