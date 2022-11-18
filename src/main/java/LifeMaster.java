public class LifeMaster {
    private static int lives = 0;
    private static int tasksCompletedCount = 0; // Number of completed tasks in total, AKA the score
    public void deductLife() { // Method for deducting a life
        lives--;
        if (lives < 0) {
            gameOver();
        }
    }
    public void incrementTaskCount() { // Method for incrementing score
        tasksCompletedCount++;
    }

    private static void gameOver() {
        Authenticator.updateScore(tasksCompletedCount); // Update the user's high score
        for (Task task : GameMaster.tasks) { // Deactivate all tasks
            task.activated = false;
        }
    }
}
