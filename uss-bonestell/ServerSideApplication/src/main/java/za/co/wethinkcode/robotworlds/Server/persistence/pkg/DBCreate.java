package za.co.wethinkcode.robotworlds.Server.persistence.pkg;

import org.jetbrains.annotations.NotNull;
import za.co.wethinkcode.robotworlds.Server.Domain.world.obstacles.Obstacle;
import za.co.wethinkcode.robotworlds.Server.persistence.DbConnect;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.Robot;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.RobotHandler;
import za.co.wethinkcode.robotworlds.Server.Domain.world.World;
import za.co.wethinkcode.robotworlds.Server.Domain.world.obstacles.SquareObstacle;

import java.sql.PreparedStatement;
import java.util.List;

public class DBCreate {

    public DBCreate() {

    }


    public void CreateOne(Obstacle o) {

        try (PreparedStatement st = DbConnect.connection.prepareStatement("INSERT INTO Obstacles(Xcoordinate, Ycoordinate) VALUES(?, ?);")){
            st.setInt(1, o.getBottomLeftX());
            st.setInt(2, o.getBottomLeftY());
            st.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void CreateOne(Robot robot) {
        try (PreparedStatement st = DbConnect.connection.prepareStatement
                ("INSERT INTO Robots(RobotName, Xcoordinate, Ycoordinate, Direction, Shields, Shots, Status, Robotstatus, Mine) " +
                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);")){
            st.setString(1, robot.getName());
            st.setString(2, Integer.toString(robot.getPosition().getX()));
            st.setString(3, Integer.toString(robot.getPosition().getY()));
            st.setString(4, robot.getCurrentDirection().toString());
            st.setString(5, Integer.toString(robot.getShields()));
            st.setString(6, Integer.toString(robot.getShots()));
            st.setString(7, robot.getStatus());
            st.setString(8, robot.getRobotStatus().toString());
            st.setString(9, Integer.toString(robot.getMine()));
            st.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void CreateOne(World world) {
        try (PreparedStatement st = DbConnect.connection.prepareStatement("INSERT INTO Worlds(WorldName, size) VALUES(?, ?);")) {
            st.setString(1, world.getName());
            st.setString(2, ""+ world.getSize());
            st.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void AddObstacles(@NotNull List<Obstacle> obs) {
        for (Obstacle o: obs) {
            CreateOne(o);
        }
    }

    public void AddRobots(@NotNull List<RobotHandler> obs) {
        for (RobotHandler o: obs) {
            CreateOne(o.getRobot());
        }
    }
}
