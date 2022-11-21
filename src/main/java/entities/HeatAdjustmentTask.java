package entities;
import java.util.Random;
public class HeatAdjustmentTask extends Task {
    public static int answerTemp; // The actual temperature the user must achieve
    public static int currentTemp; // The user's current temperature
    public static boolean completed = false;
    public HeatAdjustmentTask() {
        reset();
    }

    public static void reset() { // Inherit reset method; generate random answer and current temperatures
        answerTemp = randomizeCurrentTemp();
        currentTemp = randomizeCurrentTemp();
        while (currentTemp == answerTemp) {
            currentTemp = randomizeCurrentTemp();
        }
    }
    private static int randomizeCurrentTemp() { // Return a random integer between 0 and 30
        Random rand = new Random();
        return rand.nextInt(30);
    }
    public static boolean setCurrentTemp(int temp) {
        currentTemp = temp;
        if (currentTemp == answerTemp) { // If current is answer, the task is complete
            activated = false;
            completed = true;
        }
        return completed;
    }
}
