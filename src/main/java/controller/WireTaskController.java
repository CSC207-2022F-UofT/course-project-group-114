package controller;
import use_cases.WireTask;


/**
 * The WireTaskController class, which provides user information for WireTask to process for its use case.
 *
 * @author Roy
 */
public class WireTaskController {


    public static void removeColour(String colour){
        WireTask.removeWire(colour);
    }

    public static void reset(){
        WireTask.reset();
    }

    /**
     * A setter method for WireTask's completion status.
     */
    public static void setCompletionStatus(boolean status) {
        WireTask.setCompletionStatus("WireTask", status);
    }
    public static boolean getActivatedStatus() {

        return WireTask.getActivatedStatus("WireTask");
    }

}
