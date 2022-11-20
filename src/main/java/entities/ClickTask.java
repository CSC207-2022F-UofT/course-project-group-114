package entities;

import java.util.Random;
public class ClickTask{
    public static int currentClicks;
    public static int neededClicks;
    private static final int UPPERBOUND = 30;
    public static boolean portion;

    public static void setNeededClicks(){
        Random newNeed = new Random();
        neededClicks = newNeed.nextInt(UPPERBOUND);
    }

    public static int getNeededClicks() {
        return neededClicks;
    }

    public static void setCurrentClicks(int newCurrentClicks){
        currentClicks = newCurrentClicks;
        if (neededClicks / 2 <= newCurrentClicks) {
            portion = true;
        }
    }
}
