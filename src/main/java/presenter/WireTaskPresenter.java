package presenter;
import use_cases.WireTask;
import view.GameMasterView;

import javax.swing.*;

/**
 * The WireTaskPresenter,
 *
 * @author Roy
 */
public class WireTaskPresenter {
    public void endGame(boolean success){
        if (success){
            JOptionPane.showMessageDialog(null, "Congrats!");
            setActivatedStatus(false);
            setCompletionStatus(true);
            GameMasterView.backToMain(GameMasterView.wireTaskView);
        } else{
            setCompletionStatus(false);
        }
    }
    public static void setActivatedStatus(boolean status){
        WireTask.setActivatedStatus("WireTask", status);
    }
    public static void setCompletionStatus(boolean status){
        WireTask.setCompletionStatus("WireTask", status);
    }
}
