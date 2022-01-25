package za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.ServerAdminCommand;

import za.co.wethinkcode.robotworlds.Server.Server;


public class DeleteCommand {

    public DeleteCommand() {
        System.out.println("WORLD STATE:");
        Server.dbConnect.Delete();
    }
}
