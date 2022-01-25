package za.co.wethinkcode.robotworlds.Server.Domain.world;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.SerializedName;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.Robot;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.RobotHandler;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.RobotStatus;
import za.co.wethinkcode.robotworlds.Server.Domain.world.obstacles.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class World {
    private int worldID;
    transient HashMap<String, RobotHandler> robotHandlers = new HashMap<>();// keeps record of clients connected
    public List<Obstacle> obstacles = new ArrayList<>();// keeps record of obstacles connected
    public List<Obstacle> mines = new ArrayList<>();// keeps record of mines connected

    public List<state> robots;
    public int MaxRobots = 8;

    public int width;
    public int height;
    public int size;
    String[] newObstacle;
    public World() {
        setSize(400);
    }

    public World(int size , String obstacleProvided){
        setSize(size);
        // renderMaze();
        if (obstacleProvided.equals("none")) {
            renderMaze(false);
        }else {
            this.newObstacle = obstacleProvided.split(",");
            renderMaze(true);
        }
    }

    public MovementStatus updatePosition(int nrSteps, String name) {
        Robot t = robotHandlers.get(name).getRobot();
        int newY = t.position.getY();
        int newX = t.position.getX();

        if (Direction.NORTH.equals(t.currentDirection))
            newY = newY + nrSteps;
        else if (Direction.EAST.equals(t.currentDirection))
            newX = newX + nrSteps;
        else if (Direction.SOUTH.equals(t.currentDirection))
            newY = newY - nrSteps;
        else if (Direction.WEST.equals(t.currentDirection))
            newX = newX - nrSteps;

        Position newPosition = new Position(newX, newY);


        if (blocksPath(t.position ,newPosition, mines)) { return MovementStatus.mine; }
        if (blocksPath(t.position ,newPosition, obstacles)) { return MovementStatus.obstructed; }
        System.out.println("what before: " + newPosition.toString());
        if (isIn(newPosition)){
            System.out.println("what");
            t.position = newPosition;
            return MovementStatus.successful;
        }
        System.out.println("what after");
        return MovementStatus.unsuccessful;
    }

    public boolean isIn(Position a) {
        if (a.isIn(new Position(-(size/2), (size/2)),  new Position((size/2), -(size/2)))) {
            return true;
        }
        return false;
    }

    public void setSize(int sizeWorld){
        this.width = sizeWorld;
        this.height = sizeWorld;
        this.size = sizeWorld;
    }
    public boolean isNameTaken(String name) {
        return robotHandlers.containsKey(name);
    }

    public boolean isFull() {
        return robotHandlers.size() == MaxRobots;
    }

    public boolean blocksPath(Position a, Position b, List<Obstacle> o) {
        for (Obstacle each : o)
            if (each.blocksPath(a,b))
                return true;
        return false;
    }

    public void setMines(SquareMine mine){ mines.add(mine); System.out.println(mines.size());}

    public List<RobotHandler> getRobotHandlersAsList() {
        return new ArrayList<>(robotHandlers.values());
    }
    public HashMap<String, RobotHandler> getRobotHandlersMap() { return robotHandlers; }
    public List<Obstacle> getObstacles() { return obstacles; }
    public List<Obstacle> getMines() { return mines; }
    public String getName() { return "uss-bonestell-world"; }
    public int getSize(){ return this.size;}

    private void renderMaze(boolean obstacleOrNot) {
        if (obstacleOrNot) {
            int x= Integer.parseInt(this.newObstacle[0]);
            int y= Integer.parseInt(this.newObstacle[1]);
            obstacles.add(new SquareObstacle(x,y, false));
        }
    }

    public void addRobot(RobotHandler r) {
        robotHandlers.put(r.getRobot().getName(), r);
    }

    public void addMine(Obstacle r) { mines.add(r); }
    public void addObstacle(SquareObstacle r) { obstacles.add(r); }

    public void RemoveRobot(RobotHandler r){
        robotHandlers.remove(r.getRobot().name);
    };

    public void ClearLists() {
        robotHandlers.clear();
        mines.clear();
        obstacles.clear();
    }


    public void SetRobots() {
        ArrayList<state> l = new ArrayList<>();
        for (RobotHandler r: getRobotHandlersAsList()) {
            Robot robot = r.getRobot();
            l.add(new state(robot.name,
                            robot.getPositionAsArray(),
                            robot.getStatus(),
                            robot.getReload(),
                            robot.getRepair(),
                            robot.getMine(),
                            robot.getShields(),
                            robot.getShots(),
                            robot.getCurrentDirection(),
                            robot.getRobotStatus()
                    )
            );
        }
        this.robots = l;
    }

    class state {
        public String name;
//        public int[] position;
        public int x;
        public int y;
        public String status;
        public int reload;
        public int repair;
        public int mine;
        public int shields;
        public int shots;
        public String currentDirection;
        public String robotStatus;


        state(String name, int[] position, String status, int reload, int repair,
              int mine, int shields, int shots, Direction currentDirection, RobotStatus robotStatus) {
            this.name = name;
            this.x = position[0];
            this.y = position[1];
            this.status = status;
            this.reload = reload;
            this.repair = repair;
            this.mine = mine;
            this. shields = shields;
            this.shots = shots;
            this.currentDirection = currentDirection.toString();
            this.robotStatus = robotStatus.toString();
        }
    }
}
