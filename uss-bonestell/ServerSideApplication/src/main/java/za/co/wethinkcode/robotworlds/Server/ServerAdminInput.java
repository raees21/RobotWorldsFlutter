package za.co.wethinkcode.robotworlds.Server;

import za.co.wethinkcode.robotworlds.Server.Domain.world.World;
import za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.ServerAdminCommand.ServerCommand;

import java.util.Scanner;

/**
 * Run method to be used for the server input thread
 * @author Issa
 */
public class ServerAdminInput implements Runnable{
    World world;

    public ServerAdminInput(){
        this.world = Server.currentWorld;
    }

    @Override
    public void run() {

        Scanner adminInput = new Scanner(System.in);

        while (true) {
            System.out.print("[SERVER ADMIN]>>>");
            String input = adminInput.nextLine();
            new ServerCommand(input);
        }
    }
}

