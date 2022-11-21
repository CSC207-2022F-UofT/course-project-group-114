package controller;
import entities.ClickTask;
import entities.GameMaster;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class GameMasterController {
    public static boolean getPlayingStatus() {
        return GameMaster.playing;
    }
    public static int getTaskInterval() {return GameMaster.getTaskInterval();}
    public static void createNewTask(long currTime) {
        try {
            GameMaster.createNewTask(currTime);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, "Class or method couldn't be found!");
            throw new RuntimeException(e);
        }
    }
    public static void checkTasksCompletion(long currTime) {
        try {
            GameMaster.checkTasksCompletion(currTime);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, "Class or method couldn't be found!");
            throw new RuntimeException(e);
        }
    }
}
