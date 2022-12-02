package controller;
import usecases.HeatAdjustmentTask;

/**
 * A class representing the HeatAdjustmentTaskController, which contains method that allow HeatAdjustmentTaskView
 * to set needed computational information for the HeatAdjustmentTask use case class.
 *
 * @author Elena Scobici
 */
public class HeatAdjustmentTaskController {
    /**
     * A setter method for the user's current temperature which also returns the updated completion status.
     * @param val The value to add to the user's current temperature.
     * @return This task's updated completion status (whether current and answer temperatures are equal).
     */
    public static boolean changeCurrentTemp(int val) {
        return HeatAdjustmentTask.setCurrentTemp(HeatAdjustmentTask.getCurrentTemp() + val);
    }

    /**
     * A setter method for the HeatAdjustmentTask's completion status.
     * @param status Boolean value representing whether the task has been successfully completed.
     */
    public static void setCompletionStatus(boolean status) {
        HeatAdjustmentTask.setCompletionStatus("HeatAdjustmentTask", status);
    }

    /**
     * A setter method for the HeatAdjustmentTask's activation status.
     * @param status Boolean value representing whether the task is currently activated.
     */
    public static void setActivationStatus(boolean status) {
        HeatAdjustmentTask.setActivatedStatus("HeatAdjustmentTask", status);
    }
}
