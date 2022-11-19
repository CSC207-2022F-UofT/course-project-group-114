import java.util.Random;
public class HeatAdjustmentTask extends Task {
    public static int answerTemp; // The actual temperature the user must achieve
    public static int currentTemp; // The user's current temperature
    public HeatAdjustmentTask() {
        reset();
    }

    public static void reset() { // Inherit reset method; generate random answer and current temperatures
        answerTemp = randomizeCurrentTemp();
        currentTemp = randomizeCurrentTemp();
    }
    private static int randomizeCurrentTemp() { // Return a random integer between 0 and 30
        Random rand = new Random();
        return rand.nextInt(30);
    }
    public static void tempUp() { // Method to be called when up button is pressed
        currentTemp++;
    }
    public static void tempDown() { // Method to be called when down button is pressed
        currentTemp--;
    }
}
