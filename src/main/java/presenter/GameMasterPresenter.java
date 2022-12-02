package presenter;
import usecases.GameMaster;
import usecases.LifeMaster;

import java.util.Set;

/**
 * Class representing the GameMasterPresenter, which is responsible for communicating with the use case, GameMaster,
 * and retrieving information needed for the GameMasterView's UI.
 *
 * @author Elena Scobici
 */
public class GameMasterPresenter {
    /**
     * Getter method for the keys of the GameMaster's times hashmap, representing the currently active tasks' names.
     * @return A set of the names of all currently active tasks.
     */
    public static Set<String> getActivateTasks() {
        return GameMaster.getTimes().keySet();
    }

    /**
     * Getter method for an integer representation of the number of tasks completed by the user so far, stored in the
     * LifeMaster use case class.
     * @return The user's current score, as an integer.
     */
    public static int getTaskCount() {
        return GameMaster.getTaskCount();
    }

    /**
     * Getter method for a String representation of the number of tasks completed by the user so far, stored in the
     * LifeMaster use case class. Uses the GameMasterPresenter's getTaskCount method to avoid repeated code.
     * @return The user's current score, as a string.
     */
    public static String getScoreText() {
        return Integer.toString(getTaskCount());
    }

    /**
     * Getter method for a String representation of the number of lives the user currently has left, stored in the
     * LifeMaster use case class.
     * @return The user's number of remaining lives, as a string.
     */
    public static String getLivesText() {
        return Integer.toString(LifeMaster.getLives());
    }
}
