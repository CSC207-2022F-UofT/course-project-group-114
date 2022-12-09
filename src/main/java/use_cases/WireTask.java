package use_cases;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A class representing the WireTask use case, which has the role of carrying out the correct function of the game task,
 * which includes resetting the task, generating two sets of colours in a random order, as well as connecting the
 * wires together.
 *
 * @author Roy
 */

public class WireTask extends Task{

    private static ArrayList<String> RemainingWires; // The list containing strings of the colours of the wires on the left side

    /**
     * Constructor for WireTask.
     */
    public WireTask(){

        reset();
    }

    /**
     * Reset method, which sets LIST.
     */
    public static void reset(){
        RemainingWires.add("RED");
        RemainingWires.add("GREEN");
        RemainingWires.add("BLUE");
    }

    public static ArrayList<String> getRemainingWires(){
        return RemainingWires;
    }

    public static void removeWire(String colour){
        if (colour.equals("RED")) {
            RemainingWires.remove("RED");
        }
        if (colour.equals("BLUE")) {
            RemainingWires.remove("BLUE");
        }
        if (colour.equals("GREEN")) {
            RemainingWires.remove("GREEN");
        }
        }

    /**
     * A method that returns whether the task is complete or not, which happens when one of the lists of colours is
     * completely empty, meaning that the user has correctly matched all of them.
     */
    public static boolean checkCompletion(){
        if (RemainingWires.isEmpty()){
            setCompletionStatus("WireTask", true);
            setActivatedStatus("WireTask", false);
        }
        return getCompletionStatus("WireTask");
    }
}
