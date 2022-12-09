package use_cases;

import java.util.ArrayList;

/**
 * A class representing the WireTask use case, which has the role of carrying out the correct function of the game task,
 * which includes resetting the task, generating two sets of colours in a random order, as well as connecting the
 * wires together.
 *
 * @author Roy
 */

public class WireTask extends Task{

    @ SuppressWarnings("all") // We need RemainingWires for the correct function of the other classes
    private static final ArrayList<String> RemainingWires = new ArrayList<>(); // The list containing strings of the colours of the wires on the left side

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

}
