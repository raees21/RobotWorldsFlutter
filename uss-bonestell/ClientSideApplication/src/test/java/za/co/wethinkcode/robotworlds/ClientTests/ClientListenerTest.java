package za.co.wethinkcode.robotworlds.ClientTests;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import za.co.wethinkcode.robotworlds.client.communicationHandler.ClientReceiveFromServer;
import za.co.wethinkcode.robotworlds.client.communicationHandler.ClientServerListener;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientListenerTest {

    @Test
    public void TestListener() throws IOException {
        ServerSocket mockServer = new ServerSocket(5000);
        Socket clientSocket = new Socket("localhost", 5000);
        Socket mockServerSocket = mockServer.accept();
        ObjectOutputStream mockServerSender = new ObjectOutputStream(mockServerSocket.getOutputStream());
        ClientServerListener serverListener = new ClientServerListener(clientSocket);
        ClientReceiveFromServer receiveFromServer = new ClientReceiveFromServer();

        JSONObject testMsg = new JSONObject();
        testMsg.put("test", "working");
        mockServerSender.writeObject(testMsg);
        JSONObject received = receiveFromServer.getResponse(serverListener);
        assertEquals("working", received.get("test"));
    }
}
