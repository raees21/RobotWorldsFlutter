package za.co.wethinkcode.robotworlds.Server.api;

import java.util.List;

public class DataModelRobot {
    public static class command {
        public String robot;
        public String command;
        public List<String> arguments;
    }

    public static class response {
        public String result;
        public String data;
        public state state;
    }

    public static class state {
        public List<Integer> position;
        public String direction;
        public Integer shields;
        public Integer shots;
        public String status;
    }
}
