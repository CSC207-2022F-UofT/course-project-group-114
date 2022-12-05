package usecases;

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
    public static boolean portion = false;

    /**
     * This method generates a random number and make it an instance of the
     * ClickTask object.
     */
    public static void setNeededClicks(){
        Random newNeed = new Random();
        neededClicks = newNeed.nextInt(UPPERBOUND-1)+1;
    }

    /**
     * This method returns the generated neededClicks instance in Click Task class.
     *
     * @return the number of neededClicks.
     */
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
        } else{
            portion = false;
        }
    }

    /**
     * This method resets the current Click Task to a new Click Task, meaning newly
     * generated neededClicks and currentClicks is set to 0.
     */
    public static void reset(){
        setCurrentClicks(0);
        Task.reset("ClickTask");
    }

    /**
     * This method returns the UPPERBOUND instance in Click Task.
     *
     * @return The upperbound for neededClicks.
     */
    public static int getUpperbound() {
        return UPPERBOUND;
    }
}
