package entities;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Objects;
import java.util.Random;
import java.time.Clock;

public class GameMaster {
    private static int taskInterval = 20000; // Time between tasks in milliseconds
    private static int timeAllowed = 10000; // Amount of time allowed for each task in milliseconds
    public static boolean playing = true;
    private static final Hashtable<String, Long> times = new Hashtable<String, Long>();
    public static String[] tasks;
    private static Clock clock = Clock.systemDefaultZone();
    private static LifeMaster lifeMaster = new LifeMaster();
    private static long currTime = clock.millis(); // Find the current time in milliseconds

    // Ensure that the method throws the needed exceptions when searching for classes and methods
    public static void startGame() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Create a clock to keep track of time

        // Create an instance of the entities.LifeMaster

//        while (playing) {
//            tasks = new String[] {"HeatAdjustmentTask", "TriviaTask", "WireTask", "ClickTask", "PhoneNumberTask",
//                    "AssignmentTask", "MemoryTask"};
            tasks = new String[] {"HeatAdjustmentTask", "ClickTask", "PhoneNumberTask", "AssignmentTask", "MemoryTask"};
            if (clock.millis() >= currTime + taskInterval) { // Enough time has passed, turn on a new task
                currTime = clock.millis(); // Update the current time
                String newTaskName = chooseTask(tasks); // Pick a random task
                Class<?> taskClass = Class.forName("entities." + newTaskName); // Get the task class
                if (!times.containsKey(newTaskName)) { // If the task isn't already running, then run it
                    Method resetMethod = taskClass.getMethod("reset");
                    resetMethod.invoke(taskClass);
                    Method completionMethod  = taskClass.getMethod("setCompletionStatus", boolean.class);
                    completionMethod.invoke(taskClass,false);
                    Method activatedMethod = taskClass.getMethod("setActivatedStatus", boolean.class);
                    activatedMethod.invoke(taskClass, true);
                    times.put(newTaskName, clock.millis() + timeAllowed); // Record the deadline for this task in the hashmap
                }
            }
            for (String taskName : times.keySet()) {
                Class<?> taskClass = Class.forName("entities." + taskName);
                boolean completionStatus = (boolean) taskClass.getMethod("getCompletionStatus").invoke(null);
                if (clock.millis() >= times.get(taskName)) { // If the time is up for the task
                    if (completionStatus) { // The task was completed successfully
                        times.remove(taskName);
                        taskClass.getMethod("setActivatedStatus", boolean.class).invoke(taskClass, false);
                        lifeMaster.incrementTaskCount();
                    }
                    else {
                        lifeMaster.deductLife();
                    }
                } else if (completionStatus) { // The task was completed early
                    times.remove(taskName);
                    taskClass.getMethod("setActivatedStatus", boolean.class).invoke(taskClass, false);
                    lifeMaster.incrementTaskCount();
                }
            }

//        }
    }

    private static String chooseTask(String[] tasks) {
        Random rand = new Random();
        int randIndex = rand.nextInt(tasks.length);
        return tasks[randIndex];
    }

    public static Hashtable<String, Long> getTimes() {
        return times;
    }
}