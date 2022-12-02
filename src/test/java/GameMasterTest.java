import usecases.GameMaster;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Clock;
import java.util.Hashtable;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The GameMasterTest class checks methods in GameMaster.java.
 *
 * @author Siyuan Deng
 */
public class GameMasterTest {

    @Test
    public void createNewTaskSetCompletionTest() throws ClassNotFoundException, InvocationTargetException,
            NoSuchMethodException, IllegalAccessException {
        Clock clock = Clock.systemDefaultZone();
        long currTime = clock.millis();
        GameMaster.createNewTask(currTime);
        boolean taskRun = false;
        for (int i = 0; i < GameMaster.tasks.length; i++){
            String task = GameMaster.tasks[i];
            Class<?> taskClass = Class.forName("entities." + task);
            Method completionMethod  = taskClass.getMethod("getCompletionStatus");
            taskRun = (Boolean) completionMethod.invoke(taskClass);
            if (taskRun){
                break;
            }
        }
        Assertions.assertTrue(taskRun);
    }

    @Test
    public void createNewTaskSetActivatedTest() throws ClassNotFoundException, InvocationTargetException,
            NoSuchMethodException, IllegalAccessException {
        Clock clock = Clock.systemDefaultZone();
        long currTime = clock.millis();
        GameMaster.createNewTask(currTime);
        boolean taskRun = false;
        for (int i = 0; i < GameMaster.tasks.length; i++){
            String task = GameMaster.tasks[i];
            Class<?> taskClass = Class.forName("entities." + task);
            Method activatedMethod  = taskClass.getMethod("getActivatedStatus");
            taskRun = (Boolean) activatedMethod.invoke(taskClass);
            if (taskRun){
                break;
            }
        }
        Assertions.assertTrue(taskRun);
    }

    @Test
    public void getTaskIntervalTest(){
        int taskInterval = 10000;
        Assertions.assertEquals(GameMaster.getTaskInterval(), taskInterval);
    }

    @Test
    public void checkTasksCompletionTest() throws ClassNotFoundException, InvocationTargetException,
            NoSuchMethodException, IllegalAccessException {
        Clock clock = Clock.systemDefaultZone();
        long currTime = clock.millis();
        GameMaster.checkTasksCompletion(currTime);
        boolean taskComp = true;
        for (int i = 0; i < GameMaster.tasks.length; i++){
            String task = GameMaster.tasks[i];
            Class<?> taskClass = Class.forName("entities." + task);
            Method completionMethod  = taskClass.getMethod("getCompletionStatus");
            taskComp = (Boolean) completionMethod.invoke(taskClass);
            if (!taskComp){
                break;
            }
        }
        Assertions.assertFalse(taskComp);
    }

    @Test
    public void chooseTaskTest(){
        String[] tasks = GameMaster.tasks;
        String newTaskName = GameMaster.chooseTask(tasks);
        boolean validTask = false;
        for (String task : tasks) {
            if (Objects.equals(task, newTaskName)) {
                validTask = true;
                break;
            }
        }
        Assertions.assertNotEquals(null,newTaskName);
        Assertions.assertTrue(validTask);
    }

    @Test
    public void getTimesTest(){
        Hashtable<String, Long> actual = GameMaster.getTimes();
        Hashtable<String, Long> expected = new Hashtable<>();
        Assertions.assertEquals(expected, actual);
    }
}

