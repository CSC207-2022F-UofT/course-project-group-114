package controller;
import entities.ClickTask;
import entities.GameMaster;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class GameMasterController {
    public static boolean getPlayingStatus() {
        return GameMaster.playing;
    }
    public static void startGame() {
        try {
            GameMaster.startGame();
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, "Class or method couldn't be found!");
            throw new RuntimeException(e);
        }
    }
}
