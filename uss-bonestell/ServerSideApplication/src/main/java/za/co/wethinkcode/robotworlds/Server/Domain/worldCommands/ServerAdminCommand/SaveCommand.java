package za.co.wethinkcode.robotworlds.Server.Domain.worldCommands.ServerAdminCommand;
import za.co.wethinkcode.robotworlds.Server.Server;
import za.co.wethinkcode.robotworlds.Server.Domain.world.World;

public class SaveCommand {

    public SaveCommand(World world) {
        System.out.println("WORLD STATE:");
        Server.dbConnect.Save(world);
    }
}
