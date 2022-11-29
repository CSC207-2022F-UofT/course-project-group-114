package entities;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.Set;

public class GameMaster {
    private static int taskInterval = 10000; // Time between tasks in milliseconds
    private static int timeAllowed = 10000; // Amount of time allowed for each task in milliseconds
    public static boolean playing = true;
    private static final Hashtable<String, Long> times = new Hashtable<String, Long>();

    public static String[] tasks = new String[] {"ClickTask", "AssignmentTask", "MemoryTask", "HeatAdjustmentTask",
    "PhoneNumberTask"};
//    public static String[] tasks = new String[] {"HeatAdjustmentTask", "ClickTask", "PhoneNumberTask",
//            "AssignmentTask", "MemoryTask", "WireTask", "TriviaTask"};

    // Ensure that the method throws the needed exceptions when searching for classes and methods

    public static void createNewTask(long currTime) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println("Create task method!");
        String newTaskName = chooseTask(tasks); // Pick a random task
        System.out.println(newTaskName);
        Class<?> taskClass = Class.forName("entities." + newTaskName); // Get the task class
        if (!times.containsKey(newTaskName)) { // If the task isn't already running, then run it
            Method resetMethod = taskClass.getMethod("reset");
            resetMethod.invoke(taskClass);
            Method completionMethod  = taskClass.getMethod("setCompletionStatus", String.class, boolean.class);
            completionMethod.invoke(taskClass, newTaskName, false);
            Method activatedMethod = taskClass.getMethod("setActivatedStatus", String.class, boolean.class);
            activatedMethod.invoke(taskClass, newTaskName, true);
            times.put(newTaskName, currTime + timeAllowed); // Record the deadline for this task in the hashmap
        }
    }
    public static int getTaskInterval() {
        return taskInterval;
    }
    public static void checkTasksCompletion(long currTime) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<String> tasksToRemove = new ArrayList<>();
        System.out.println(times.keySet());
        for (String taskName : times.keySet()) {
            Class<?> taskClass = Class.forName("entities." + taskName);
            boolean completionStatus = (boolean) taskClass.getMethod("getCompletionStatus", String.class).invoke(taskClass, taskName);
            boolean activationStatus = (boolean) taskClass.getMethod("getActivatedStatus", String.class).invoke(taskClass, taskName);
            Method setActivatedStatus = taskClass.getMethod("setActivatedStatus", String.class, boolean.class);
            Method setCompletionStatus = taskClass.getMethod("setCompletionStatus", String.class, boolean.class);
            if (currTime >= times.get(taskName)) { // If the time is up for the task
                System.out.println("Time up for: " + taskName);
                if (completionStatus) { // The task was completed successfully
                    times.remove(taskName);
                    setActivatedStatus.invoke(taskClass, taskName, false);
                    setCompletionStatus.invoke(taskClass, taskName, false);
                    LifeMaster.incrementTaskCount();
                }
                else { // Task was not completed in time
                    //times.remove(taskName);
                    tasksToRemove.add(taskName);
                    setActivatedStatus.invoke(taskClass, taskName, false);
                    LifeMaster.deductLife();

                }
            } else if (completionStatus) { // The task was completed early
                //times.remove(taskName);
                tasksToRemove.add(taskName);
                setActivatedStatus.invoke(taskClass, taskName, false);
                setCompletionStatus.invoke(taskClass, taskName, false);
                LifeMaster.incrementTaskCount();
            } else if (!activationStatus) { // Task was deactivated
                //times.remove(taskName);
                tasksToRemove.add(taskName);
                LifeMaster.deductLife();
            }
        }
        for (String task : tasksToRemove) {
            times.remove(task);
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