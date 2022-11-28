package entities;

import java.util.Random;

/**
 * The ClickTask class allows the game to have a Click Task, and it
 * contains four instances.
 *
 * @author Siyuan Deng
 * @inheritDoc Task
 */
public class ClickTask extends Task{
    public static int currentClicks;
    public static int neededClicks;
    private static final int UPPERBOUND = 30;
    public static boolean portion;

    /**
     * This method generates a random number and make it an instance of the
     * ClickTask object.
     */
    public static void setNeededClicks(){
        Random newNeed = new Random();
        neededClicks = newNeed.nextInt(UPPERBOUND);
    }

    public static int getNeededClicks() {
        return neededClicks;
    }

    /**
     * This method change the currentClicks instance of a ClickTask object and
     * also changes the instance portion.
     * @param newCurrentClicks the new number of clicks, which is the new value
     *                         of currentClicks.
     */
    public static void setCurrentClicks(int newCurrentClicks){
        currentClicks = newCurrentClicks;
        if (neededClicks / 2 <= newCurrentClicks) {
            portion = true;
        }
    }

    public static void reset(){
        setCurrentClicks(0);
        setNeededClicks();
    }

    public static int getUpperbound(){
        return UPPERBOUND;
    }
}
