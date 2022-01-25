package za.co.wethinkcode.robotworlds.client.communicationHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
Creates and returns the server listener object to receive input from the server through the getListener method.
Action: Sarah, Issa
 */
public class ClientServerListener {

    private BufferedReader listener;

    public ClientServerListener(Socket clientSocket) throws IOException {
        this.listener = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public BufferedReader getListener(){
        return this.listener;}
}
