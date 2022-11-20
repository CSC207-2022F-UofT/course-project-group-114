package entities;

import java.util.Random;
public class ClickTask{
    private int currentClicks;
    private int neededClicks;
    // changes as difficulty level increases, so I'm making upperbond static for now
    private int upperbond = 30;
    private boolean portion;

    public ClickTask() {
        super();
        this.setNeededClicks();
        this.portion = false;
    }

    private void setNeededClicks() {
        Random newNeed = new Random();
        this.neededClicks = newNeed.nextInt(upperbond);
    }

    public int getNeededClicks(){
        return this.neededClicks;
    }

    public int getCurrentClicks(){ return this.currentClicks;}

    public void setCurrentClicks(int newCurrentClicks){
        this.currentClicks = newCurrentClicks;
        if (neededClicks / 2 <= newCurrentClicks) {
            setPortion(true);
        }
    }

    private void setPortion(boolean eat){
        portion = eat;
    }

    public boolean getPortion(){
        return portion;
    }

}
