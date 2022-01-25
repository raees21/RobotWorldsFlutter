package za.co.wethinkcode.robotworlds.ClientTests.MessageProtocol;
//ADD TESTS FOR THE MESSAGE PROTOCOL CLASS

import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import za.co.wethinkcode.robotworlds.client.protocolHandler.ClientMessageProtocol;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**To do - Sarah*/
public class MessageProtocolTest {


    String name;

    @BeforeEach
    void setUp(){
    }

    @Test
    public void TestLaunchRequest(){
        String[] arguments = {"launch","Bot","Sarah"};

        ClientMessageProtocol clientMessageProtocol = new ClientMessageProtocol();
        JSONObject launchRequest = clientMessageProtocol.launchRequest(arguments);

        assertEquals(launchRequest.get("robot").toString(), "Sarah");
        assertEquals(launchRequest.get("arguments").toString(),"[\"Bot\",\"2\",\"6\"]");
        assertEquals(launchRequest.get("command").toString(),"launch");
    }

    @Test
    public void TestTurnRequest(){

        String[] arguments = {"turn","right"};

        ClientMessageProtocol clientMessageProtocol = new ClientMessageProtocol();
        JSONObject turnRequest = clientMessageProtocol.turnRequest(name,arguments);

        assertEquals(turnRequest.get("command").toString(),"turn");
        assertEquals(turnRequest.get("arguments").toString(),"[\"right\"]");
    }

    @Test
    public void TestForwardMovement(){

        String[] arguments = {"forward", "10"};

        ClientMessageProtocol clientMessageProtocol = new ClientMessageProtocol();
        JSONObject moveRequest = clientMessageProtocol.movementRequest(name,arguments);

        assertEquals(moveRequest.get("command").toString(),"forward");
        assertEquals(moveRequest.get("arguments").toString(),"[\"10\"]");
    }

    @Test
    public void TestBackMovement(){
        String[] arguments = {"back", "10"};

        ClientMessageProtocol clientMessageProtocol = new ClientMessageProtocol();
        JSONObject moveRequest = clientMessageProtocol.movementRequest(name,arguments);

        assertEquals(moveRequest.get("command").toString(),"back");
        assertEquals(moveRequest.get("arguments").toString(),"[\"10\"]");
    }

    /**To be edited*/
    @Test
    public void TestStateRequest(){

        String[] arguments = {"state"};

        ClientMessageProtocol clientMessageProtocol = new ClientMessageProtocol();
        JSONObject stateRequest = clientMessageProtocol.allOtherRequests(name,arguments);

        assertEquals(stateRequest.get("command").toString(),"state");
    }

    @Test
    public void TestRepairRequest(){
        String[] arguments = {"repair"};

        ClientMessageProtocol clientMessageProtocol = new ClientMessageProtocol();
        JSONObject repairRequest = clientMessageProtocol.allOtherRequests(name,arguments);

        assertEquals(repairRequest.get("command").toString(),"repair");
        assertEquals(repairRequest.get("arguments").toString(),"[]");
    }

    @Test
    public void TestLookRequest(){
        String[] arguments = {"look"};

        ClientMessageProtocol clientMessageProtocol = new ClientMessageProtocol();
        JSONObject repairRequest = clientMessageProtocol.allOtherRequests(name,arguments);

        assertEquals(repairRequest.get("command").toString(),"look");
        assertEquals(repairRequest.get("arguments").toString(),"[]");
    }

    @Test
    public void TestReloadRequest(){
        String[] arguments = {"reload"};

        ClientMessageProtocol clientMessageProtocol = new ClientMessageProtocol();
        JSONObject repairRequest = clientMessageProtocol.allOtherRequests(name,arguments);

        assertEquals(repairRequest.get("command").toString(),"reload");
        assertEquals(repairRequest.get("arguments").toString(),"[]");
    }

    @Test
    public void TestMineRequest(){
        String[] arguments = {"mine"};

        ClientMessageProtocol clientMessageProtocol = new ClientMessageProtocol();
        JSONObject repairRequest = clientMessageProtocol.allOtherRequests(name,arguments);

        assertEquals(repairRequest.get("command").toString(),"mine");
        assertEquals(repairRequest.get("arguments").toString(),"[]");
    }
}
