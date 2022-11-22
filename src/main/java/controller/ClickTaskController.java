package controller;

import entities.ClickTask;

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
       ClickTask.setCompletionStatus(status);
    }
    public static void setActivatedStatus(boolean status) {
        ClickTask.setActivatedStatus(status);
    }
}