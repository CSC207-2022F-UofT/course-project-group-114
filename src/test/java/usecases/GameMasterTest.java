package usecases;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Hashtable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The use case GameMasterTest class checks methods in GameMaster.java.
 *
 * @author Siyuan Deng
 */
public class GameMasterTest {
    /**
     * Test for whether the createTask method of the GameMaster class correctly affects the task's completionStatus
     * variable.
     * @throws ClassNotFoundException If task class is not found
     * @throws NoSuchMethodException If method is not found
     * @throws InvocationTargetException If method cannot be invoked with passed parameters
     * @throws IllegalAccessException If method cannot be accessed
     */
    @Test
    void createTaskCompletionTest() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        GameMaster.reset();
        String[] taskNames = GameMaster.tasks;
        for (String task: taskNames) {
            Task.setCompletionStatus(task, true);
            GameMaster.createTask(task, 100);
            assert(!Task.getCompletionStatus(task));
        }
    }

    /**
     * Test for whether the createTask method of the GameMaster class correctly affects the task's activatedStatus
     * variable.
     * @throws ClassNotFoundException If task class is not found
     * @throws NoSuchMethodException If method is not found
     * @throws InvocationTargetException If method cannot be invoked with passed parameters
     * @throws IllegalAccessException If method cannot be accessed
     */
    @Test
    void createTaskActivationTest() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        GameMaster.reset();
        String[] taskNames = GameMaster.tasks;
        for (String task: taskNames) {
            Task.setActivatedStatus(task, false);
            GameMaster.createTask(task, 100);
            assert(Task.getActivatedStatus(task));
        }
    }

    /**
     * Test for whether the taskInterval of the GameMaster is initially equal to 10000 milliseconds.
     */
    @Test
    public void getTaskIntervalTest(){
        GameMaster.reset();
        int taskInterval = 10000;
        Assertions.assertEquals(GameMaster.getTaskInterval(), taskInterval);
    }

    /**
     * Test for whether the checkTasksCompletion method of the GameMaster correctly sets the activation status
     * of each task, or correctly deactivates each task.
     * @throws ClassNotFoundException If task class is not found
     * @throws NoSuchMethodException If method is not found
     * @throws InvocationTargetException If method cannot be invoked with passed parameters
     * @throws IllegalAccessException If method cannot be accessed
     */
    @Test
    public void checkTasksCompletionTest() throws ClassNotFoundException, InvocationTargetException,
            NoSuchMethodException, IllegalAccessException {
        GameMaster.reset();
        String[] taskNames = GameMaster.tasks;
        for (String task: taskNames) {
            GameMaster.getTimes().put(task, Integer.toUnsignedLong(100));
            Task.setCompletionStatus(task, true);
            Task.setActivatedStatus(task, true);
            GameMaster.checkTasksCompletion(Integer.toUnsignedLong(100));
            assert(!Task.getActivatedStatus(task));
        }
    }

    /**
     * Test for whether the chooseTask method of the GameMaster returns a task name that is in the GameMaster's
     * tasks list.
     */
    @Test
    public void chooseTaskTest(){
        GameMaster.reset();
        String[] tasks = GameMaster.tasks;
        String newTaskName = GameMaster.chooseTask(tasks);
        assert(Arrays.asList(tasks).contains(newTaskName));
    }

    /**
     * Test for whether the getTimes method of the GameMaster is empty upon reset.
     */
    @Test
    public void getTimesTest(){
        GameMaster.reset();
        Hashtable<String, Long> actual = GameMaster.getTimes();
        Hashtable<String, Long> expected = new Hashtable<>();
        Assertions.assertEquals(expected, actual);
    }
}

