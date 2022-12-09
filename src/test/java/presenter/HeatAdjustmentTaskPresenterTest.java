package presenter;

import org.junit.jupiter.api.Test;

import usecases.HeatAdjustmentTask;
import presenter.HeatAdjustmentTaskPresenter;
/**
 * Class representing the tests for the HeatAdjustmentTaskPresenter class.
 *
 * @author Elena Scobici
 */
public class HeatAdjustmentTaskPresenterTest {
    /**
     * Test that the HeatAdjustmentTaskPresenter getAnswerTemp method correctly returns the value of the answerTemp
     * variable of the HeatAdjustmentTask class.
     */
    @Test
    void testGetAnswerTemp() {
        HeatAdjustmentTask.reset();
        int actualAnswerTemp = HeatAdjustmentTask.getAnswerTemp();
        assert(actualAnswerTemp == HeatAdjustmentTaskPresenter.getAnswerTemp());
    }

    /**
     * Test that the HeatAdjustmentTaskPresenter getCurrentTemp method correctly returns the value of the currentTemp
     * variable of the HeatAdjustmentTask class.
     */
    @Test
    void testGetCurrentTemp() {
        HeatAdjustmentTask.reset();
        int actualCurrentTemp = HeatAdjustmentTask.getCurrentTemp();
        assert(actualCurrentTemp == HeatAdjustmentTaskPresenter.getCurrentTemp());
    }

    /**
     * Test that the HeatAdjustmentTaskPresenter getActivatedStatus method correctly returns the value of
     * the activatedStatus variable of the HeatAdjustmentTask class when it is true.
     */
    @Test
    void testGetActivatedStatusTrue() {
        HeatAdjustmentTask.setActivatedStatus("HeatAdjustmentTask", true);
        assert(HeatAdjustmentTaskPresenter.getActivatedStatus());
    }

    /**
     * Test that the HeatAdjustmentTaskPresenter getActivatedStatus method correctly returns the value of
     * the activatedStatus variable of the HeatAdjustmentTask class when it is false.
     */
    @Test
    void testGetActivatedStatusFalse() {
        HeatAdjustmentTask.setActivatedStatus("HeatAdjustmentTask", false);
        assert(!HeatAdjustmentTaskPresenter.getActivatedStatus());
    }
}
