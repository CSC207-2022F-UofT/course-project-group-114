import entities.ClickTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Random;


/**
 * The ClickTaskTest class checks methods in ClickTask.java.
 *
 * @author Siyuan Deng
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
        Random cur = new Random();
        int tempCur = cur.nextInt(ClickTask.getUpperbound() - 1);
        boolean expected = tempCur <= ClickTask.getUpperbound() / 2;
        ClickTask.setCurrentClicks(tempCur);
        Assertions.assertEquals(expected, ClickTask.portion);
    }

    @Test
    public void resetTest(){
        ClickTask.setNeededClicks();
        Random cur = new Random();
        int tempCur = cur.nextInt(ClickTask.getUpperbound() - 1);
        ClickTask.setCurrentClicks(tempCur);
        ClickTask.reset();
        Assertions.assertEquals(0, ClickTask.currentClicks);
        Assertions.assertEquals(0,ClickTask.neededClicks);
    }
}
