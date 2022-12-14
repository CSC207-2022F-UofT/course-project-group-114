package use_cases;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Class representing the GameMaster use case, which is responsible for the main game functions such as generating
 * and deactivating tasks as needed.
 *
 * @author Elena Scobici
 */

public class GameMaster {
    final static int TIME_ALLOWED = 10000; // Constant amount of time allowed per task
    private static int taskInterval = 10000; // Time between tasks in milliseconds
    public static boolean playing = true;
    private static final Hashtable<String, Long> times = new Hashtable<>();
// changed this line below to include trivia now that i got it working

    public static String[] tasks = new String[] {"ClickTask", "AssignmentTask", "MemoryTask", "TriviaTask", "HeatAdjustmentTask",
            "PhoneNumberTask", "WireTask"};

    /**
     * Method for creating / activating a new task and adding it to the times hashmap
     * @param currTime The time in milliseconds at which the task is being created
     * @throws ClassNotFoundException If task class is not found
     * @throws NoSuchMethodException If method is not found
     * @throws InvocationTargetException If method cannot be invoked with passed parameters
     * @throws IllegalAccessException If method cannot be accessed
     */
    public static void createNewTask(long currTime) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String newTaskName = chooseTask(tasks); // Pick a random task
        createTask(newTaskName, currTime);
    }

    /**
     * Helper method for creating the task with the passed name at the passed time.
     * @param newTaskName The name of the task to be created, as a string.
     * @param currTime The current time, in milliseconds, as a long.
     * @throws ClassNotFoundException If task class is not found
     * @throws NoSuchMethodException If method is not found
     * @throws InvocationTargetException If method cannot be invoked with passed parameters
     * @throws IllegalAccessException If method cannot be accessed
     */
    public static void createTask(String newTaskName, long currTime) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> taskClass = Class.forName("use_cases." + newTaskName); // Get the task class
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
        for (String taskName : times.keySet()) {
            Class<?> taskClass = Class.forName("use_cases." + taskName);
            boolean completionStatus = (boolean) taskClass.getMethod("getCompletionStatus", String.class).invoke(taskClass, taskName);
            boolean activationStatus = (boolean) taskClass.getMethod("getActivatedStatus", String.class).invoke(taskClass, taskName);
            Method setActivatedStatus = taskClass.getMethod("setActivatedStatus", String.class, boolean.class);
            Method setCompletionStatus = taskClass.getMethod("setCompletionStatus", String.class, boolean.class);
            if (currTime >= times.get(taskName)) { // If the time is up for the task
                if (completionStatus) { // The task was completed successfully
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
    public static String chooseTask(String[] tasks) {
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

    /**
     * Reset method for the GameMaster, which empties the time hashmap, sets playing to true and sets taskInterval to
     * 10000 milliseconds.
     */
    public static void reset() {
        Set<String> keySet = new HashSet<>(times.keySet());
        for (String element : keySet) {
            times.remove(element);
        }
        playing = true;
        taskInterval = 10000;
    }
}