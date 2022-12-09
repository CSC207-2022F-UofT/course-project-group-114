package usecases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Random;


/**
 * The usecases.ClickTaskTest class checks methods in ClickTask.java.
 *
 * @author Siyuan Deng
 */
public class ClickTaskTest {

    /**
     * Tests if the setNeededClicks method correctly generates a random number
     * and makes it the neededClicks instance of the Click Task class.
     */
    @Test
    public void setNeededClicksTest(){
        ClickTask.setNeededClicks();
        int neededClicks = ClickTask.neededClicks;
        boolean meetsReq = neededClicks < ClickTask.getUpperbound() && neededClicks != 0;
        Assertions.assertTrue(meetsReq);
    }

    /**
     * Tests if the getNeededClicks method returns the correct number of clicks.
     */
    @Test
    public void getNeededClicksTest(){
        ClickTask.setNeededClicks();
        Assertions.assertEquals(ClickTask.neededClicks, ClickTask.getNeededClicks());
    }

    /**
     * Tests if the setCurrentClicks method sets the correct number of currentClicks
     * in the Click Task class.
     */
    @Test
    public void setCurrentClicksSettingTest(){
        Random newNeed = new Random();
        int expected = newNeed.nextInt(ClickTask.getUpperbound());
        ClickTask.setCurrentClicks(expected);
        Assertions.assertEquals(expected, ClickTask.currentClicks);
    }

    /**
     * This tests if the setCurrentClicks method changes the boolean instance portion
     * correctly in the Click Task class in general.
     */
    @Test
    public void setCurrentClicksPortionGeneralTest(){
        Random rand = new Random();
        ClickTask.setNeededClicks();
        int needed = ClickTask.getNeededClicks();
        int current = rand.nextInt(ClickTask.getUpperbound() - 1) + 1;
        ClickTask.setCurrentClicks(current);
        boolean expected = needed / 2 <= current;
        boolean actual = ClickTask.portion;
        Assertions.assertEquals(expected, actual);
    }

    /**
     * This tests if the setCurrentClicks method changes the boolean instance portion
     * correctly in the Click Task class when the number of currentClicks are exactly
     * half of the number of neededClicks.
     */
    @Test
    public void setCurrentClicksPortionDivisionTest(){
        ClickTask.setNeededClicks();
        int needed = ClickTask.getNeededClicks();
        int current = needed / 2;
        ClickTask.setCurrentClicks(current);
        Assertions.assertTrue(ClickTask.portion);
    }

    /**
     * This tests if the reset method correctly generates a new neededClicks
     * and make currentClicks 0 when it is called.
     */
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
