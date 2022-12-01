package usecases;
import java.util.Random;

/**
 * A class representing the HeatAdjustmentTask use case, which is responsible for the logic of the task; that is,
 * generating a current and needed temperature and resetting the task.
 *
 * @author Elena Scobici
 */
public class HeatAdjustmentTask extends Task {
    public static int answerTemp; // The actual temperature the user must achieve
    public static int currentTemp; // The user's current temperature

    /**
     * Constructor for the HeatAdjustmentTask class, which resets the task.
     */
    public HeatAdjustmentTask() {
        reset();
    }

    /**
     * Reset method, which randomizes the answer and current temperature. It continually re-randomizes the current
     * temperature to ensure the two temperatures are not equal. It also calls the parent class Task's reset method
     * which resets the activated and completed values.
     */
    public static void reset() {
        answerTemp = randomizeCurrentTemp();
        currentTemp = randomizeCurrentTemp();
        while (currentTemp == answerTemp) {
            currentTemp = randomizeCurrentTemp();
        }
        Task.reset("HeatAdjustmentTask");
    }

    /**
     * Helper method for picking and returning a random temperature between 0 and 30.
     * @return A random integer between 0 and 30.
     */
    private static int randomizeCurrentTemp() {
        Random rand = new Random();
        return rand.nextInt(30);
    }

    /**
     * A setter method for the current temperature of the user, which also returns the completion status of the task,
     * so whether the current and answer temperatures are equal or not.
     * @param temp The new integer value for the current temperature, currentTemp.
     * @return The task's completion status as a boolean value.
     */
    public static boolean setCurrentTemp(int temp) {
        currentTemp = temp;
        if (currentTemp == answerTemp) { // If current is answer, the task is complete
            setActivatedStatus("HeatAdjustmentTask", false);
            setCompletionStatus("HeatAdjustmentTask", true);
        }
        return getCompletionStatus("HeatAdjustmentTask");
    }
}
