package presenter;
import usecases.GameMaster;
import usecases.LifeMaster;

import javax.swing.*;
import java.util.Objects;
import java.util.Set;

public class GameMasterPresenter {
    public static Set<String> getActivateTasks() {
        return GameMaster.getTimes().keySet();
    }
    public static String getScoreText() {
        return Integer.toString(LifeMaster.getTaskCount());
    }
    public static String getLivesText() {
        return Integer.toString(LifeMaster.getLives());
    }
    public static int getTaskCount() {
        return GameMaster.getTaskCount();
    }
}
