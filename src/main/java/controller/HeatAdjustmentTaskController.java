package controller;
import usecases.HeatAdjustmentTask;

/**
 * A class representing the HeatAdjustmentTaskController, which is responsible for TODO
 *
 * @author Elena Scobici
 */
public class HeatAdjustmentTaskController {
    private static int neededTemp;
    private static int currentTemp;
    public static int[] initTemps() { // Initially set the temps to the ones generated in the back-end class
        HeatAdjustmentTask.reset();
        neededTemp = HeatAdjustmentTask.answerTemp;
        currentTemp = HeatAdjustmentTask.currentTemp;
        return new int[]{neededTemp, currentTemp};
    }
    public static void setCurrentTemp(int temp) {
        currentTemp = temp;
    }
    public static int getNeededTemp() {
        return neededTemp;
    }
    public static int getCurrentTemp() {
        return currentTemp;
    }

    public static boolean changeCurrentTemp(int val) {
        currentTemp += val;
        return HeatAdjustmentTask.setCurrentTemp(currentTemp);
    }
    public static void setCompletionStatus(boolean status) {
        HeatAdjustmentTask.setCompletionStatus("HeatAdjustmentTask", status);
    }
    public static void setActivationStatus(boolean status) {
        HeatAdjustmentTask.setActivatedStatus("HeatAdjustmentTask", status);
    }
    public static boolean getActivatedStatus() {
        return HeatAdjustmentTask.getActivatedStatus("HeatAdjustmentTask");
    }
}
