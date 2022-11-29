package controller;

import entities.MemoryTask;
import javax.swing.*;

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
     * @param typedPassword the JTextField where the user has typed the password.
     * @return the boolean value returned by the checkCorrectness method in MemoryTask
     */
    public boolean passer(String actualPassword, JTextField typedPassword){
        return (MemoryTask.checkCorrectness(actualPassword, typedPassword.getText()));
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
    public static boolean getActivatedStatus() {
        return MemoryTask.getActivatedStatus("MemoryTask");
    }

}
