package controller;

import entities.ClickTask;

/**
 * The ClickTaskController class passes information between the ClickTask
 * and the ClickTaskView.
 *
 * @author Siyuan Deng
 */
public class ClickTaskController {
    public static void setNeededClicks(){
       ClickTask.setNeededClicks();
   }
    public static void setCurrentClicks(int newCurrentClicks){
        ClickTask.setCurrentClicks(newCurrentClicks);
    }

    public static int getNeededClicks(){
        return ClickTask.getNeededClicks();
    }

    public static int getCurrentClicks(){
        return ClickTask.currentClicks;
    }

    public static boolean getPortion(){
        return ClickTask.portion;
    }

    public static void reset(){
        ClickTask.reset();
    }

    public static void setCompletionStatus(boolean status) {
       ClickTask.setCompletionStatus("ClickTask", status);
    }
    public static void setActivatedStatus(boolean status) {
        ClickTask.setActivatedStatus("ClickTask", status);
    }
    public static boolean getActivatedStatus() {
        return ClickTask.getActivatedStatus("ClickTask");
    }
}