package controller;

import usecases.ClickTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Random;

/**
 * The ClickTaskControllerTest class checks methods in
 * ClickTaskController.java.
 *
 * @author Siyuan Deng
 */
public class ClickTaskControllerTest {

    /**
     * Tests if the setNeededClicks in ClickTaskController.java passes on the
     * correct values between ClickTask and ClickTaskView.
     */
    @Test
    public void setNeededClicksTest(){
        ClickTaskController.setNeededClicks();
        int expected = ClickTask.getNeededClicks();
        int actual = ClickTaskController.getNeededClicks();
        int upperbound = ClickTask.getUpperbound();
        Assertions.assertTrue(actual > 0);
        Assertions.assertTrue(actual < upperbound);
        Assertions.assertEquals(expected, actual);
    }

    /**
     * Tests if the setCurrentClicks in ClickTaskController.java passes on the
     * correct values between ClickTask and ClickTaskView.
     */
    @Test
    public void setCurrentClicksTest(){
        Random ranCur = new Random();
        int upperbound = ClickTask.getUpperbound();
        int currentClicks = ranCur.nextInt(upperbound - 1) + 1;
        ClickTask.setCurrentClicks(currentClicks);
        Assertions.assertEquals(currentClicks, ClickTaskController.getCurrentClicks());
    }

    /**
     * Tests if the getNeededClicks in ClickTaskController.java passes on the
     * correct values between ClickTask and ClickTaskView.
     */
    @Test
    public void getNeededClicksTest(){
        ClickTask.setNeededClicks();
        int expected = ClickTask.neededClicks;
        int actual = ClickTaskController.getNeededClicks();
        Assertions.assertEquals(expected, actual);
    }

    /**
     * Tests if the getPortion in ClickTaskController.java passes on the
     * correct values between ClickTask and ClickTaskView.
     */
    @Test
    public void getPortionTest(){
        Random ranCur = new Random();
        int upperbound = ClickTask.getUpperbound();
        int currentClicks = ranCur.nextInt(upperbound - 1) + 1;
        ClickTaskController.setCurrentClicks(currentClicks);
        boolean expected = ClickTask.portion;
        boolean actual = ClickTaskController.getPortion();
        Assertions.assertEquals(expected, actual);
    }

    /**
     * Tests if the reset method in ClickTaskController.java does generate
     * a new Click Task in ClickTask.java.
     */
    @Test
    public void resetTest(){
        ClickTask.setNeededClicks();
        Random ranCur = new Random();
        int upperbound = ClickTask.getUpperbound();
        int oldCurrentClicks = ranCur.nextInt(upperbound - 1) + 1;
        ClickTaskController.setCurrentClicks(oldCurrentClicks);
        ClickTaskController.reset();
        int currentClicks = ClickTaskController.getCurrentClicks();
        Assertions.assertEquals(0, currentClicks);
    }

    /**
     * Tests if the setCompletionStatus method in ClickTaskController.java makes
     * completion status of ClickTask true if told so.
     */
    @Test
    public void setCompletionStatusTrueTest(){
        ClickTaskController.setCompletionStatus(true);
        Assertions.assertTrue(ClickTask.getCompletionStatus("ClickTask"));
    }

    /**
     * Tests if the setCompletionStatus method in ClickTaskController.java makes
     * completion status of ClickTask false if told so.
     */
    @Test
    public void setCompletionStatusFalseTest(){
        ClickTaskController.setCompletionStatus(false);
        Assertions.assertFalse(ClickTask.getCompletionStatus("ClickTask"));
    }

    /**
     * Tests if the setActivatedStatus method in ClickTaskController.java makes
     * activated status of ClickTask true if told so.
     */
    @Test
    public void setActivatedStatusTrueTest(){
        ClickTaskController.setActivatedStatus(true);
        Assertions.assertTrue(ClickTask.getActivatedStatus("ClickTask"));
    }

    /**
     * Tests if the setActivatedStatus method in ClickTaskController.java makes
     * activated status of ClickTask false if told so.
     */
    @Test
    public void setActivatedStatusFalseTest(){
        ClickTaskController.setActivatedStatus(false);
        Assertions.assertFalse(ClickTask.getActivatedStatus("ClickTask"));
    }

    /**
     * Tests if the getActivatedStatus method in ClickTaskController.java passes
     * the correct information between ClickTaskView and ClickTask when activated
     * status is true.
     */
    @Test
    public void getActivatedStatusTrueTest(){
        ClickTaskController.setActivatedStatus(true);
        Assertions.assertTrue(ClickTaskController.getActivatedStatus());
    }

    /**
     * Tests if the getActivatedStatus method in ClickTaskController.java passes
     * the correct information between ClickTaskView and ClickTask when activated
     * status is false.
     */
    @Test
    public void getActivatedStatusFalseTest(){
        ClickTaskController.setActivatedStatus(false);
        Assertions.assertFalse(ClickTaskController.getActivatedStatus());
    }
}
