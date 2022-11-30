package usecases;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

/**
 * Class representing the GameMaster entity, which is responsible for the main game functions such as generating
 * and deactivating tasks as needed
 */

public class GameMaster {
    final static int TIME_ALLOWED = 10000; // Constant amount of time allowed per task
    private static int taskInterval = 10000; // Time between tasks in milliseconds
    public static boolean playing = true;
    private static final Hashtable<String, Long> times = new Hashtable<>();

    public static String[] tasks = new String[] {"ClickTask", "AssignmentTask", "MemoryTask", "HeatAdjustmentTask",
    "PhoneNumberTask"};
//    public static String[] tasks = new String[] {"HeatAdjustmentTask", "ClickTask", "PhoneNumberTask",
//            "AssignmentTask", "MemoryTask", "WireTask", "TriviaTask"};

    /**
     * Method for creating / activating a new task and adding it to the times hashmap
     * @param currTime The time in milliseconds at which the task is being created
     * @throws ClassNotFoundException If task class is not found
     * @throws NoSuchMethodException If method is not found
     * @throws InvocationTargetException If method cannot be invoked with passed parameters
     * @throws IllegalAccessException If method cannot be accessed
     */
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
            // Amount of time allowed for each task in milliseconds
            times.put(newTaskName, currTime + TIME_ALLOWED); // Record the deadline for this task in the hashmap
        }
    }

    /**
     * Getter method for the task interval
     * @return The task interval, or the amount of time between each task being generated
     */
    public static int getTaskInterval() {
        return taskInterval;
    }

    /**
     * Setter method for the task interval
     * @param newInterval The new value for the time, in milliseconds, between tasks being generated
     */
    public static void setTaskInterval(int newInterval) {
        taskInterval = newInterval;
    }

    /**
     * Getter method for the LifeMaster's task count, in order to uphold clean architecture
     * @return The number of tasks completed so far
     */
    public static int getTaskCount() {
        return LifeMaster.getTaskCount();
    }

    /**
     * Method for checking every task in times and deactivating them, removing them from times, deducting lives
     * and incrementing the total task count as needed.
     * @param currTime The time in milliseconds at which the method is being called
     * @throws ClassNotFoundException If task class is not found
     * @throws NoSuchMethodException If method is not found
     * @throws InvocationTargetException If method cannot be invoked with passed parameters
     * @throws IllegalAccessException If method cannot be accessed
     */
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

    /**
     * Choose a random task name and return it
     * @param tasks The set of all task names to choose from
     * @return The randomly chosen task
     */
    private static String chooseTask(String[] tasks) {
        Random rand = new Random();
        int randIndex = rand.nextInt(tasks.length);
        return tasks[randIndex];
    }

    /**
     * Getter method for the times hashmap
     * @return The times hashmap
     */
    public static Hashtable<String, Long> getTimes() {
        return times;
    }
}