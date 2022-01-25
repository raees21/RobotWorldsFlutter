package za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.ServerAdminCommand;

import za.co.wethinkcode.robotworlds.Server.Server;

public class RestoreCommand {
    public RestoreCommand() {
        System.out.println("WORLD STATE: ");
        Server.dbConnect.Restore();
    }
}
