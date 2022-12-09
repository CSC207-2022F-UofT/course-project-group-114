package controller;
import use_cases.WireTask;
import java.util.ArrayList;

/**
 * The WireTaskController class, which provides user information for WireTask to process for its use case.
 *
 * @author Roy
 */
public class WireTaskController {

    public static ArrayList<String> getRemainingColours(){
        return WireTask.getRemainingWires();
    }

    /**
     * A setter method for WireTask's completion status.
     */
    public static void setCompletionStatus(boolean status) {
        WireTask.setCompletionStatus("WireTask", status);
    }
    public static void setActivationStatus(boolean status) {

        WireTask.setActivatedStatus("WireTask", status);
    }
    public static boolean getActivatedStatus() {

        return WireTask.getActivatedStatus("WireTask");
    }

}
