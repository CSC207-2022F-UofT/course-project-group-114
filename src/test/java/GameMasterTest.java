import entities.GameMaster;

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
    public void createNewTaskTest(){
        // JUnit test for exceptions
        Clock clock = Clock.systemDefaultZone();
        long currTime = clock.millis();

    }

    @Test
    public void getTaskIntervalTest(){
        int taskInterval = 10000;
        Assertions.assertEquals(GameMaster.getTaskInterval(), taskInterval);
    }

    @Test
    public void checkTasksCompletionTest(){
        // JUnit test for exceptions
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

    }
}
