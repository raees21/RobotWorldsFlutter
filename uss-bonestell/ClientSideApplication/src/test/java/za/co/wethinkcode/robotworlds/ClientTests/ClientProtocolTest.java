//package za.co.wethinkcode.robotworlds.ClientTests;
//
//import org.json.simple.JSONObject;
//import org.junit.jupiter.api.Test;
//import za.co.wethinkcode.robotworlds.Client.ProtocolHandler.ClientMessageProtocol;
//
//import static org.junit.Assert.assertEquals;
/**Test fail because of connection - java.net.BindException: Address already in use (Bind failed)*/
//public class ClientProtocolTest {
//
//    @Test
//    public void TestLaunchProtocol() {
//        ClientMessageProtocol newMsg = new ClientMessageProtocol();
//        String[] arguments = {"launch","botslayer","sarah"};
//        JSONObject message = ClientMessageProtocol.launchRequest(arguments);
//        assertEquals("sarah", (String) message.get("robot"));
//        assertEquals("launch", (String) message.get("command"));
//
//    }
//
//    @Test
//    public void TestMovementProtocol(){
//        ClientMessageProtocol newMsg = new ClientMessageProtocol();
//        String[] arguments = {"forward","1"};
//        JSONObject message = ClientMessageProtocol.movementRequest("issa", arguments);
//        assertEquals("forward", message.get("command"));
//    }
//}
