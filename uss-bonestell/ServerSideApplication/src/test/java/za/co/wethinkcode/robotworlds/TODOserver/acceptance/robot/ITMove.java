package za.co.wethinkcode.robotworlds.TODOserver.acceptance.robot;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import za.co.wethinkcode.robotworlds.Server.Domain.ClientStub.RobotWorldClient;
import za.co.wethinkcode.robotworlds.Server.Domain.ClientStub.RobotWorldJsonClient;

import static org.junit.jupiter.api.Assertions.*;


public class ITMove {

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
//
//    void launchRobot() {
//        String request = "{" +
//                "  \"robot\": \"HAL\"," +
//                "  \"command\": \"launch\"," +
//                "  \"arguments\": [\"shooter\",\"5\",\"5\"]" +
//                "}";
//        JsonNode response = serverClient.sendRequest(request);
//    }
//
//    JsonNode getState() {
//        String request = "{" +
//                "\"robot\": \"HAL\"," +
//                "\"command\": \"state\"," +
//                "\"arguments\": []" +
//                "}";
//        JsonNode response = serverClient.sendRequest(request);
//        return response.get("state");
//    }
//
//    @Test
//    void ForwardTest() {
//        assertTrue(serverClient.isConnected());
//
//        launchRobot();
//        String request = "{" +
//                "  \"robot\": \"HAL\"," +
//                "  \"command\": \"forward\"," +
//                "  \"arguments\": [\"1\"]" +
//                "}";
//        JsonNode response = serverClient.sendRequest(request);
//
//        assertEquals(1,1);
//
////        assertEquals("OK", response.get("result").asText());
//    }
}