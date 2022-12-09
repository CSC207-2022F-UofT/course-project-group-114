package use_cases;

public class LifeMaster {
    private static int lives = 5;
    private static int tasksCompletedCount = 0; // Number of completed tasks in total, AKA the score
    public static void deductLife(){ // Method for deducting a life
        lives--;
        if (lives == 0) {
            gameOver();
        }
    }
    public static void incrementTaskCount() { // Method for incrementing score
        tasksCompletedCount++;
    }

    public static int getTaskCount() { // Method for getting the current score
        return tasksCompletedCount;
    }
    private static void gameOver() {
        Authenticator.updateScore(tasksCompletedCount); // Update the user's high score
        System.exit(0);
    }
    public static int getLives() {
        return lives;
    }
    public static void reset() {
        lives = 5;
        tasksCompletedCount = 0;
    }
}
