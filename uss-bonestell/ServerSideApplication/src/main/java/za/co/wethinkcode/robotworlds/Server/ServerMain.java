/**
 * @authors Issa & Thonifho
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wethinkcode.robotworlds.Server;

import org.apache.commons.cli.*;
import za.co.wethinkcode.robotworlds.Server.Domain.robot.RobotHandler;
import za.co.wethinkcode.robotworlds.Server.api.Api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Server Main Class to run the server and create the multi thread
 * for connected clients
 */
public class ServerMain {
    private static Server s;

    public static void main(String[] args) { //IO heads up
        try {
            s  = new Server(args);
            s.run();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

