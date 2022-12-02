import org.junit.jupiter.api.Test;

import view.HeatAdjustmentTaskView;
import usecases.HeatAdjustmentTask;

/**
 * Class representing the tests for the HeatAdjustmentView class.
 *
 * @author Elena Scobici
 */

public class HeatAdjustmentTaskViewTest {
    /**
     * Test that, when arrowClicked is called with a value of 1, the current temperature of the HeatAdjustmentTask
     * class increases by 1.
     */
    @Test
    void testArrowClickedUp() {
        HeatAdjustmentTask.reset();
        int initialCurrentTemp = HeatAdjustmentTask.getCurrentTemp();
        HeatAdjustmentTaskView view = new HeatAdjustmentTaskView();
        view.arrowClicked(1);
        assert(initialCurrentTemp + 1 == HeatAdjustmentTask.getCurrentTemp());
    }

    /**
     * Test that, when arrowClicked is called with a value of -1, the current temperature of the HeatAdjustmentTask
     * class decreases by 1.
     */
    @Test
    void testArrowClickedDown() {
        HeatAdjustmentTask.reset();
        int initialCurrentTemp = HeatAdjustmentTask.getCurrentTemp();
        HeatAdjustmentTaskView view = new HeatAdjustmentTaskView();
        view.arrowClicked(-1);
        assert(initialCurrentTemp - 1 == HeatAdjustmentTask.getCurrentTemp());
    }
}
