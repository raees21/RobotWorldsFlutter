package za.co.wethinkcode.robotworlds.TODOserver.TODORobot;
/**
 * Testing the robot configuration class
 */

import org.junit.jupiter.api.Test;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.RobotConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotConfigurationTest {
    @Test
    void getVisibilityTest() {
        RobotConfiguration robotConfiguration = new RobotConfiguration();
        int visibility = robotConfiguration.getVisibility();
        assertEquals(15, visibility);
    }


    @Test
    void getReloadTest(){
        RobotConfiguration robotConfiguration = new RobotConfiguration();
        int reload = robotConfiguration.getReload();
        assertEquals(5, reload);
    }


    @Test
    void getRepairTest(){
        RobotConfiguration robotConfiguration = new RobotConfiguration();
        int repair = robotConfiguration.getRepair();
        assertEquals(5,repair);
    }


    @Test
    void getMineTest(){
        RobotConfiguration robotConfiguration = new RobotConfiguration();
        int mine = robotConfiguration.getMine();
        assertEquals(7,mine);
    }


    @Test
    void getShieldTest(){
        RobotConfiguration robotConfiguration = new RobotConfiguration();
        int shields = robotConfiguration.getShield();
        assertEquals(5,shields);
    }


    @Test
    void getPortTest(){
        RobotConfiguration robotConfiguration = new RobotConfiguration();
        int port = robotConfiguration.getPort();
        assertEquals(4444,port);
    }


    @Test
    void getShotsTest(){
        RobotConfiguration robotConfiguration = new RobotConfiguration();
        int shots = robotConfiguration.getShots();
        assertEquals(5,shots);
    }

}
