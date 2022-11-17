import java.util.Random;
public class HeatAdjustmentTask {
    public int answerTemp; // The actual temperature the user must achieve
    public int currentTemp; // The user's current temperature
    public HeatAdjustmentTask() {
        this.reset();
    }
    public void reset() { // Inherit reset method; generate random answer and current temperatures
        this.answerTemp = this.randomizeCurrentTemp();
        this.currentTemp = this.randomizeCurrentTemp();
    }
    private int randomizeCurrentTemp() { // Return a random integer between 0 and 30
        Random rand = new Random();
        return rand.nextInt(30);
    }
    public void tempUp() { // Method to be called when up button is pressed
        this.currentTemp++;
    }
    public void tempDown() { // Method to be called when down button is pressed
        this.currentTemp--;
    }
}
