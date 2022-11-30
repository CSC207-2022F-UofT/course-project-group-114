package controller;

import entities.MemoryTask;

/**
 * The controller for the Memory Task which is responsible to take inputs from the view and
 * convert them to appropriate datatypes for the use case; thus acting like a passer between them.
 *
 * @author Kaavya Kalani
 */
public class MemoryTaskController {

    /**
     * Takes inputs passed by MemoryTaskView and converts them to appropriate
     * datatypes for the use case and passes it to them.
     *
     * @param actualPassword the String which was generated and expected to be typed.
     * @param typedPassword the String which the user has typed.
     * @return the boolean value returned by the checkCorrectness method in MemoryTask
     */
    public boolean passer(String actualPassword, String typedPassword){
        return (MemoryTask.checkCorrectness(actualPassword, typedPassword));
    }

    /**
     * sets the CompletionStatus of the MemoryTask to the boolean passed
     * @param status boolean value the CompletionStatus of the MemoryTask needs to be set to
     */
    public static void setCompletionStatus(boolean status) {
        MemoryTask.setCompletionStatus("MemoryTask", status);
    }

    /**
     * sets the ActivatedStatus of the MemoryTask to the boolean passed
     * @param status boolean value the ActivatedStatus of the MemoryTask needs to be set to
     */
    public static void setActivatedStatus(boolean status) {
        MemoryTask.setActivatedStatus("MemoryTask", status);
    }

    /**
     * gets the ActivatedStatus of the Memory Task
     * @return boolean value associated with Activated Status
     */
    public static boolean getActivatedStatus() {
        return MemoryTask.getActivatedStatus("MemoryTask");
    }

}
