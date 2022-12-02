package usecases;

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
    private static ArrayList<String> LeftWires; // The list containing strings of the colours of the wires on the left side
    private static ArrayList<String> RightWires; // The list containing strings of the colours of the wires on the right side
    private static String previous;
    private static String current;

    /**
     * Constructor for WireTask.
     */
    public WireTask(){
        reset();
    }

    /**
     * Reset method, which sets up two lists with set colours in a random order.
     */
    public static void reset(){
        previous = "";
        current = "";

        LeftWires = setLeftWires();
        RightWires = setRightWires();
    }

    /**
     * A setter method for the left set of wires. Its function is to add the colours red, green and blue if the
     * list does not already contain them, then shuffle this arraylist such that colours will be in a random order each
     * time.
     */
    public static ArrayList<String> setLeftWires(){
        // Shuffles a random list from LeftWires for the left side
        if (!LeftWires.contains("RED")){
            LeftWires.add("RED");
        }
        if (!LeftWires.contains("GREEN")){
            LeftWires.add("GREEN");
        }
        if (!LeftWires.contains("BLUE")){
            LeftWires.add("BLUE");
        }
        Collections.shuffle(LeftWires);
        return LeftWires;
    }

    /**
     * A setter method for the right set of wires. Its function is to add the colours red, green and blue if the
     * list does not already contain them, then shuffle this arraylist such that colours will be in a random order each
     * time.
     */

    public static ArrayList<String> setRightWires(){
        // Shuffles a random list from RightWires for the right side
        if (!RightWires.contains("RED")){
            RightWires.add("RED");
        }
        if (!RightWires.contains("GREEN")){
            RightWires.add("GREEN");
        }
        if (!LeftWires.contains("BLUE")){
            RightWires.add("BLUE");
        }
        Collections.shuffle(RightWires);
        return RightWires;
    }

    /**
     * A setter method for both arraylists that represent the left and right wires. If the user selects correctly
     * selects two colours that are matching, remove them from both lists.
     */
    public static boolean checkWiresSelected(String first, String second) {
        // Checks whether the two last wires the user selected are matching. If so, remove the matching
        // colour from both arraylists.
        previous = first;
        current = second;

        if (previous.equals(current)) {
            LeftWires.remove(previous);
            RightWires.remove(previous);
            return true;
        }
        return false;
    }

    /**
     * A method that returns whether the task is complete or not, which happens when one of the lists of colours is
     * completely empty, meaning that the user has correctly matched all of them.
     */
    public static boolean checkCompletion(){
        if (LeftWires.isEmpty()){
            setCompletionStatus("WireTask", true);
            setActivatedStatus("WireTask", false);
        }
        return getCompletionStatus("WireTask");
    }
}
