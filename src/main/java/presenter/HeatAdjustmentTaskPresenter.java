package presenter;

import usecases.HeatAdjustmentTask;

/**
 * A class representing the HeatAdjustmentTaskPresenter, which contains methods that allow HeatAdjustmentTaskView to
 * get needed information from the HeatAdjustmentTask use case class for the view's UI.
 *
 * @author Elena Scobici
 */

public class HeatAdjustmentTaskPresenter {
    /**
     * Getter method for the answer / needed temperature.
     * @return The needed temperature as an integer.
     */
    public static int getAnswerTemp() {
        return HeatAdjustmentTask.getAnswerTemp();
    }

    /**
     * Getter method for the user's current temperature.
     * @return The current temperature as an integer.
     */
    public static int getCurrentTemp() {
        return HeatAdjustmentTask.getCurrentTemp();
    }

    /**
     * Getter method for the task's activation status.
     * @return This task's activation status (whether it is currently activated) as a boolean value.
     */
    public static boolean getActivatedStatus() {
        return HeatAdjustmentTask.getActivatedStatus("HeatAdjustmentTask");
    }
}
