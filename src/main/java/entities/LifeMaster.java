package entities;

import java.lang.reflect.InvocationTargetException;

public class LifeMaster {
    private static int lives = 0;
    private static int tasksCompletedCount = 0; // Number of completed tasks in total, AKA the score
    public void deductLife() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException { // Method for deducting a life
        lives--;
        if (lives < 0) {
            gameOver();
        }
    }
    public void incrementTaskCount() { // Method for incrementing score
        tasksCompletedCount++;
    }

    private static void gameOver() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Authenticator.updateScore(tasksCompletedCount); // Update the user's high score
        GameMaster.playing = false; // Stop game loop
        for (String taskName : GameMaster.tasks) { // Deactivate all tasks
            Class<?> taskClass = Class.forName("entities." + taskName); // Get the task class
            taskClass.getDeclaredMethod("setActivatedStatus").invoke(false);
        }
    }
}
