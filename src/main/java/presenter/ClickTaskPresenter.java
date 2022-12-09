package presenter;

import usecases.ClickTask;
import view.GameMasterView;

import javax.swing.*;

/**
 * The ClickTaskPresenter class gets information from the ClickTask class
 * (i.e., use case) and modifies the view accordingly.
 *
 * @author Siyuan Deng
 */
public class ClickTaskPresenter {
    /**
     * This method is used to determine whether the game needs to be ended. If
     * the game ends, set ActivatedStatus to false, set Completion Status to true,
     * and show message and tell Game Master.
     * @param success This is the boolean value that is true when a user has made
     *                enough clicks.
     */
    public void endGame(boolean success){
        if (success){
            JOptionPane.showMessageDialog(null, "Congrats!");
            setActivatedStatus(false);
            setCompletionStatus(true);
            GameMasterView.backToMain(GameMasterView.clickTaskView);
        } else{
            setCompletionStatus(false);
        }
    }

    /**
     * sets the ActivatedStatus of the Click Task via the ClickTask class.
     * @param status change the activation status of Click Task status.
     */
    public static void setActivatedStatus(boolean status){
        ClickTask.setActivatedStatus("ClickTask", status);
    }

    /**
     * sets the CompletionStatus of the Click Task via the ClickTask class.
     * @param status change the completion status of Click Task status.
     */
    public static void setCompletionStatus(boolean status){
        ClickTask.setCompletionStatus("ClickTask", status);
    }
}
