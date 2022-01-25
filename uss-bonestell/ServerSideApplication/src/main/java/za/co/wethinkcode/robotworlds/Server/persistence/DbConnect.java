package za.co.wethinkcode.robotworlds.Server.persistence;

import org.jetbrains.annotations.NotNull;
import za.co.wethinkcode.robotworlds.Server.Domain.world.obstacles.Obstacle;
import za.co.wethinkcode.robotworlds.Server.persistence.pkg.DBCreate;
import za.co.wethinkcode.robotworlds.Server.persistence.pkg.DBDelete;
import za.co.wethinkcode.robotworlds.Server.persistence.pkg.DBRead;
import za.co.wethinkcode.robotworlds.Server.persistence.pkg.DBUpdate;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.Robot;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.RobotHandler;
import za.co.wethinkcode.robotworlds.Server.Domain.world.World;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
// import java

/**
 * DbTest is a small command-line tool used to check that we can connect to a SQLite database.
 *
 * By default (without any command-line arguments) it attempts to create a SQLite table in an in-memory database.
 * If it succeeds, we assume that all the working parts we need to use SQLite databases are in place and working.
 *
 * The only command-line argument this app understands is
 *  `-f <filename>`
 *  which tells that application to create the test table in a real (disk-resident) database named by the given
 *  filename. Note that the application _does not delete_ the named file, but leaves it in the filesystem
 *  for later examination if desired.
 */
public class DbConnect implements DBWrapper{
    String dbUrl;
    private DBCreate dbCreate;
    private DBDelete dbDelete;
    private DBUpdate dbUpdate;
    private DBRead dbRead;
    public static World Restoredworld = new World();


    public static Connection connection;

    public DbConnect() {
        String name = "ServerSideApplication/src/main/resources/DatabaseRobotWorlds.db";

        this.dbUrl = "jdbc:sqlite:"+name;
        System.out.println(dbUrl);
        try {
            connection = DBConnection();
        } catch (Exception e) {}
        System.out.println(connection);

        dbCreate = new DBCreate();
        dbDelete = new DBDelete();
        dbRead = new DBRead();
    }

    public Connection DBConnection() throws SQLException {
        final Connection connection = DriverManager.getConnection( this.dbUrl );
        return connection;
    }

    private void runTest( Connection connection ) {
        try( final Statement stmt = connection.createStatement() ){
            stmt.executeUpdate( "CREATE TABLE test( test_id, success )" );
            System.out.println( "Success creating test table!" );
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
    }

    /** Creates New Data in the database
     * */
    public void CreateOne(Obstacle o) { dbCreate.CreateOne(o); }
    public void CreateOne(World o) { dbCreate.CreateOne(o); }
    public void CreateOne(Robot o) { dbCreate.CreateOne(o); }
    public void AddRobots(@NotNull List<RobotHandler> obs) { dbCreate.AddRobots(obs);}
    public void AddObstacles(@NotNull List<Obstacle> obs) { dbCreate.AddObstacles(obs);}
    public void DeleteAll(){dbDelete.DeleteAll();}
    public void RestoreWorld(){dbRead.ReadWorld(Restoredworld);}
    public void Save(World world) {
        CreateOne(world);
        AddObstacles(world.getObstacles());
        AddRobots(world.getRobotHandlersAsList());
    }
    public void Restore(){
        RestoreWorld();
    }
    public  void Delete() {DeleteAll();}
    }