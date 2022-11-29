import entities.GameMaster;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Clock;
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
    public void checkTasksCompletionTest(){
        // JUnit test for exceptions
        // Since nobody is playing the game, it should always be false
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
        // Since nobody is playing, it's the default value
    }
}
