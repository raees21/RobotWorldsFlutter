package za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.ServerAdminCommand;

import za.co.wethinkcode.robotworlds.Server.Server;
import za.co.wethinkcode.robotworlds.Server.ServerMain;
import za.co.wethinkcode.robotworlds.Server.Domain.world.World;
import za.co.wethinkcode.robotworlds.Server.persistence.DbConnect;

/**
 * Class calls the respective server commands
 */
public class ServerCommand {
    public ServerCommand(String command){
        String[] commandsList = command.split(" ");
        switch (commandsList[0]){
            case "save":
                new SaveCommand(Server.currentWorld);
                break;
            case "restore":
                new RestoreCommand();
                Server.currentWorld = DbConnect.Restoredworld;
                break;
            case "delete":
                new DeleteCommand();
                break;
            case "dump":
                new DumpCommand(Server.currentWorld);
                break;
            case "purge":
                try {
                    new PurgeCommand(commandsList[1]);
                }catch (IndexOutOfBoundsException e){System.out.println("Command requires a robot to be purged");}
                break;
            case "robots":
                new RobotsCommand(Server.currentWorld);
                break;
            case "quit":
                int i = 0;
                while (i < Server.currentWorld.getRobotHandlersAsList().size())
                    new QuitCommand();
                    i++;
                System.exit(0);
                break;
            default:
                throw new IllegalArgumentException("Cannot process your request.");
        }
    }
}

