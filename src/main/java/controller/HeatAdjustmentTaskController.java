package controller;
import entities.HeatAdjustmentTask;

public class HeatAdjustmentTaskController {
    private static int neededTemp;
    private static int currentTemp;
    public static int[] initTemps() { // Initially set the temps to the ones generated in the back-end class
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

    public static void changeCurrentTemp(int val) {
        currentTemp += val;
        HeatAdjustmentTask.setCurrentTemp(val);
    }
}
