import org.junit.jupiter.api.Test;

import usecases.HeatAdjustmentTask;
import controller.HeatAdjustmentTaskController;

/**
 * Class representing the tests for the HeatAdjustmentTaskController class.
 *
 * @author Elena Scobici
 */

public class HeatAdjustmentTaskControllerTest {
    /**
     * Test that the HeatAdjustmentTaskController changeCurrentTemp method correctly changes the value of the
     * currentTemp value in the HeatAdjustmentTask class.
     */
    @Test
    void testChangeCurrentTempValueCorrectness() {
        int originalCurrentTemp = HeatAdjustmentTask.getCurrentTemp();
        HeatAdjustmentTask.setCompletionStatus("HeatAdjustmentTask", false);
        HeatAdjustmentTaskController.changeCurrentTemp(1);
        assert(HeatAdjustmentTask.getCurrentTemp() == originalCurrentTemp + 1);
    }

    /**
     * Test that the HeatAdjustmentTaskController changeCurrentTemp method returns false when the currentTemp of the
     * HeatAdjustmentTask class is not equal to the class's answerTemp. This can be checked by not changing the
     * currentTemp (changing it by 0) as, when reset, the current and answer temperatures cannot be equal.
     */
    @Test
    void testChangeCurrentTempReturnCorrectnessFalse() {
        HeatAdjustmentTask.reset();
        assert(!HeatAdjustmentTaskController.changeCurrentTemp(0));
    }

    /**
     * Test that the HeatAdjustmentTaskController changeCurrentTemp method returns true when the currentTemp of the
     * HeatAdjustmentTask class is equal to the class's answerTemp. This can be checked by changing currentTemp by
     * (answerTemp - currentTemp), which is equal to answerTemp.
     */
    @Test
    void testChangeCurrentTempReturnCorrectnessTrue() {
        assert(HeatAdjustmentTaskController.changeCurrentTemp(HeatAdjustmentTask.getAnswerTemp()
                - HeatAdjustmentTask.getCurrentTemp()));
    }

    /**
     * Test that the HeatAdjustmentTaskController setCompletionStatus method correctly sets the HeatAdjustmentTask
     * class's completionStatus to true.
     */
    @Test
    void testSetCompletionStatusTrue() {
        HeatAdjustmentTask.setCompletionStatus("HeatAdjustmentTask", false);
        HeatAdjustmentTaskController.setCompletionStatus(true);
        assert(HeatAdjustmentTask.getCompletionStatus("HeatAdjustmentTask"));
    }

    /**
     * Test that the HeatAdjustmentTaskController setCompletionStatus method correctly sets the HeatAdjustmentTask
     * class's completionStatus to false.
     */
    @Test
    void testSetCompletionStatusFalse() {
        HeatAdjustmentTask.setCompletionStatus("HeatAdjustmentTask", true);
        HeatAdjustmentTaskController.setCompletionStatus(false);
        assert(!HeatAdjustmentTask.getCompletionStatus("HeatAdjustmentTask"));
    }

    /**
     * Test that the HeatAdjustmentTaskController setActivationStatus method correctly sets the HeatAdjustmentTask
     * class's activatedStatus to true.
     */
    @Test
    void testSetActivatedStatusTrue() {
        HeatAdjustmentTask.setActivatedStatus("HeatAdjustmentTask", false);
        HeatAdjustmentTaskController.setActivationStatus(true);
        assert(HeatAdjustmentTask.getActivatedStatus("HeatAdjustmentTask"));
    }

    /**
     * Test that the HeatAdjustmentTaskController setActivationStatus method correctly sets the HeatAdjustmentTask
     * class's activatedStatus to false.
     */
    @Test
    void testSetActivatedStatusFalse() {
        HeatAdjustmentTask.setActivatedStatus("HeatAdjustmentTask", true);
        HeatAdjustmentTaskController.setActivationStatus(false);
        assert(!HeatAdjustmentTask.getActivatedStatus("HeatAdjustmentTask"));
    }
}
