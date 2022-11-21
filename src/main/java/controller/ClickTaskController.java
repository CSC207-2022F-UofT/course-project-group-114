package controller;

import entities.ClickTask;

public class ClickTaskController {
    private static int neededClicks;
    private static int currentClicks;


   public static void setNeededClicks(){
       ClickTask.setNeededClicks();
   }
    public static void setCurrentClicks(int newCurrentClicks){
        currentClicks = newCurrentClicks;
        ClickTask.setCurrentClicks(newCurrentClicks);
    }

    public static int getNeededClicks(){
        neededClicks = ClickTask.getNeededClicks();
        return neededClicks;
    }

    public static int getCurrentClicks(){
        return ClickTask.currentClicks;
    }

    public static boolean getPortion(){
        return ClickTask.portion;
    }

    public static void setCompletionStatus(boolean status) {
       ClickTask.setCompletionStatus(status);
    }
    public static void setActivatedStatus(boolean status) {
        ClickTask.setActivatedStatus(status);
    }
}