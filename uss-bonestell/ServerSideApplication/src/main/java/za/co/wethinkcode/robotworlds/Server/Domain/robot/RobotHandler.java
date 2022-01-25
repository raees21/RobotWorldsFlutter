package za.co.wethinkcode.robotworlds.Server.Domain.robot;

public abstract class RobotHandler implements Runnable{

    public boolean isLaunched;

    public abstract Robot getRobot();

    public abstract AutoCloseable getSocket();
}
