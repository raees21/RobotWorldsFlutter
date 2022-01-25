//package za.co.wethinkcode.robotworlds.ClientTests;
//
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import za.co.wethinkcode.robotworlds.Client.CommunicationHandler.ClientSocketConnection;
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.List;
/**Test fail because of connection - java.net.BindException: Address already in use (Bind failed)*/
//
//import static org.junit.Assert.assertTrue;
//
//public class ConnectionTest {
//
//    @Test
//    //FIX THE TEST< CONNECTION FAILS
//    public void TestConnection() throws IOException {
//        ServerSocket mockServer = new ServerSocket(9080);
//        String[] args = {"localhost", "9080"};
//        ClientSocketConnection clientSocketConnection = new ClientSocketConnection();
//        Socket clientSocket = clientSocketConnection.makeConnection(args);
//        DataOutputStream messageToServer = new DataOutputStream(clientSocket.getOutputStream());
//        Socket server = mockServer.accept();
//        DataInputStream incomingMessage = new DataInputStream(server.getInputStream());
//        messageToServer.writeUTF("Connected to server");
//        String toCheck = incomingMessage.readUTF();
//
//        assertTrue(toCheck.equalsIgnoreCase("connected to server"));
//
//        clientSocket.close();
//        mockServer.close();
//        server.close();
//    }
//}
