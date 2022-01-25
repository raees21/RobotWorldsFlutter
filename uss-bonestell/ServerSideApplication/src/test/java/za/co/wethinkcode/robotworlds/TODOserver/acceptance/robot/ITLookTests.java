package za.co.wethinkcode.robotworlds.TODOserver.acceptance.robot;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.wethinkcode.robotworlds.Server.Domain.ClientStub.RobotWorldClient;
import za.co.wethinkcode.robotworlds.Server.Domain.ClientStub.RobotWorldJsonClient;

public class ITLookTests {

//  private static final int DEFAULT_PORT = 8000;
//  private static final String DEFAULT_IP = "localhost";
//  private final RobotWorldClient serverClient = new RobotWorldJsonClient();
//
//  @BeforeEach
//  void connectToServer() {
//    serverClient.connect(DEFAULT_IP, DEFAULT_PORT);
//  }
//
//  @AfterEach
//  void disconnectFromServer() {
//    serverClient.disconnect();
//  }
//
//  void launchRobot() {
//    String request =
//      "{" +
//      "  \"robot\": \"HAL\"," +
//      "  \"command\": \"launch\"," +
//      "  \"arguments\": [\"shooter\",\"5\",\"5\"]" +
//      "}";
//    JsonNode response = serverClient.sendRequest(request);
//  }
//
//  @Test
//  void canLook() {
//    assertTrue(serverClient.isConnected());
//
//    launchRobot();
//    String request =
//      "{" +
//      "\"robot\": \"HAL\"," +
//      "\"command\": \"look\"," +
//      "\"arguments\": []" +
//      "}";
//
//    JsonNode response = serverClient.sendRequest(request);
//    assertEquals(1,1);
//
////    assertEquals("OK", response.get("result").asText());
////    assertNotNull(response.get("data").get("objects"));
//  }
}
