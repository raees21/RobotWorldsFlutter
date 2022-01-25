package za.co.wethinkcode.robotworlds.Server.persistence.pkg;

import za.co.wethinkcode.robotworlds.Server.Domain.robot.Robot;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.RobotApiHandler;
import za.co.wethinkcode.robotworlds.Server.Domain.world.obstacles.Obstacle;
import za.co.wethinkcode.robotworlds.Server.Server;
import za.co.wethinkcode.robotworlds.Server.persistence.DbConnect;
import za.co.wethinkcode.robotworlds.Server.Domain.world.World;
import za.co.wethinkcode.robotworlds.Server.Domain.world.obstacles.SquareObstacle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBRead {

    public void ReadWorld(World world) {
        try (PreparedStatement st = DbConnect.connection.prepareStatement("SELECT * FROM Obstacles;")){
            boolean gotAResultSet = st.execute();

            if (!gotAResultSet) {
                throw new RuntimeException("Expected a SQL resultSet, but we got an update count instead!");
            }

            try(ResultSet results = st.getResultSet() ){
                while( results.next() ) {
                    final String Xcoordinate = results.getString( "Xcoordinate" );
                    final String Ycoordinate = results.getString( "Ycoordinate" );
                    Obstacle squareObstacle = new SquareObstacle(Integer.parseInt(Xcoordinate),
                            Integer.parseInt(Ycoordinate), false);
                    world.obstacles.add(squareObstacle);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try (PreparedStatement st = DbConnect.connection.prepareStatement("SELECT * FROM Pits;")){
            boolean gotAResultSet = st.execute();

            if (!gotAResultSet) {
                throw new RuntimeException("Expected a SQL resultSet, but we got an update count instead!");
            }

            try(ResultSet results = st.getResultSet() ){
                while( results.next() ) {
                    final String Xcoordinate = results.getString( "Xcoordinate" );
                    final String Ycoordinate = results.getString( "Ycoordinate" );
                    Obstacle squareObstacle = new SquareObstacle(Integer.parseInt(Xcoordinate),
                            Integer.parseInt(Ycoordinate), false);
                    world.mines.add(squareObstacle);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try (PreparedStatement st = DbConnect.connection.prepareStatement("SELECT * FROM Robots;")){
            boolean gotAResultSet = st.execute();

            if (!gotAResultSet) {
                throw new RuntimeException("Expected a SQL resultSet, but we got an update count instead!");
            }

            try(ResultSet results = st.getResultSet() ){
                while( results.next() ) {
                    final String RobotName = results.getString( "RobotName" );
                    final String Xcoordinate = results.getString( "Xcoordinate" );
                    final String Ycoordinate = results.getString( "Ycoordinate" );
                    final String Direction = results.getString( "Direction" );
                    final String Shields = results.getString( "Shields" );
                    final String Shots = results.getString( "Shots" );
                    final String Status = results.getString( "Status" );
                    final String Robotstatus = results.getString( "Robotstatus" );
                    final String Mine = results.getString( "Mine" );
                    //public Robot(String name, String x, String y, String currentDirection, String shields, String shots, String status)
                   Robot robot = new Robot(RobotName, Xcoordinate, Ycoordinate, Direction, Shields, Shots, Status, Robotstatus , Mine , Server.currentWorld);
                   RobotApiHandler robotApiHandler = new RobotApiHandler(robot);
                   Server.currentWorld.addRobot(robotApiHandler);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
