package za.co.wethinkcode.robotworlds.client.protocolHandler;

import org.json.simple.JSONObject;

import java.util.ArrayList;

/**
Class to process the JSONObject returned by the server. Methods should return a String
that will in turn be displayed to the user
Action: Sarah & Issa
 */
public class ClientHandleResponse {

    JSONObject responseReceived;
    String result;
    String data;
    String state;

    public ClientHandleResponse(JSONObject responseReceived) {
        this.responseReceived = responseReceived;
        this.result = "No result";
        this.data = "No data";
        this.state = "No status";
    }


    private String parseResult() {
        if (this.responseReceived.containsKey("result")){this.result = (String) this.responseReceived.get("result");}
        return this.result;
    }

    private String parseData(){
        if (this.responseReceived.containsKey("data")){this.data = (String) this.responseReceived.get("data").toString();}
        return this.data;
    }

    private String parseState(){
        if (this.responseReceived.containsKey("state")){this.state = (String) this.responseReceived.get("state").toString();}
        return this.state;
    }

    public ArrayList<String> getOutput(){
        ArrayList<String> displayOutput = new ArrayList<>();
        displayOutput.add(parseResult());
        displayOutput.add(parseData());
        displayOutput.add(parseState());
        return displayOutput;
    }
}