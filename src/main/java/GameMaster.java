package src.main.java;

import src.main.java.TriviaTask;

import java.util.Hashtable;
import java.util.Random;
import java.time.Clock;

public class GameMaster {
    private static int taskInterval; // Time between tasks
    private static int tasksCompletedCount = 0; // Number of completed tasks in total
    private static int assignmentsCount = 0; // Number of stacked assignment tasks
    private static int timeAllowed = 10000; // Amount of time allowed for each task in milliseconds
    private static boolean playing = true;
    private static Hashtable<Task, Long> times = new Hashtable<Task, Long>();

    public static void main(String[] args) {
        // Create a clock to keep track of time as well as an instance of each Task child class
        Clock clock = Clock.systemDefaultZone();
        HeadAdjustmentTask heatAdjustmentTask = new HeatAdjustmentTask();
        TriviaTask triviaTask = new TriviaTask();
        WireTask wireTask = new WireTask();
        ClickTask clickTask = new ClickTask();
        PhoneNumberTask phoneNumberTask = new PhoneNumberTask();
        AssignmentTask assignmentTask = new AssignmentTask();
        MemoryTask memoryTask = new MemoryTask();
        Task[] tasks = {heatAdjustmentTask, triviaTask, wireTask, clickTask, phoneNumberTask, assignmentTask, memoryTask};
        // Create an instance of the LifeMaster
        LifeMaster lifeMaster = new LifeMaster();
        long currTime = clock.millis(); // Find the current time in milliseconds
        while (playing) {
            if (clock.millis() >= currTime + taskInterval) { // Enough time has passed, turn on a new task
                Task newTask = createTask(tasks); // Pick a random task
                if (times.containsKey(newTask) == false) { // If the task isn't already running, then run it
                    if (newTask == (Task) assignmentTask) {
                        assignmentsCount++;
                    }
                    newTask.activated = true;
                    newTask.display();
                    times.put(newTask, clock.millis() + timeAllowed); // Record the deadline for this task in the hashmap
                }
            }
            for (Task task : times) {
                if (clock.millis() >= times.get(task)) { // If the time is up for the task
                    if (task.getCompletionStatus == true) { // Task was completed successfully
                        times.remove(task);
                        task.activated = false;
                        tasksCompletedCount++;
                        if (task == (Task) assignmentTask) {
                            assignmentsCount--;
                        }
                    }
                    else {
                        lifeMaster.deductLife();
                    }
                } else if (task.getCompletionStatus == true) { // Task was completed early
                    times.remove(task);
                    task.activated = false;
                    tasksCompletedCount++;
                }
            }

        }
    }

    private static Task createTask(Task[] tasks) {
        Random rand = new Random();
        int randIndex = rand.nextInt(tasks.length);
        return tasks[randIndex];
    }
}