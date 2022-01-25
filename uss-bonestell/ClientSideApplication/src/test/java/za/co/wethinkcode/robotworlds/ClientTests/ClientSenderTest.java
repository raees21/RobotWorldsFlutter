package za.co.wethinkcode.robotworlds.ClientTests;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import za.co.wethinkcode.robotworlds.client.communicationHandler.ClientSendToServer;
import za.co.wethinkcode.robotworlds.client.communicationHandler.ClientServerSender;
import za.co.wethinkcode.robotworlds.client.communicationHandler.ClientSocketConnection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.Assert.assertTrue;

public class ClientSenderTest {

    @Test
    public void TestSenderObject() throws IOException {
        ServerSocket mockServer = new ServerSocket(5000);
        String[] args = {"localhost", "5000"};
        JSONObject testMsg = new JSONObject();
        ClientSocketConnection clientSocketConnection = new ClientSocketConnection();
        Socket clientSocket = clientSocketConnection.makeConnection(args);
        ClientServerSender senderObj = new ClientServerSender(clientSocket);
        ClientSendToServer sender = new ClientSendToServer();
        boolean tester = sender.RequestSent(testMsg, senderObj);
        assertTrue(tester);
    }
}
