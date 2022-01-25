/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wethinkcode.robotworlds.client;

import org.json.simple.JSONObject;
import za.co.wethinkcode.robotworlds.client.communicationHandler.*;
import za.co.wethinkcode.robotworlds.client.protocolHandler.ClientHandleResponse;
import za.co.wethinkcode.robotworlds.client.protocolHandler.ClientMessageProtocol;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  Main run method to handle the client to server communication
 * @author Issa & Sarah
 */
public class ClientMain {

    static Scanner userInput = new Scanner(System.in);
    static ClientSocketConnection socketObject = new ClientSocketConnection();
    static ClientSendToServer sender = new ClientSendToServer();
    private static String name = "";
    public static JSONObject serverResponse;
    public static JSONObject requestToSend;
    public static String[] command;
    public static boolean proceed = true;
    public static boolean sendSuccess;


    public static void main(String args[]) throws IOException {

        try {
            Socket serverSocket = socketObject.makeConnection(args);
            if (serverSocket == null) {
                System.exit(-1);
            }
            ClientReceiveFromServer serverInput = new ClientReceiveFromServer();
            ClientServerSender clientOutput = new ClientServerSender(serverSocket);
            ClientServerListener serverListener = new ClientServerListener(serverSocket);
            while (serverSocket.isConnected()) {
                if (name.equalsIgnoreCase("")) {
                    new StdFontColor().printTextColor("You need to launch a robot into the World, command: launch <make> <name>", "blue");
                    command = splitter(userInput.nextLine().trim());
                    if (command.length != 3 || !command[0].equalsIgnoreCase("launch")) {
                        continue;
                    } else {
                        requestToSend = ClientMessageProtocol.launchRequest(command);
                        sendSuccess = sender.RequestSent(requestToSend, clientOutput);
                        if (sendSuccess) {
                            serverResponse = serverInput.getResponse(serverListener);
                            name = (String) requestToSend.get("robot");
                        }
                    }
                } else {
                    new StdFontColor().printTextColor("Enter command e.g: <command> <argument(only for steps forward/back)> ", "blue");
                    command = splitter(userInput.nextLine());
                    switch (command[0]) {
                        case "forward":
                        case "back":
                            if (command.length == 2) {
                                requestToSend = ClientMessageProtocol.movementRequest(name, command);
                            } else
                                throw new IllegalArgumentException("Only one command and an argument accepted" + command);
                            break;
                        case "turn":
                            if (command.length == 2) { //only the command to be accepted
                                requestToSend = ClientMessageProtocol.turnRequest(name, command);
                            } else throw new IllegalArgumentException("Only one command accepted" + command);
                            break;
                        case "help":
                        case "fire":
                        case "reload":
                        case "look":
                        case "state":
                        case "mine":
                        case "repair":
                        case "off":
                            if (command.length == 1) { //only the command to be accepted
                                requestToSend = ClientMessageProtocol.allOtherRequests(name, command);
                            } else throw new IllegalArgumentException("Only one command accepted" + command);
                            break;
                        default:
                            new StdFontColor().printTextColor("Unrecognised instruction", "error");
                            continue;
                    }
                    sendSuccess = sender.RequestSent(requestToSend, clientOutput);
                    if (sendSuccess) {
                        serverResponse = serverInput.getResponse(serverListener);
                        ClientHandleResponse responseObject = new ClientHandleResponse(serverResponse);
                        ArrayList<String> displayOutput = responseObject.getOutput();
                        new StdFontColor().printTextColor("Current Status:", "status");
                        for (String output : displayOutput) {
                            System.out.println(output);
                        }
                    } else {
                        new StdFontColor().printTextColor("You have been disconnected from the world", "error");
                        break;
                    }
                }
            }
        }
        catch (ConnectException e){
            new StdFontColor().printTextColor("Not connected", "error");
        } catch(SocketException e){
            new StdFontColor().printTextColor("Not connected", "error");
        }catch(NullPointerException e){
            System.out.println("DONE");
        }
    }

    private static String[] splitter(String instruction){ return instruction.toLowerCase().split(" "); }
}

