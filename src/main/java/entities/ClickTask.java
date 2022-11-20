package entities;

import java.util.Random;

public class ClickTask extends Task {
    private static int currentClicks;
    private static int neededClicks;
    // changes as difficulty level increases, so I'm making upperbond static for now
    final int upperbond = 60;

    public ClickTask() {
        super();
        this.setNeededClicks();
    }

    private void setNeededClicks() {
        Random newNeed = new Random();
        neededClicks = newNeed.nextInt(upperbond);
    }

    public int getNeededClicks(){
        return neededClicks;
    }

    public void setCurrentClicks(int newCurrentClicks){
        currentClicks = newCurrentClicks;
    }

    public static void reset() {
        currentClicks = 0;
        neededClicks = 0;
    }
}
