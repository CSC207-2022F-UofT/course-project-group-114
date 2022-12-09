package use_cases;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * Class representing tests for the LifeMaster use case class.
 *
 * @author Elena Scobici
 */

public class LifeMasterTest {
    /**
     * Test that the value of LifeMaster.getLives() changes correctly when 1 life is deducted from the initial state.
     */
    @Test
    void testDeductLifeInitialLifeLost() {
        LifeMaster.reset();
        int initialLives = LifeMaster.getLives();
        LifeMaster.deductLife();
        assert(initialLives == LifeMaster.getLives() + 1);
    }

    /**
     * Test that the initial task count is 0.
     */
    @Test
    void testLifeMasterInitialTaskCount() {
        LifeMaster.reset();
        assert(LifeMaster.getTaskCount() == 0);
    }

    /**
     * Test that, if we call incrementTaskCount() a random number of times, that number will be the value of
     * LifeMaster.getTaskCount().
     */
    @Test
    void testIncrementTaskCountRand() {
        LifeMaster.reset();
        Random rand = new Random();
        int randInt = rand.nextInt(20);
        for (int i = 0; i < randInt; i++) {
            LifeMaster.incrementTaskCount();
        }
        assert(LifeMaster.getTaskCount() == randInt);
    }
}
