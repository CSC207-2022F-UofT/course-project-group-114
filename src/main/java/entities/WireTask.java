package entities;

import java.util.ArrayList;
import java.util.Collections;

public class WireTask extends Task{

    private static ArrayList<String> LeftWires;
    // The list containing strings of the colours of the wires on the left side

    private static ArrayList<String> RightWires;
    // The list containing strings of the colours of the wires on the right side

    public WireTask(){
        reset();
    }
    public static void reset(){
        LeftWires = setLeftWires();
        RightWires = setRightWires();
    }
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

    public static boolean checkWiresSelected(String previous, String current) {
        // Checks whether the two last wires the user selected are matching. If so, remove this colour from the lists.

        if (previous.equals(current)) {
            LeftWires.remove(current);
            RightWires.remove(current);
            return true;
        }
        return false;
    }
    public static void checkCompletion(){
        if (LeftWires.isEmpty()){
            setCompletionStatus(true);
            setActivatedStatus(false);
        }
    }
}
