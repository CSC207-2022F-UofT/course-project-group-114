package use_cases;

import org.junit.jupiter.api.Test;


/**
 * Class representing tests for HeatAdjustmentTask use case class.
 *
 * @author Elena Scobici
 */
public class HeatAdjustmentTaskTest {
    /**
     * Test that, when the HeatAdjustmentTask is reset, its answerTemp value is between 0 and 30.
     */
    @Test
    void testResetAnswerTempRange() {
        HeatAdjustmentTask.reset();
        assert(HeatAdjustmentTask.getAnswerTemp() >= 0 && HeatAdjustmentTask.getAnswerTemp() <= 30);
    }

    /**
     * Test that, when the HeatAdjustmentTask is reset, its currentTemp value is between 0 and 30.
     */
    @Test
    void testResetCurrentTempRange() {
        HeatAdjustmentTask.reset();
        assert(HeatAdjustmentTask.getCurrentTemp() >= 0 && HeatAdjustmentTask.getCurrentTemp() <= 30);
    }

    /**
     * Test that, when the HeatAdjustmentTask is reset, its answer and current temperatures are not equal.
     */
    @Test
    void testResetAnswerCurrentTempInequality() {
        HeatAdjustmentTask.reset();
        assert(HeatAdjustmentTask.getAnswerTemp() != HeatAdjustmentTask.getCurrentTemp());
    }

    /**
     * Test that the setCurrentTemp method correctly sets the value of HeatAdjustmentTask.currentTemp.
     * Note: the value of 31 is being used to avoid the possibility that the method does not work but the random
     * temperature happens to coincide with the test temperature.
     */
    @Test
    void testSetCurrentTempValueSetting() {
        HeatAdjustmentTask.reset();
        HeatAdjustmentTask.setCurrentTemp(31);
        assert(HeatAdjustmentTask.getCurrentTemp() == 31);
    }

    /**
     * Test that the setCurrentTemp method returns true when the currentTemp matches the answerTemp.
     */
    @Test
    void testSetCurrentTempReturnTrue() {
        HeatAdjustmentTask.reset();
        boolean ans = HeatAdjustmentTask.setCurrentTemp(HeatAdjustmentTask.getAnswerTemp());
        assert(ans);
    }

    /**
     * Test that the setCurrentTemp method returns false when the currentTemp does not match the answerTemp.
     */
    @Test
    void testSetCurrentTempReturnFalse() {
        HeatAdjustmentTask.reset();
        boolean ans = HeatAdjustmentTask.setCurrentTemp(HeatAdjustmentTask.getCurrentTemp());
        assert(!ans);
    }
}
