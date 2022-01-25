package za.co.wethinkcode.robotworlds.client;

import java.util.HashMap;


/**
 * Class sets color of the out put, and prints to stdOut.
 * @author Thoni
 */
public class StdFontColor {
    HashMap validColors;

    public StdFontColor() {
        validColors = new HashMap();
        validColors.put("status" , "\n\033[32m[Status] ");
        validColors.put("server" , "\n\033[35m[Server] ");
        validColors.put("blue" , "\033[34m");
        validColors.put("error" , "\n\033[31m[Error] ");
        validColors.put("note" , "\033[33m  > Note: ");
        validColors.put("reset" , "\033[30m");
    }

    /**
     * Method sets color of text
     * @param text the String to be outputted.
     * @param color the required color to output in.
     */
    public void printTextColor(String text, String color) {
        if (this.validColors.containsKey(color))
            System.out.println(validColors.get(color)+text+validColors.get("reset"));
        else
            System.out.println(text);
    }
}
