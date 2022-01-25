package za.co.wethinkcode.robotworlds.Server;

import java.util.HashMap;


/**
 * Class sets color of the out put, and prints to stdOut.
 * @author Thoni
 */
public class StdFontColor {
    HashMap validColors;

    public StdFontColor() {
        validColors = new HashMap();
        validColors.put("status" , "\033[32m");
        validColors.put("client" , "\033[35m");
        validColors.put("blue" , "\033[34m");
        validColors.put("error" , "\033[31m");
        validColors.put("note" , "\033[33m");
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
