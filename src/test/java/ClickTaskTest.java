import usecases.ClickTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Random;


/**
 * The ClickTaskTest class checks methods in ClickTask.java.
 *
 * @author Siyuan Deng
 * @version 2.0
 * @since 2022-11-24
 */
public class ClickTaskTest {

    @Test
    public void setNeededClicksTest(){
        ClickTask.setNeededClicks();
        int neededClicks = ClickTask.neededClicks;
        boolean meetsReq = neededClicks < ClickTask.getUpperbound() && neededClicks != 0;
        Assertions.assertTrue(meetsReq);
    }

    @Test
    public void getNeededClicksTest(){
        ClickTask.setNeededClicks();
        Assertions.assertEquals(ClickTask.neededClicks, ClickTask.getNeededClicks());
    }

    @Test
    public void setCurrentClicksSettingTest(){
        Random newNeed = new Random();
        int expected = newNeed.nextInt(ClickTask.getUpperbound());
        ClickTask.setCurrentClicks(expected);
        Assertions.assertEquals(expected, ClickTask.currentClicks);
    }

    @Test
    public void setCurrentClicksPortionTest(){
        Random rand = new Random();
        ClickTask.setNeededClicks();
        int needed = ClickTask.getNeededClicks();
        int current = rand.nextInt(ClickTask.getUpperbound() - 1);
        ClickTask.setCurrentClicks(current);
        boolean expected = needed / 2 <= current;
        boolean actual = ClickTask.portion;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void resetTest(){
        ClickTask.setNeededClicks();
        Random cur = new Random();
        int tempCur = cur.nextInt(ClickTask.getUpperbound() - 1);
        ClickTask.setCurrentClicks(tempCur);
        ClickTask.reset();
        Assertions.assertEquals(0, ClickTask.currentClicks);
    }
}
