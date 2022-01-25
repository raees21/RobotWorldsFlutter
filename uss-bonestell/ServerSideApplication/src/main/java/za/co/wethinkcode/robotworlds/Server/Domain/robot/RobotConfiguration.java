package za.co.wethinkcode.robotworlds.Server.Domain.robot;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;

/**
 * Class reads and returns data from the JSON config file to the Server.
 * Action: Issa
 */

public class RobotConfiguration {
        private long visibility, reload, repair, mine, shield,shots, port;
        private JSONObject world;
        private JSONParser parser = new JSONParser();
        private JSONObject configData;

        private String worldconfig = "{\"visibility\": 15,\n" +
                "\"reload\": 5,\n" +
                "\"repair\": 5,\n" +
                "\"mine\": 7,\n" +
                "\"shield\": 5,\n" +
                "\"shots\": 5,\n" +
                "\"port\": 5000,\n" +
                "\"world\": {\n" +
                "  \"height\": 1,\n" +
                "  \"width\": 1\n" +
                "  }\n" +
                "}\n";

        public RobotConfiguration(){
                String configPath = "/ServerSideApplication/src/main/java/za/co/wethinkcode/robotworlds/Server/configuration.json";
                String file = new File(   "").getAbsolutePath().replace("/ServerSideApplication", "");
                try{
                        this.configData = (JSONObject) parser.parse(worldconfig);
                        this.visibility = (long) this.configData.get("visibility");
                        this.reload = (long) this.configData.get("reload");
                        this.repair = (long) this.configData.get("repair");
                        this.mine = (long) this.configData.get("mine");
                        this.shield = (long) this.configData.get("shield");
                        this.shots = (long) this.configData.get("shots");
                        this.port = (long) this.configData.get("port");
                        this.world = (JSONObject) this.configData.get("world");
                } catch (ParseException e) {
                        System.out.println("Error occurred whilst parsing the configuration file");
                        e.printStackTrace();
                } catch (Exception e){
                        System.out.println("Could not read data from configuration Data " + e);
                }
        }

        /**
         * Getter methods to return the world configurations.
         * @return world configurations
         */
        public int getVisibility(){return (int)this.visibility;}

        public int getReload() { return (int)this.reload; }

        public int getRepair() { return (int)this.repair; }

        public int getMine() { return (int)this.mine; }

        public int getShield() { return (int)this.shield; }

        public int getPort() { return (int)this.port; }

        public int getShots(){ return (int)this.shots; }

        public JSONObject getWorld(){return this.world; }
}
