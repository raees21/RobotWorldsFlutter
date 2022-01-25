package za.co.wethinkcode.robotworlds.client.communicationHandler;

import za.co.wethinkcode.robotworlds.client.StdFontColor;

import java.io.*;
import java.net.Socket;

/**
Sends a message to Server and returns true if the message goes through
and false if it's not sent.
Action - Issa & Sarah
 */

public class ClientServerSender {

//    private ObjectOutputStream sender;
    private PrintStream sender;

    public ClientServerSender(Socket socket) throws IOException {
        this.sender = new PrintStream(socket.getOutputStream());
    }

    public PrintStream getSender() {
        return this.sender;}

}
