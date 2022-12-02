package controller;
import usecases.WireTask;

/**
 * The WireTaskController class, which provides user information for WireTask to process for its use case.
 *
 * @author Roy
 */
public class WireTaskController {

    /**
     * A setter method for the last two colours the user selected. If they are matching, remove them both from the list
     */
    public static boolean check_matching(String first, String second){
        return WireTask.checkWiresSelected(first, second);
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
