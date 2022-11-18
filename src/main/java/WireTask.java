import java.util.ArrayList;
import java.util.Collections;

public class WireTask{

    public static ArrayList<String> LeftWires;
    // The list containing strings of the colours of the wires on the left side

    public static ArrayList<String> RightWires;
    // The list containing strings of the colours of the wires on the right side

    public static ArrayList<String> Completed;
    // The list containing strings of the colours which have been successfully matched together

    public static String previous;
    // The node that the user clicked before currentClick. If the user did not click anything or only clicked once
    // , then previous is set to Null.

    public static String current;
    // The node that the user last clicked. If the user did not click anything, then current is Null.


    public ArrayList<String> setLeftWires(){
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

    public ArrayList<String> setRightWires(){
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

    public static boolean checkWires() {
        if (current.equals(previous)) {
            Completed.add(current);

        }
        return true;
    }
}
