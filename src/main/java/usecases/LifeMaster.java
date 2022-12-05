package usecases;

import view.GameMasterView;

import java.lang.reflect.InvocationTargetException;

public class LifeMaster {
    private static int lives = 5;
    private static int tasksCompletedCount = 0; // Number of completed tasks in total, AKA the score
    public static void deductLife() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException { // Method for deducting a life
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
    private static void gameOver() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        GameMasterView.getFrames()[0].dispose(); // DISPOSE WINDOW WHEN DEAD TODO REMOVE THIS ONCE GAME OVER IS IMPLEMENTED
        Authenticator.updateScore(tasksCompletedCount); // Update the user's high score
        GameMaster.playing = false; // Stop game loop
        for (String taskName : GameMaster.tasks) { // Deactivate all tasks
            Class<?> taskClass = Class.forName("usecases." + taskName); // Get the task class
            taskClass.getDeclaredMethod("setActivatedStatus").invoke(false);
        }
    }
    public static int getLives() {
        return lives;
    }
    public static void reset() {
        lives = 5;
        tasksCompletedCount = 0;
    }
}
