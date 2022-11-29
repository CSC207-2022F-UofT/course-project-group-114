package entities;
import java.util.Random;
public class HeatAdjustmentTask extends Task {
    public static int answerTemp; // The actual temperature the user must achieve
    public static int currentTemp; // The user's current temperature
//    private static boolean completed;
//    private static boolean activated;
    public HeatAdjustmentTask() {
        reset();
    }

    public static void reset() { // Inherit reset method; generate random answer and current temperatures
        answerTemp = randomizeCurrentTemp();
        currentTemp = randomizeCurrentTemp();
        while (currentTemp == answerTemp) {
            currentTemp = randomizeCurrentTemp();
        }
        Task.reset("HeatAdjustmentTask");
    }
    private static int randomizeCurrentTemp() { // Return a random integer between 0 and 30
        Random rand = new Random();
        return rand.nextInt(30);
    }
    public static boolean setCurrentTemp(int temp) {
        currentTemp = temp;
        if (currentTemp == answerTemp) { // If current is answer, the task is complete
            setActivatedStatus("HeatAdjustmentTask", false);
            setCompletionStatus("HeatAdjustmentTask", true);
        }
        return getCompletionStatus("HeatAdjustmentTask");
    }
//    public static void setCompletionStatus(boolean status) {
//        completed = status;
//    }
//    public static boolean getCompletionStatus() {
//        return completed;
//    }
//    public static void setActivatedStatus(boolean status) {
//        activated = status;
//    }
//    public static boolean getActivatedStatus() {
//        return activated;
//    }
}
