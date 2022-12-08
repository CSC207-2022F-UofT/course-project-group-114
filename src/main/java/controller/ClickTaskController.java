package controller;

import usecases.ClickTask;

/**
 * The ClickTaskController class passes information between the ClickTask
 * and the ClickTaskView.
 *
 * @author Siyuan Deng
 */
public class ClickTaskController {

    /**
     * This method sets the number of neededClicks generated from the ClickTask class.
     */
    public static void setNeededClicks(){
       ClickTask.setNeededClicks();
   }

    /**
     * This method change the currentClicks instance of a ClickTask object by accessing
     * through ClickTaskController.
     * @param newCurrentClicks the new number of clicks, which is the new value
     *                         of currentClicks.
     */
    public static void setCurrentClicks(int newCurrentClicks){
        ClickTask.setCurrentClicks(newCurrentClicks);
    }

    /**
     * This method gets the number of neededClicks from the ClickTask class.
     *
     * @return The method returns the number of neededClicks.
     */
    public static int getNeededClicks(){
        return ClickTask.getNeededClicks();
    }

    /**
     * This method access the number of currentClicks in ClickTask class.
     *
     * @return The method returns the number of currentClicks.
     */
    public static int getCurrentClicks(){
        return ClickTask.currentClicks;
    }

    /**
     * This method change the currentClicks instance of a ClickTask object by accessing
     * through ClickTaskController.
     *
     * @return The method returns the portion instance in ClickTask class.
     */
    public static boolean getPortion(){
        return ClickTask.portion;
    }

    /**
     * This method resets a ClickTask game, meaning a new neededClicks will be generated and
     * currentClicks will be set to 0.
     */
    public static void reset(){
        ClickTask.reset();
    }

    /**
     * This method sets the completion status for a Click Task.
     */
    public static void setCompletionStatus(boolean status) {
       ClickTask.setCompletionStatus("ClickTask", status);
    }

    /**
     * This method sets the activation status for a Click Task.
     */
    public static void setActivatedStatus(boolean status) {
        ClickTask.setActivatedStatus("ClickTask", status);
    }

    /**
     * This method gets the activation status for a Click Task.
     *
     * @return True if a Click Task is activated.
     */
    public static boolean getActivatedStatus() {
        return ClickTask.getActivatedStatus("ClickTask");
    }
}