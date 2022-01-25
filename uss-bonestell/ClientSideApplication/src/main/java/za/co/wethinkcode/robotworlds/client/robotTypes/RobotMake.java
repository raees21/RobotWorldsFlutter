package za.co.wethinkcode.robotworlds.client.robotTypes;

/**
 * Class to implement the basic types of robots that the client can launch into the world
 */

public class RobotMake {
    String type;
    public RobotMake(String type){
        this.type = type;
    }

    public static String[] getMake(String make){
        switch (make){
            case "longshot":
                return longShotRobot();
            case "recon":
                return reconRobot();
            default:
                normalRobot();
        }
        return normalRobot();
    }

    /**
     * long shot robot has 1 long shot
     * @return trait
     */
    private static String[] longShotRobot(){
        String[] trait = {"1","5"};
        return trait;
    }

    /**
     * normal robot has 2 shots and 6 shields
     * @return
     */
    private static String[] normalRobot(){
        String[] trait = {"2","6"};
        return trait;
    }

    /**
     * recon robot has no shots and 5 shields
     * @return
     */
    private static String[] reconRobot(){
        String[] trait = {"0","5"};
        return trait;
    }
}
