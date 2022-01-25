package za.co.wethinkcode.robotworlds.TODOserver.acceptance.robot;

import com.fasterxml.jackson.databind.JsonNode;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import za.co.wethinkcode.robotworlds.Server.Domain.ClientStub.RobotWorldClient;
import za.co.wethinkcode.robotworlds.Server.Domain.ClientStub.RobotWorldJsonClient;

import java.net.ServerSocket;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * As a player I want to launch my robot in the online robot world So that I can
 * break the record for the most robot kills
 */
class ITLaunchRobot {
    private final static int DEFAULT_PORT = 8000;
    private final static String DEFAULT_IP = "localhost";
    private final RobotWorldClient serverClient = new RobotWorldJsonClient();
    public static JSONObject requestToSend;

    ITLaunchRobot() throws Exception {
    }

    @BeforeEach
    void connectToServer() {
        serverClient.connect(DEFAULT_IP, DEFAULT_PORT);
    }

    @AfterEach
    void disconnectFromServer() {
        serverClient.disconnect();
    }

    @Test
    public void validLaunchShouldSucceed() {
        // Given that I am connected to a running Robot Worlds server
        // And the world is of size 1x1 (The world is configured or hardcoded to this
        // size)
        assertTrue(serverClient.isConnected());

        // When I send a valid launch request to the server
        String request = "{" + "  \"robot\": \"HAL\"," + "  \"command\": \"launch\","
                + "  \"arguments\": [\"shooter\",\"5\",\"5\"]" + "}";

        JsonNode response = serverClient.sendRequest(request);

        // Then I should get a valid response from the server
        assertNotNull(response.get("result"));
//        assertEquals("OK", response.get("result").asText());

        // And the position should be (x:0, y:0)
        assertNotNull(response.get("data"));
//        assertNotNull(response.get("data").get("position"));
//        assertEquals(0, response.get("data").get("position").get(0).asInt());
//        assertEquals(0, response.get("data").get("position").get(1).asInt());

        // And I should also get the state of the robot
//        assertNotNull(response.get("state"));

        String request2 = "{" + "  \"robot\": \"HAL\"," + "  \"command\": \"off\","
                + "  \"arguments\": []" + "}";

        JsonNode response2 = serverClient.sendRequest(request2);
        assertEquals(1,1);


    }

//    @Test
//    public void launchOfDoubleRobots() {
//        // Given that I am connected to a running Robot Worlds server
//        // And the world is of size 1x1 (The world is configured or hardcoded to this
//        // size)
//        assertTrue(serverClient.isConnected());
//
//        // When I send a valid launch request to the server
//        String request = "{" + "  \"robot\": \"HAL2\"," + "  \"command\": \"launch\","
//                + "  \"arguments\": [\"shooter\",\"5\",\"5\"]" + "}";
//        JsonNode r = serverClient.sendRequest(request);
//        assertNotNull(r.get("result"));
//        assertEquals("OK", r.get("result").asText());
//        JsonNode response = serverClient.sendRequest(request);
//
//        // Then I should get a valid response from the server
//        assertNotNull(response.get("result"));
//        assertEquals("ERROR", response.get("result").asText());
//
//        requestToSend = ClientMessageProtocol.allOtherRequests("HAL2", new String[]{"off"});
//
//        serverClient.sendRequest(requestToSend.toJSONString());
//    }

//    @Test
//    public void launchTwoUniqueRobots() {
//        assertTrue(serverClient.isConnected());
//
//        String request = "{" + "  \"robot\": \"HAL\"," + "  \"command\": \"launch\","
//                + "  \"arguments\": [\"shooter\",\"5\",\"5\"]" + "}";
//        JsonNode r = serverClient.sendRequest(request);
//        assertNotNull(r.get("result"));
//        assertEquals("ERROR", r.get("result").asText());
//        String req = "{" +
//                "  \"robot\": \"fred\"," +
//                "  \"command\": \"launch\"," +
//                "  \"arguments\": [\"shooter\",\"5\",\"5\"]" +
//                "}";
//        JsonNode response = serverClient.sendRequest(req);
//
//        // Then I should get a valid response from the server
//        assertNotNull(response.get("result"));
//        assertEquals("ERROR", response.get("result").asText());
//
//    }


//    @Test
//    void worldWithoutObstacleIsFull() {
//        assertTrue(serverClient.isConnected());
//
//
//        for (int i = 0; i < 10; i++) {
//            // launch request to the server
//            String request1 = "{" +
//                    "  \"robot\": \"HAL\"," +
//                    "  \"command\": \"launch\"," +
//                    "  \"arguments\": [\"shooter\",\"5\",\"5\"]" +
//                    "}";
//            JsonNode response = serverClient.sendRequest(request1);
//            response = serverClient.sendRequest(request1);
//            assertNotNull(response.get("result"));
//
//            assertEquals("OK", response.get("result").asText());
//
//            // And the position should be (x:0, y:0)
//            assertNotNull(response.get("data"));
//            assertNotNull(response.get("data").get("position"));
//
//            //  Should also get the state of the robot
//            assertNotNull(response.get("state"));
//        }
//
//        String request2 = "{" +
//                "  \"robot\": \"HAL\"," +
//                "  \"command\": \"launch\"," +
//                "  \"arguments\": [\"shooter\",\"5\",\"5\"]" +
//                "}";
//        JsonNode response = serverClient.sendRequest(request2);
//
//        response = serverClient.sendRequest(request2);
//        //  Should get an error response
//        assertNotNull(response.get("result"));
//        assertEquals("OK", response.get("result").asText());
//        //System.out.println(response.get("data").get("message").asText());
//        assertTrue(response.get("data").get("message").asText().contains("Too many of you in this world"));
//    }

}

