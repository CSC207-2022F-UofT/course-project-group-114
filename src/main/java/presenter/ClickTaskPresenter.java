package presenter;

import controller.ClickTaskController;
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
     * the game ends, show message and tell Game Master.
     * @param success This is the boolean value that is true when a user has made
     *                enough clicks.
     */
    public void endGame(boolean success){
        if (success){
            JOptionPane.showMessageDialog(null, "Congrats!");
            ClickTaskController.setActivatedStatus(false);
            ClickTaskController.setCompletionStatus(true);
            GameMasterView.backToMain(GameMasterView.clickTaskView);
        }
    }
}
