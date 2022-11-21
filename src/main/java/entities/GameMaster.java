package entities;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Random;

public class GameMaster {
    private static int taskInterval = 10000; // Time between tasks in milliseconds
    private static int timeAllowed = 10000; // Amount of time allowed for each task in milliseconds
    public static boolean playing = true;
    private static final Hashtable<String, Long> times = new Hashtable<String, Long>();
    public static String[] tasks = new String[] {"HeatAdjustmentTask", "ClickTask", "PhoneNumberTask",
            "AssignmentTask", "MemoryTask"};
    // TODO Remember to change the above line to include all tasks:
//            tasks = new String[] {"HeatAdjustmentTask", "TriviaTask", "WireTask", "ClickTask", "PhoneNumberTask",
//                    "AssignmentTask", "MemoryTask"};

    // Ensure that the method throws the needed exceptions when searching for classes and methods
    public static void createNewTask(long currTime) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String newTaskName = chooseTask(tasks); // Pick a random task
        Class<?> taskClass = Class.forName("entities." + newTaskName); // Get the task class
        if (!times.containsKey(newTaskName)) { // If the task isn't already running, then run it
            Method resetMethod = taskClass.getMethod("reset");
            resetMethod.invoke(taskClass);
            Method completionMethod  = taskClass.getMethod("setCompletionStatus", boolean.class);
            completionMethod.invoke(taskClass,false);
            Method activatedMethod = taskClass.getMethod("setActivatedStatus", boolean.class);
            activatedMethod.invoke(taskClass, true);
            times.put(newTaskName, currTime + timeAllowed); // Record the deadline for this task in the hashmap
        }
    }
    public static int getTaskInterval() {
        return taskInterval;
    }
    public static void checkTasksCompletion(long currTime) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for (String taskName : times.keySet()) {
            Class<?> taskClass = Class.forName("entities." + taskName);
            boolean completionStatus = (boolean) taskClass.getMethod("getCompletionStatus").invoke(null);
            boolean activationStatus = (boolean) taskClass.getMethod("getActivatedStatus").invoke(null);
            if (currTime >= times.get(taskName)) { // If the time is up for the task
                if (completionStatus) { // The task was completed successfully
                    times.remove(taskName);
                    taskClass.getMethod("setActivatedStatus", boolean.class).invoke(taskClass, false);
                    LifeMaster.incrementTaskCount();
                }
                else { // Task was not completed in time
                    taskClass.getMethod("setActivatedStatus", boolean.class).invoke(taskClass, false);
//                    LifeMaster.deductLife();

                }
            } else if (completionStatus) { // The task was completed early
                times.remove(taskName);
                taskClass.getMethod("setActivatedStatus", boolean.class).invoke(taskClass, false);
                LifeMaster.incrementTaskCount();
            } else if (!activationStatus) { // Task was deactivated
                times.remove(taskName);
                //LifeMaster.deductLife();
            }
        }
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