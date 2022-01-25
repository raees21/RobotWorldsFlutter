package za.co.wethinkcode.robotworlds.TODOserver.acceptance.robot;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import za.co.wethinkcode.robotworlds.Server.Domain.ClientStub.RobotWorldClient;
import za.co.wethinkcode.robotworlds.Server.Domain.ClientStub.RobotWorldJsonClient;

import static org.junit.jupiter.api.Assertions.*;

public class ITGetState {
//    private final static int DEFAULT_PORT = 8000;
//    private final static String DEFAULT_IP = "localhost";
//    private final RobotWorldClient serverClient = new RobotWorldJsonClient();
//
//    @BeforeEach
//    void connectToServer(){
//        serverClient.connect(DEFAULT_IP, DEFAULT_PORT);
//    }
//
//    @AfterEach
//    void disconnectFromServer(){
//        serverClient.disconnect();
//    }
//    @Test
//    public void launchRobot() {
//        String request = "{" +
//                "  \"robot\": \"HAL\"," +
//                "  \"command\": \"launch\"," +
//                "  \"arguments\": [\"shooter\",\"5\",\"5\"]" +
//                "}";
//        JsonNode response = serverClient.sendRequest(request);
//    }
//
//    @Test
//    public void validRequestShouldSucceed() {
//        assertTrue(serverClient.isConnected());
//        launchRobot();
//        String request = "{" +
//            "\"robot\": \"HAL\", " +
//            "\"command\": \"state\","+
//                "\"arguments\": []"+
//        "}";
//
//        JsonNode response = serverClient.sendRequest(request);
//
//        assertNotNull(response.get("result"));
//        assertEquals("OK", response.get("result").asText());
//
//        assertNotNull(response.get("state"));
//    }
//
//    @Test
//    public void invalidRequestShouldFail() {
//        assertTrue(serverClient.isConnected());
//        launchRobot();
//        String request = "{" +
//                "\"robot\": \"HA\", " +
//                "\"command\": \"state\","+
//                "\"arguments\": []"+
//                "}";
//
//        JsonNode response = serverClient.sendRequest(request);
//
//        assertNotNull(response.get("result"));
//        assertEquals("ERROR", response.get("result").asText());
//
//        assertNull(response.get("state"));
//    }
//
//    @Test
//    public void validDirection() {
//        assertTrue(serverClient.isConnected());
//        launchRobot();
//        String request = "{" +
//                "\"robot\": \"HAL\", " +
//                "\"command\": \"state\","+
//                "\"arguments\": []"+
//                "}";
//
//        JsonNode response = serverClient.sendRequest(request);
//
//        assertNotNull(response.get("result"));
//        assertEquals("OK", response.get("result").asText());
//
//        assertNotNull(response.get("state").get("direction"));
//        assertEquals(response.get("state").get("direction").asText(), "NORTH");
//    }
}
