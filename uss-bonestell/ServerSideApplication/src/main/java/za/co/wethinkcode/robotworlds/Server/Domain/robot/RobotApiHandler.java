package za.co.wethinkcode.robotworlds.Server.Domain.robot;

public class RobotApiHandler extends RobotHandler{
    private Robot robot;

    public RobotApiHandler(Robot r) {
        this.robot = r;
    }

    @Override
    public Robot getRobot() {
        return robot;
    }

    @Override
    public AutoCloseable getSocket() {
        return null;
    }

    @Override
    public void run() {

    }
}
