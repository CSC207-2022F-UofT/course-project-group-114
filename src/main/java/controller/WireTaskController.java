package controller;
import entities.WireTask;


public class WireTaskController {

    public static void

    public static void checker(String first, String second){
        boolean selected = WireTask.checkWiresSelected(first, second);
        if (selected){
            WireTask.checkCompletion();
        }
    }
    public static void setCompletionStatus(boolean status) {
        WireTask.setCompletionStatus(status);
    }

    public static void setActivationStatus(boolean status) {
        WireTask.setActivatedStatus(status);
    }

}
