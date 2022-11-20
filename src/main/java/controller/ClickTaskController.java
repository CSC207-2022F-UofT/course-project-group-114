package controller;

import entities.ClickTask;

public class ClickTaskController {
    private int neededClicks;
    private int currentClicks;
    private boolean[] portion;

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
        return clickTask.getCurrentClicks();
    }

    public boolean getPortion(){
        return clickTask.getPortion();
    }
}