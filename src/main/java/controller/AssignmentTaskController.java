package controller;
import usecases.AssignmentTask;

/**
 * A class representing the AssignmentTaskController, which is responsible for communicating
 * with the AssignmentTask use case class to retrieve information needed for
 * the AssignmentTaskView's computations.
 *
 * @author uoft-flyfreejay
 */
public class AssignmentTaskController {
    /**
     * A getter method for the AssignmentTask's character needed to complete.
     * @return integer that presents number of characters needed to finish the task
     */
    public static int getCharacterCountNeeded(){
        return AssignmentTask.getCharacterCountNeeded();
    }

    /**
     * A method to validate whether current character count satisfies the AssignmentTask character requirement
     * @return boolean if the mini-game has been successfully completed
     */
    public static boolean validate(int currentCharacterCount){
        AssignmentTask.setCurrentCharacterCount(currentCharacterCount);
        AssignmentTask.checkCount();
        return AssignmentTask.getCompletionStatus("AssignmentTask");
    }
    /**
     * A setter method that sets the current completion status as the given parameter
     * @param status completion status of the mini-game to set
     */
    public static void setCompletionStatus(boolean status) {
        AssignmentTask.setCompletionStatus("AssignmentTask", status);
    }
    /**
     * A setter method that sets the current activation status as the given parameter
     * @param status activation status of the mini-game to set
     */
    public static void setActivatedStatus(boolean status) {
        AssignmentTask.setActivatedStatus("AssignmentTask", status);
    }
    /**
     * A getter method that returns the current activated status of AssignmentTask
     * @return returns the current activated status of AssignmentTask
     */
    public static boolean getActivatedStatus() {
        return AssignmentTask.getActivatedStatus("AssignmentTask");
    }
}
