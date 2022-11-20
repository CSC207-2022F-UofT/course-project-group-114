package controller;
import entities.GameMaster;

public class GameMasterController {
    public static boolean getPlayingStatus() {
        return GameMaster.playing;
    }
}
