package controller;

import entities.ClickTask;

public class ClickTaskController {
    private int neededClicks;
    private int currentClicks;

    // haven't figured out how the folders and linkings work so ill put it here for now
    // pass on new added clicks
    ClickTask clickTask = new ClickTask();
    public int getNeededClicks(){
        this.neededClicks = clickTask.getNeededClicks();
        return this.neededClicks;
    }

    public void setCurrentClicks(int newCurrentClicks){
        this.currentClicks = newCurrentClicks;
        clickTask.setCurrentClicks(newCurrentClicks);
    }

    public int getCurrentClicks(){
        return this.currentClicks;
    }
}
