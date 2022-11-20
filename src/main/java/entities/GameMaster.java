package entities;

import controller.HeatAdjustmentTaskController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Objects;
import java.util.Random;
import java.time.Clock;

public class GameMaster {
    private static int taskInterval; // Time between tasks
    private static int assignmentsCount = 0; // Number of stacked assignment tasks
    private static int timeAllowed = 10000; // Amount of time allowed for each task in milliseconds
    private static boolean playing = true;
    private static Hashtable<String, Long> times = new Hashtable<String, Long>();
    public static String[] tasks;

    // Ensure that the method throws the needed exceptions when searching for classes and methods
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Create a clock to keep track of time
        Clock clock = Clock.systemDefaultZone();
        // Create an instance of the entities.LifeMaster
        LifeMaster lifeMaster = new LifeMaster();
        long currTime = clock.millis(); // Find the current time in milliseconds
        while (playing) {
            tasks = new String[] {"HeatAdjustmentTask", "TriviaTask", "WireTask", "ClickTask", "PhoneNumberTask",
                    "AssignmentTask", "MemoryTask"};
            if (clock.millis() >= currTime + taskInterval) { // Enough time has passed, turn on a new task
                String newTaskName = createTask(tasks); // Pick a random task
                Class<?> taskClass = Class.forName("entities." + newTaskName); // Get the task class
                if (!times.containsKey(newTaskName)) { // If the task isn't already running, then run it
                    if (Objects.equals(newTaskName, "AssignmentTask")) {
                        assignmentsCount++;
                    }
                    Method completionMethod  = taskClass.getDeclaredMethod("setCompletionStatus");
                    completionMethod.invoke(false);
                    Method activatedMethod = taskClass.getDeclaredMethod("setActivatedStatus");
                    activatedMethod.invoke(true);
                    times.put(newTaskName, clock.millis() + timeAllowed); // Record the deadline for this task in the hashmap
                }
            }
            for (String taskName : times.keySet()) {
                Class<?> taskClass = Class.forName("entities." + taskName);
                boolean completionStatus = (boolean) taskClass.getDeclaredMethod("getCompletionStatus").invoke(null);
                if (clock.millis() >= times.get(taskName)) { // If the time is up for the task
                    if (completionStatus) { // entities.Task was completed successfully
                        times.remove(taskName);
                        taskClass.getDeclaredMethod("setActivatedStatus").invoke(false);
                        lifeMaster.incrementTaskCount();
                        if (Objects.equals(taskName, "AssignmentTask")) {
                            assignmentsCount--;
                        }
                    }
                    else {
                        lifeMaster.deductLife();
                    }
                } else if (completionStatus) { // The task was completed early
                    times.remove(taskName);
                    taskClass.getDeclaredMethod("setActivatedStatus").invoke(false);
                    lifeMaster.incrementTaskCount();
                }
            }

        }
    }

    private static String createTask(String[] tasks) {
        Random rand = new Random();
        int randIndex = rand.nextInt(tasks.length);
        return tasks[randIndex];
    }
}