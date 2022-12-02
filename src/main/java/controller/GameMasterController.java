package controller;
import usecases.GameMaster;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

/**
 * A class representing the GameMasterController, which is responsible for communicating with the GameMaster use case
 * class to retrieve information needed for the GameMasterView's computations.
 *
 * @author Elena Scobici
 */
public class GameMasterController {
    /**
     * A getter method for the player's current playing status (true if the game is not over, false if it is).
     * @return The player's current playing status.
     */
    public static boolean getPlayingStatus() {
        return GameMaster.playing;
    }

    /**
     * A getter method for the game's task interval.
     * @return The task interval as an integer; that is, the amount of time between tasks being generated.
     */
    public static int getTaskInterval() {return GameMaster.getTaskInterval();}

    /**
     * A setter method for the game's task interval.
     * @param newInterval The new task interval, so the new integer value of milliseconds between tasks being
     *                    generated.
     */
    public static void setTaskInterval(int newInterval) {
        GameMaster.setTaskInterval(newInterval);
    }

    /**
     * A method that calls the GameMaster use case class's createNewTask method.
     * @param currTime The time in milliseconds at which the new task is being generated.
     */
    public static void createNewTask(long currTime) {
        try {
            GameMaster.createNewTask(currTime);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, "Class or method couldn't be found!");
            throw new RuntimeException(e);
        }
    }

    /**
     * A method that calls the GameMaster use case class's checkTasksCompletion method.
     * @param currTime The time in milliseconds at which the method is being called.
     */
    public static void checkTasksCompletion(long currTime) {
        try {
            GameMaster.checkTasksCompletion(currTime);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, "Class or method couldn't be found!");
            throw new RuntimeException(e);
        }
    }


}
