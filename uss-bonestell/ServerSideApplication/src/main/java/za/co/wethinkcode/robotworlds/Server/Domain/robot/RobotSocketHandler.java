/**
 * @author Thonifho
 */
package za.co.wethinkcode.robotworlds.Server.Domain.robot;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import za.co.wethinkcode.robotworlds.Server.*;
import za.co.wethinkcode.robotworlds.Server.Domain.clientHandler.InputHandler;
import za.co.wethinkcode.robotworlds.Server.Domain.clientHandler.ServerMessageProtocol;
import za.co.wethinkcode.robotworlds.Server.Domain.world.World;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.ShutdownCommand;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

/**
 * Method handles the entire robot and world. Implements runnable interface for the
 * purpose of threading.
 * Action: Thoni & Issa
 */
public class RobotSocketHandler extends RobotHandler implements Runnable{
    private Robot robot;
    private List robots;
    transient Socket socket;
    private PrintStream out;
    private BufferedReader in;
    private boolean robotAlive = true;
    private World world;
    public boolean isLaunched = false;

    public RobotSocketHandler(Socket socket, World currentWorld) throws IOException {
        this.socket = socket;
        this.robots = currentWorld.getRobotHandlersAsList();
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintStream(socket.getOutputStream());
        this.world = currentWorld;
    }

    /**
     * Activates the robot and is the base method for the entire robot operation
     * @throws IOException if unable to read data
     * @throws ClassNotFoundException if a class that has been called is not found
     */
    private void activateRobot() throws IOException, ClassNotFoundException {

        ServerMessageProtocol testResponse = new ServerMessageProtocol();
        JSONParser parser = new JSONParser();

        try {
            while (robotAlive) {
                String v = in.readLine();
                System.out.println(v);
                JSONObject incomingRequest = (JSONObject) parser.parse(v);
                System.out.println(incomingRequest);
                String name = (String) incomingRequest.get("robot");
                String command = (String) incomingRequest.get("command");

                if (command.equalsIgnoreCase("launch")) {
                    System.out.println("\n[Status] Creating a robot..\n");
                    GetRobotName nameCheck = new GetRobotName(name);
                    boolean nameTaken = nameCheck.getIsTaken();
                    if (Server.currentWorld.isNameTaken(name)){
                        JSONObject nameTakenResponse = nameCheck.nameTakenJSONObject();
                        // out.writeObject(nameTakenResponse);
                        out.println(nameTakenResponse);
                        continue;
                    }
                    robot = new Robot(name, world);
                    Server.currentWorld.addRobot(this);
                    isLaunched = true;
                    robot.setClientSocket(socket);
                    JSONObject protocol = testResponse.createJSON("launch", "OK", robot);
                    out.println(protocol);
                }

                if (!command.equalsIgnoreCase("off")
                        && robot != null && !command.equalsIgnoreCase("launch")){
                    JSONObject inputHandler = new InputHandler(incomingRequest, robot).getOutput();
                    // out.writeObject(inputHandler);

                    out.println(inputHandler);
                }
                else if (command.equalsIgnoreCase("off")) {
                    JSONObject protocol = testResponse.createJSON("off", "OK", robot);
                    out.println(protocol);
                    disconnect();
                    break;
                }

                System.out.println("[Client] " + robot.getName() + " : " + robot.getStatus());

                if(robot.getRobotStatus() == RobotStatus.DEAD){robotAlive = false; new ShutdownCommand();}
            }
        }
        catch(EOFException e){
            disconnect();
        }catch (SocketException e){
            disconnect();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * When client disconnects.
     */
    public void disconnect() throws IOException {
        world.RemoveRobot(this);
        socket.close();
        new StdFontColor().printTextColor("\n[Client]: " + socket.getRemoteSocketAddress()
                + " has client disconnected.", "error");
    }

    /**
     * Get the robot that has been instantiated.
     * @return Robot object
     */
    public Robot getRobot(){ return this.robot; }

    /**
     * Get the socket that the robot has been initialized on
     * @return socket object
     */
    public Socket getSocket(){ return this.socket;}

    public World getWorld(){return this.world;}
    public void setRobot(Robot r) {this.robot = r;}

    /**
     * run method to handle for the creation of the thread in the ServerMain.
     */
    @Override
    public void run() {
        try {
            activateRobot();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
