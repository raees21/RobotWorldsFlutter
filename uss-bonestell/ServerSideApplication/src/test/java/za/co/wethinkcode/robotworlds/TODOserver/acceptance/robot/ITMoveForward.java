package za.co.wethinkcode.robotworlds.TODOserver.acceptance.robot;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import za.co.wethinkcode.robotworlds.Server.Domain.ClientStub.RobotWorldClient;
import za.co.wethinkcode.robotworlds.Server.Domain.ClientStub.RobotWorldJsonClient;

import static org.junit.jupiter.api.Assertions.*;


public class ITMoveForward {

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
//
//
//    @Test
//    void ForwardInvalid() {
//        connectToServer();
//        assertTrue(serverClient.isConnected());
//
//        String request = "{" +
//                "  \"robot\": \"HAL\"," +
//                "  \"command\": \"forward\"," +
//                "  \"arguments\": [\"1\"]" +
//                "}";
//        JsonNode response = serverClient.sendRequest(request);
//
//        assertEquals("ERROR", response.get("result").asText());
//        assertNotNull(response.get("data").get("message"));
//        assertEquals("\"Robot does not exist\"",response.get("data").get("message").toString());
//
//    }
//
//    @Test
//    void ForwardValid() {
//        connectToServer();
//        assertTrue(serverClient.isConnected());
//
//        String request = "{" +
//                "  \"robot\": \"HAL\"," +
//                "  \"command\": \"forward\"," +
//                "  \"arguments\": [\"3\"]" +
//                "}";
//        JsonNode response = serverClient.sendRequest(request);
//
//        assertEquals("ERROR", response.get("result").asText());
//        assertNotNull(response.get("data").get("message"));
//
//        assertEquals("\"Robot does not exist\"",response.get("data").get("message").toString());
////        assertNotNull(response.get("state"));
////        assertEquals("[0,0]",response.get("state").get("position").toString());
//
//    }
}

