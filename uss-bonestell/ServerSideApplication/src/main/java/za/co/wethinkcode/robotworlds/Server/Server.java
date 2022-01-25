package za.co.wethinkcode.robotworlds.Server;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.RobotSocketHandler;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.ServerAdminCommand.RestoreCommand;
import za.co.wethinkcode.robotworlds.Server.api.Api;
import za.co.wethinkcode.robotworlds.Server.persistence.DbConnect;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.RobotConfiguration;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.RobotHandler;
import za.co.wethinkcode.robotworlds.Server.Domain.world.World;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {
    public static World currentWorld;
    private ServerSocket serverSocket;
    private String[] args;
    public static DbConnect dbConnect = new DbConnect();

    public StdFontColor stdFontColor = new StdFontColor();

    public Server(String[] args) throws Exception{

        this.serverSocket = new ServerSocket(8000);
        serverSocket.setSoTimeout(500000);
        Options options = new Options(); // created objects to collect cli arguments
        options.addOption("p", "port", true, "port number");// added first possible cli argument
        options.addOption("o", "obstacles", true, "port number");// added second
        options.addOption("s", "size", true, "port number");
        CommandLineParser parser = new DefaultParser();// this is object has to pass the options into cmd
        CommandLine cmd = parser.parse(options, args);

        int portToUse= cmd.getOptionValue("port") == null ? new RobotConfiguration().getPort() : Integer.parseInt(cmd.getOptionValue("port"));
        int size= cmd.getOptionValue("size") == null ? 400  : Integer.parseInt(cmd.getOptionValue("size"));

        String obstacle = cmd.getOptionValue("obstacles") == null ? "none" : cmd.getOptionValue("obstacles");
        this.args = args;
        currentWorld = new World(size, obstacle);

        stdFontColor.printTextColor("\n[Status] World server waiting for clients on port "+
                portToUse+"..", "status");

        Api a = new Api();
        a.start();

        new RestoreCommand();
    }

    public void run() {

        ExecutorService service = Executors.newFixedThreadPool(currentWorld.MaxRobots);
        ExecutorService adminService = Executors.newFixedThreadPool(1);

        adminService.submit(new ServerAdminInput());

        while (true) {
            try {
                Socket socket = serverSocket.accept();

                if (currentWorld.isFull()) { continue; }

                stdFontColor.printTextColor("\n[Client] Connected to " + socket.getRemoteSocketAddress(),
                        "client");

                RobotHandler robotHandler = new RobotSocketHandler(socket, currentWorld);
                currentWorld.getRobotHandlersAsList().add(robotHandler);
                service.submit(robotHandler);

                stdFontColor.printTextColor("   > Note: Connected Client(s): " + currentWorld.getRobotHandlersAsList().size()+"/"+currentWorld.MaxRobots,
                        "reset");

                if (currentWorld.isFull())
                    stdFontColor
                            .printTextColor("[Status] World is Full waiting a client to disconnect.",
                                    "status");
                else
                    stdFontColor
                            .printTextColor("[Status] Waiting for " + (currentWorld.MaxRobots - currentWorld.getRobotHandlersAsList().size()) + " more clients..",
                                    "status");
            } catch (SocketTimeoutException e){
                stdFontColor
                        .printTextColor("TIMEOUT DUE TO INACTIVITY" + (currentWorld.MaxRobots - currentWorld.getRobotHandlersAsList().size()) + " more clients..",
                                "error");
            } catch (Exception e) {
                System.out.println("exception: " + e);
            }
        }
    }
}
