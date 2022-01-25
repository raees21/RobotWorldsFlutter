/**
 * @author Thonifho, Tshepo
 */
package za.co.wethinkcode.robotworlds.Server.Domain.robot;

import za.co.wethinkcode.robotworlds.Server.Domain.world.Direction;
import za.co.wethinkcode.robotworlds.Server.Domain.world.Position;
import za.co.wethinkcode.robotworlds.Server.Domain.world.World;
import za.co.wethinkcode.robotworlds.Server.Domain.world.obstacles.MovementStatus;
import za.co.wethinkcode.robotworlds.Server.Domain.world.obstacles.Obstacle;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.Command;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class responsible for the robot object and managing the robot.
 * Constructor require the robot name and the world (Random maze)
 * Action: Thoni & Issa
 */

public class Robot {
    private static final Position TOP_LEFT = new Position(-100,200);
    private static final Position BOTTOM_RIGHT = new Position(+100,-200);
    public static final Position CENTRE = new Position(0,0);
    private RobotConfiguration config = new RobotConfiguration();
    private final int visibility = config.getVisibility();

    public Position position;
    public Direction currentDirection;
    public String status;
    public String name;
    public RobotStatus robotStatus;
    private int reload;
    private int repair;
    private int mine;
    private int shields;
    private int shots;
    public World world;
    Socket clientSocket;

    public Robot(String name, String x, String y, String currentDirection,
                 String shields, String shots, String status, String robotstatus, String mine, World world) {
        this.name = name;
        this.status = status;
        this.position = new Position(Integer.parseInt(x), Integer.parseInt(y));
        this.currentDirection = Direction.valueOf(currentDirection);
        this.shields = Integer.parseInt(shields);
        this.shots = Integer.parseInt(shots);
        this.robotStatus = RobotStatus.valueOf(robotstatus);
        this.mine = Integer.parseInt(mine);
        this.world = world;
    }

    public Robot(String name, World world) {
        this.name = name;
        this.status = "Ready..";
        if (world.getSize() == 1){
            this.position = new Position(0,0);
        }
        else {
            int coefficientX = new Random().nextInt(2) == 0 ? -1 : 1;
            int coefficientY = new Random().nextInt(2) == 0 ? -1 : 1;
            this.position = new Position(new Random().nextInt(100) * coefficientX, new Random().nextInt(200) * coefficientY);
        }
        this.currentDirection = Direction.NORTH;
        this.robotStatus = RobotStatus.NORMAL;
        this.reload = config.getReload();
        this.repair = config.getRepair();
        this.mine = config.getMine();
        this.shields = config.getShield();
        this.shots = config.getShots();
        this.world = world;
    }

    /**
     * Getter methods to return the state of the robot
     * @return the object called.
     */

    public int getVisibility(){ return this.visibility; }

    public int getReload(){ return this.reload; }

    public int getShots(){ return this.shots; }

    public String getName(){ return this.name; }

    public int getRepair() { return this.repair; }

    public int getMine() { return this.mine; }

    public int getShields() { return this.shields; }

    public RobotStatus getRobotStatus(){return this.robotStatus;}

    public Position getPosition() { return this.position; }
    public int[] getPositionAsArray() {
        return new int[]{
                position.getX(),
                position.getY()
        }; }


    public Direction getCurrentDirection() { return this.currentDirection; }

    public Socket getSocket(){ return this.clientSocket;}

    /**
     * Sets the socket of the robot from socket created
     * @param socket
     */
    public void setClientSocket(Socket socket) { this.clientSocket = socket; }

    /**
     * Sets the robots shots according to the action.
     * @param type (shot should decrement shot, reload to increment shots)
     */

    public void setShots(String type) {
        switch (type) {
            case "shot":
                this.shots--;
                break;
            case "reload":
                this.shots = config.getShots();
                break;
        }
    }

    /**
     * Set the robots remaining shield based on the action
     * @param type (if robot was shot shield decrements by 1, repair will return shields to configured
     *             shield amount and mine will decrement the shield by 3)
     */
    public void setShields(String type){
        switch (type){
            case "shot":
                this.shields--;
                break;
            case "repair":
                this.shields = config.getShield();
                break;
            case "mine":
                this.shields = this.shields - 3;
                break;
        }
    }

    /**
     * Set the robot status based on the action
     * @param status (action type)
     */

    public void setRobotStatus(String status){
        switch (status){
            case "hitmine":
                this.robotStatus = RobotStatus.HITMINE;
                break;
            case "obstructed":
                this.robotStatus = RobotStatus.OBSTRUCTED;
                break;
            case "repair":
                this.robotStatus = RobotStatus.REPAIRING;
                break;
            case "reload":
                this.robotStatus = RobotStatus.RELOADING;
                break;
            case "dead":
                this.robotStatus = RobotStatus.DEAD;
                break;
            case "mine":
                this.robotStatus = RobotStatus.SETMINE;
            default:
                this.robotStatus = RobotStatus.NORMAL;
        }
    }

    public String getStatus() { return this.status; }

    public void setStatus(String s) { this.status = s;}

    /**
     * Method executes the command provided
     * @param command
     * @return true if the command was executed and false if not
     */
    public boolean handleCommand(Command command) { return command.execute(this); }

    /**
     *
     * @param @param turnRight if true, then turn 90 degrees to the right, else turn left.
     */
    public void updateDirection(boolean turnRight){
        Integer i = currentDirection.ordinal();
        if (turnRight) {
            this.currentDirection = Direction.values()[(i+1)%4];
        } else {
            if (i == 0) {
                this.currentDirection = Direction.values()[3];
            } else {
                this.currentDirection = Direction.values()[i - 1];
            }
        }
    }

    @Override
    public String toString() {
        return "[" + this.position.getX() + "," + this.position.getY() + "] "
                + this.name + "> " + this.status;
    }
}
